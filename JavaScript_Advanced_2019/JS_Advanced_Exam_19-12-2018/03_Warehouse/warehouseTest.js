class Warehouse {
    constructor(capacity) {
        this.capacity = capacity;
        this.availableProducts = {'Food': {}, 'Drink': {}};
    }

    get capacity() {
        return this._capacity;
    }

    set capacity(givenSpace) {

        if (typeof givenSpace === 'number' && givenSpace > 0) {
            return this._capacity = givenSpace;
        } else {
            throw `Invalid given warehouse space`;
        }
    }

    addProduct(type, product, quantity) {

        let addedQuantity = ((this.capacity - this.occupiedCapacity()) - quantity);
        let output;

        if (addedQuantity >= 0) {

            if (this.availableProducts[type].hasOwnProperty(product) === false) {
                this.availableProducts[type][product] = 0;
            }

            this.availableProducts[type][product] += quantity;
            output = this.availableProducts[type];

        } else {
            throw `There is not enough space or the warehouse is already full`;
        }

        return output;
    }

    orderProducts(type) {

        let output;
        let sortedKeys = Object.keys(this.availableProducts[type])
            .sort((a, b) => this.availableProducts[type][b] - this.availableProducts[type][a]);

        let newObj = {};

        for (let product of sortedKeys) {

            if (newObj.hasOwnProperty(product) === false) {
                newObj[product] = 0;
            }

            newObj[product] += this.availableProducts[type][product];
        }

        this.availableProducts[type] = newObj;
        output = this.availableProducts[type];

        return output;
    }

    occupiedCapacity() {

        let output = 0;
        let productsCount = Object.keys(this.availableProducts['Food']).length +
            Object.keys(this.availableProducts['Drink']).length;

        if (productsCount > 0) {

            let quantityInStock = 0;

            for (let type of Object.keys(this.availableProducts)) {

                for (let product of Object.keys(this.availableProducts[type])) {

                    quantityInStock += this.availableProducts[type][product];
                }
            }

            output = quantityInStock;
        }

        return output;
    }

    revision() {

        let output = "";

        if (this.occupiedCapacity() > 0) {

            for (let type of Object.keys(this.availableProducts)) {
                output += `Product type - [${type}]\n`;
                for (let product of Object.keys(this.availableProducts[type])) {
                    output += `- ${product} ${this.availableProducts[type][product]}\n`;
                }
            }
        } else {
            output = 'The warehouse is empty';
        }

        return output.trim();
    }

    scrapeAProduct(product, quantity) {

        let type = Object.keys(this.availableProducts).find(t => Object.keys(this.availableProducts[t]).includes(product));
        let output;

        if (type !== undefined) {

            if (quantity <= this.availableProducts[type][product]) {
                this.availableProducts[type][product] -= quantity;
            } else {
                this.availableProducts[type][product] = 0;
            }

            output = this.availableProducts[type];

        } else {
            throw `${product} do not exists`;
        }

        return output;
    }
}

let expect = require('chai').expect;

describe('Test for Warehouse class', function () {
    let warehouse;

    beforeEach('Create new instance before each test', function () {
        warehouse = new Warehouse(100);
    });

    describe('Test constructor', function () {
        it('should return new instance with capacity and {} as availableProducts',
            function () {
                expect(warehouse._capacity)
                    .to.be.equal(100);

                expect(warehouse.availableProducts.hasOwnProperty('Food')
                    && warehouse.availableProducts.hasOwnProperty('Drink'))
                    .to.be.equal(true);
            });
    });

    describe('Test get/set capacity method', function () {
        it('should return 100 as capacity', function () {
            expect(warehouse._capacity)
                .to.be.equal(100);
        });
        it('should return Invalid given warehouse space with string as argument', function () {
            expect(() => new Warehouse('str'))
                .to.throw('Invalid given warehouse space');
        });
        // it('should Invalid given warehouse space with negative argument', function () {
        //     expect(() => new Warehouse(-10))
        //         .to.throw('Invalid given warehouse space');
        // });
    });

    describe('Test addProduct function', function () {
        it('should return "There is not enough space or the warehouse is already full"', function () {
            expect(() => warehouse.addProduct('Food', 'ProductOne', 200))
                .to.throw('There is not enough space or the warehouse is already full');
        });
        it('should work correct and add new product', function () {
            warehouse.addProduct('Food', 'Product', 10);
            expect(warehouse.availableProducts['Food']['Product'])
                .to.be.equal(10);
        });
    });

    describe('Test orderProduct function', function () {
        it('should return sorted products', function () {
            warehouse.addProduct('Food', 'Product1', 10);
            warehouse.addProduct('Food', 'Product2', 20);

            expect(warehouse.orderProducts('Food'))
                .to.be.eql({Product2: 20, Product1: 10});
        });
    });

    describe('Test revision function', function () {
        it('should retrun "The warehouse is empty" with empty warehouse', function () {
            expect(warehouse.revision())
                .to.be.equal('The warehouse is empty');
        });

        it('should work correct with 2 products', function () {
            warehouse.addProduct('Food', 'ProductOne', 2);
            warehouse.addProduct('Drink', 'ProductTwo', 5);
            expect(warehouse.revision())
                .to.be.equal('Product type - [Food]\n- ProductOne 2\nProduct type - [Drink]\n- ProductTwo 5');
        });
    });

    describe('Test scrapeAProduct function', function () {
        it('should return "${product} do not exists"', function () {
            expect(()=>warehouse.scrapeAProduct('Apple', 2))
                .to.throw('Apple do not exists');
        });
        it('should work correct with remove products quantity', function () {
            warehouse.addProduct('Food','Apple',10);
            expect(warehouse.scrapeAProduct('Apple',5))
                .to.be.eql({ Apple: 5 });
            expect(warehouse.availableProducts['Food']['Apple'])
                .to.be.equal(5);
        });
    });
});

