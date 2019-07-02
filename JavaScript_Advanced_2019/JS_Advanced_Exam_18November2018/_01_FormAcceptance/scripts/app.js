function acceptance() {
    const ELEMENTS = {
        companyElement: document.querySelector('#fields > td:nth-child(1) > input[type=text]'),
        productElement: document.querySelector('#fields > td:nth-child(2) > input[type=text]'),
        quantityElement: document.querySelector('#fields > td:nth-child(3) > input[type=text]'),
        scrapeElement: document.querySelector('#fields > td:nth-child(4) > input[type=text]'),
        buttonAddIt: document.getElementById('acceptance'),
        warehouseDiv: document.getElementById('warehouse'),
    };

    ELEMENTS.buttonAddIt.addEventListener('click', addIt);



    function addIt() {
        let company = ELEMENTS.companyElement.value;
        let product = ELEMENTS.productElement.value;
        let quantity = ELEMENTS.quantityElement.value;
        let scrape = ELEMENTS.scrapeElement.value;

        if (company !== '' && product !== ''
            && !isNaN(quantity) && !isNaN(scrape)
            && +quantity > +scrape) {

            clearInputs();

            let divElement = document.createElement('div');
            let pElement = document.createElement('p');
            pElement.textContent = `[${company}] ${product} - ${quantity - scrape} pieces`;
            let button = document.createElement('button');
            button.type = 'button';
            button.textContent = 'Out of stock';
            button.addEventListener('click', outOfStock);
            divElement.appendChild(pElement);
            divElement.appendChild(button);

            ELEMENTS.warehouseDiv.appendChild(divElement);
        }
    }

    function clearInputs() {
        ELEMENTS.companyElement.value = '';
        ELEMENTS.productElement.value = '';
        ELEMENTS.quantityElement.value = '';
        ELEMENTS.scrapeElement.value = '';
    }

    function outOfStock() {
        this.parentNode.remove();
    }
}