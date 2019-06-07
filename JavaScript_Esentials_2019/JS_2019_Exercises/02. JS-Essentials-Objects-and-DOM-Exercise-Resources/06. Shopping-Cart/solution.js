function solve() {
    let textAreaElement = document.getElementsByTagName('textarea')[0];
    // console.log(textAreaElement);
    let totalProducts = [];
    let totalPrice = 0;


    document.querySelector('body > div > div:nth-child(2) > div.product-add > button')
        .addEventListener('click', buyBreadBtnClick);
    document.querySelector('body > div > div:nth-child(3) > div.product-add > button')
        .addEventListener('click', buyMilkBtnClick);
    document.querySelector('body > div > div:nth-child(4) > div.product-add > button')
        .addEventListener('click', buyTomatoesBtnClick);

    function buyBreadBtnClick() {
        //textAreaElement.removeAttribute('disable');
        textAreaElement.value += makeString('Bread', 0.80);
        if (!totalProducts.includes('Bread')) {
            totalProducts.push('Bread');
        }
        totalPrice += 0.8;
    }

    function buyMilkBtnClick() {
        textAreaElement.value += makeString('Milk', 1.09);
        if (!totalProducts.includes('Milk')) {
            totalProducts.push('Milk');
        }
        totalPrice += 1.09;
    }

    function buyTomatoesBtnClick() {
        textAreaElement.value += makeString('Tomatoes', 0.99);
        if (!totalProducts.includes('Tomatoes')) {
            totalProducts.push('Tomatoes');
        }
        totalPrice += 0.99;
    }


    function makeString(product, price) {
        return `Added ${product} for ${price.toFixed(2)} to the cart.\n`
    }

    let checkoutBtn = document.getElementsByTagName('button')[3];
    checkoutBtn.addEventListener('click', checkoutFunc);

    function checkoutFunc() {
        textAreaElement.value += `You bought ${totalProducts.join(', ')} for ${totalPrice.toFixed(2)}.`;

    }
}