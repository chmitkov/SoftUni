class Kitchen {
    constructor(budget) {
        this.budget = +budget;
        this.menu = {};
        this.productsInStock = {};
        this.actionsHistory = [];

        return this;
    }

    loadProducts(productsArr) {

        for (const productRow of productsArr) {
            const tokens = productRow.split(' ');
            const productName = tokens[0];
            const quantity = +tokens[1];
            const price = +tokens[2];
            let result = '';

            if (this.budget >= price) {
                this.budget -= price;

                if (!this.productsInStock.hasOwnProperty(productName)) {
                    this.productsInStock[productName] = 0;
                }

                this.productsInStock[productName] += quantity;
                this.actionsHistory
                    .push(`Successfully loaded ${quantity} ${productName}`);
            } else {
                this.actionsHistory
                    .push(`There was not enough money to load ${quantity} ${productName}`);
            }
        }

        return this.actionsHistory.join('\n');
    }

    addToMenu(meal, neededProdArr, price) {
        let result;
        if (this.menu.hasOwnProperty(meal)) {
            this.actionsHistory.push(result = `The ${meal} is already in the our menu, try something different`);
            return result;
        }

        this.removeProduct(neededProdArr);

        this.menu[meal] = {price, neededProdArr};
        result = `Great idea! Now with the ${meal} we have ${Object.keys(this.menu).length} meals in the menu, other ideas?`;
        this.actionsHistory.push(result);
        return result;
    }

    showTheMenu() {
        return Object.keys(this.menu).length === 0
            ? 'Our menu is not ready yet, please come later...'
            : Object.keys(this.menu)
                .map(x => `${x} - $${this.menu[x].price}`)
                .join('\n')
                .trim();
    }

    haveAllNeedProd(neededProdArr) {
        for (const prod of neededProdArr) {
            let product = prod.split(' ')[0];
            let quantity = +prod.split(' ')[1];

            if (!this.productsInStock.hasOwnProperty(product)
                || this.productsInStock[product] < quantity) {
                return false;
            }
        }

        return true;
    }

    removeProduct(neededProdArr) {
        for (const prod of neededProdArr) {
            let name = prod.split(' ')[0];
            let quantity = +prod.split(' ')[1];

            if (this.productsInStock.hasOwnProperty(name)) {
                this.productsInStock[name] -= quantity;
            }
        }
    }

    makeTheOrder(meal) {

        let result = '';
        if (!this.menu.hasOwnProperty(meal)) {
            result = `There is not {meal} yet in our menu, do you want to order something else?`;
        } else if (!this.haveAllNeedProd(this.menu[meal].neededProdArr)) {
            result = `For the time being, we cannot complete your order (${meal}), we are very sorry...`;
        } else {
            this.removeProduct(this.menu[meal].neededProdArr);
            this.budget += this.menu[meal].price;
            result = `Your order (${meal}) will be completed in the next 30 minutes and will cost you ${this.menu[meal].price}.`;
        }

        this.actionsHistory.push(result);
        return result;

    }
}

let kitchen = new Kitchen(1000);
console.log(kitchen.loadProducts(['Banana 10 5', 'Banana 20 10', 'Strawberries 50 30', 'Yogurt 10 10', 'Yogurt 500 1500', 'Honey 5 50']));

console.log(kitchen.addToMenu('frozenYogurt', ['Yogurt 1', 'Honey 1', 'Banana 1', 'Strawberries 10'], 9.99));
console.log(kitchen.addToMenu('Pizza', ['Flour 0.5', 'Oil 0.2', 'Yeast 0.5', 'Salt 0.1', 'Sugar 0.1', 'Tomato sauce 0.5', 'Pepperoni 1', 'Cheese 1.5'], 15.55));
console.log(kitchen.showTheMenu());