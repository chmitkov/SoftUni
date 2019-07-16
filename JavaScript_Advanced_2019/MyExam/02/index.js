class PizzUni {
    constructor() {
        this.registeredUsers = [];
        this.availableProducts = {
            pizzas: ['Italian Style', 'Barbeque Classic', 'Classic Margherita'],
            drinks: ['Coca-Cola', 'Fanta', 'Water']
        };
        this.orders = [];
    }

    registerUser(email) {

        const user = this.doesTheUserExist(email).length > 0;

        if (user) {
            throw new Error(`This email address (${email}) is already being used!`)
        }

        const currentUser = {
            email,
            orderHistory: []
        };

        this.registeredUsers.push(currentUser);

        return currentUser;
    }

    makeAnOrder(email, orderedPizza, orderedDrink) {

        const users = this.doesTheUserExist(email);

        if (users.length === 0) {
            throw new Error(`You must be registered to make orders!`);
        }

        const isThereAPizzaOrdered = this.availableProducts.pizzas.includes(orderedPizza);

        if (!isThereAPizzaOrdered) {
            throw new Error('You must order at least 1 Pizza to finish the order.');
        }

        let userOrder = {
            orderedPizza
        };

        const isThereADrinkOrdered = this.availableProducts.drinks.includes(orderedDrink);

        if (isThereADrinkOrdered) {
            userOrder.orderedDrink = orderedDrink;
        }

        users[0].orderHistory.push(userOrder);

        const currentOrder = {
            ...userOrder,
            email,
            status: 'pending'
        };
        this.orders.push(currentOrder);

        return this.orders.length - 1;
    }

    detailsAboutMyOrder(id) {
        if (this.orders[id]) {
            return `Status of your order: ${this.orders[id].status}`;
        }
    }

    doesTheUserExist(email) {
        return this.registeredUsers.filter((user) => user.email === email);
    }

    completeOrder() {
        if (this.orders.length > 0) {
            const index = this.orders.findIndex((o) => o.status === "pending");
            this.orders[index].status = 'completed';

            return this.orders[index];
        }
    }
}

module.exports = PizzUni;

let expect = require('chai').expect;

describe('Test Pizza', function () {
    let pizz ;
    
    beforeEach('Create new instance', function () {
        pizz = new PizzUni();
    });

    describe('Test constructor', function () {
        it('should make new instance', function () {
            expect(pizz.registeredUsers.length === 0);
            expect(pizz.orders.length === 0);
            expect(pizz.availableProducts.drinks.length === 3);
            expect(pizz.availableProducts.pizzas.length === 3);
        });
    });

    describe('Test registerUser function', function () {
        it('should throw exception', function () {
            pizz.registeredUsers.push({email:'mymail',orderHistory: [] });
            expect(()=>pizz.registerUser('mymail'))
                .to.throw(`This email address (mymail) is already being used!`);
        });
        it('should return new object and add it', function () {
            let result  = pizz.registerUser('mail');
            expect(pizz.registeredUsers.length === 1);
            expect(pizz.registeredUsers[0].email === 'mail');
            expect(pizz.registeredUsers[0].orderHistory.length === 1);
            expect(result.email ==='mail');
            expect(result.orderHistory === []);
            expect(result).to.deep.equal({ email: 'mail', orderHistory: [] })
        });
    });

    describe('Test makeAnOrder function', function () {
        it('should return error with non existing mail', function () {
            expect(()=> pizz.makeAnOrder('mail'))
                .to.throw('You must be registered to make orders!');
        });
        it('should return error with missing pizza', function () {
            pizz.registeredUsers.push({email:'mail',orderHistory: [] });
            expect(()=>pizz.makeAnOrder('mail', 'missingPizza'))
                .to.throw('You must order at least 1 Pizza to finish the order.');
        });
        it('should make full order', function () {
            pizz.registeredUsers.push({email:'mail',orderHistory: [] });
            let result = pizz.makeAnOrder('mail','Italian Style','Fanta');
            expect(pizz.orders.length === 1);
            expect(pizz.registeredUsers[0].orderHistory.length === 1);
            expect(pizz.orders[0].orderedPizza === 'Italian Style');
            expect(pizz.orders[0].orderedDrink === 'Fanta');
            expect(pizz.orders[0].status === 'pending');
            expect(pizz.orders[0].email === 'mail');
            expect(result === 0);
        });
        it('should make order only with pizza', function () {
            pizz.registeredUsers.push({email:'mail',orderHistory: [] });
            let result = pizz.makeAnOrder('mail','Italian Style');
            expect(pizz.orders[0].orderedPizza === 'Italian Style');
            expect(pizz.orders[0].status === 'pending');
            expect(pizz.orders[0].email === 'mail');
            expect(result === 0);
        });
    });

    describe('Test detailsAboutMyOrder function', function () {
        it('should return right ', function () {
            pizz.registerUser('mail', );
            pizz.makeAnOrder('mail','Italian Style', 'Fanta');
            expect(pizz.detailsAboutMyOrder(0))
                .to.be.equal('Status of your order: pending')
        });
        it('should return completed status', function () {
            pizz.registerUser('mail', );
            pizz.makeAnOrder('mail','Italian Style', 'Fanta');
            pizz.completeOrder();
            expect(pizz.detailsAboutMyOrder(0) === 'Status of your order: completed')
        });
        it('should retrun undefined', function () {
            expect(pizz.detailsAboutMyOrder(10)=== undefined);
        });
    });

    describe('Test complete order', function () {
        it('should retrun complete', function () {
            pizz.registerUser('mail', );
            pizz.makeAnOrder('mail','Italian Style', 'Fanta');
            let result = pizz.completeOrder();
            expect(result.status === 'completed');
            expect(result.orderedPizza === 'Italian Style');
            expect(result.orderedDrink === 'Fanta');
        });
    });

    describe('Test doesTheUserExist funct', function () {
        it('should retrun array', function () {
            pizz.registerUser('mail', );
            expect(pizz.doesTheUserExist('mail')[0]=== 'mail');
        });
    });
});