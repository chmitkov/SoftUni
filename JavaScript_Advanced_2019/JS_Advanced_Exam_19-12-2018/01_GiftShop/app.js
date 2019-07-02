function solution() {
    const ELEMENTS = {
        typeInput: document.getElementById('toyType'),
        priceInput: document.getElementById('toyPrice'),
        descriptionInput: document.getElementById('toyDescription'),
        addButton: document.querySelector('button'),
        giftsDiv: document.getElementById('christmasGiftShop'),
    };

    ELEMENTS.addButton.addEventListener('click', addFunction);

    function addFunction() {
        let type = ELEMENTS.typeInput.value;
        let price = +ELEMENTS.priceInput.value;
        let description = ELEMENTS.descriptionInput.value;

        if (type !== '' && !isNaN(price)
            && description.length <= 50) {

            createGift(type, price, description);

            clearInputField();
        }
    }

    function createGift(type, price, description) {
        let divElement = document.createElement('div');
        divElement.classList.add('gift');
        let imgElement = document.createElement('img');
        imgElement.src = 'gift.png';
        let h2Element = document.createElement('h2');
        h2Element.textContent = type;
        let pElement = document.createElement('p');
        pElement.textContent = description;
        let buttonElement = document.createElement('button');
        buttonElement.textContent = `Buy it for $${price.toFixed(2)}`;
        buttonElement.addEventListener('click', removeMe);


        divElement.appendChild(imgElement);
        divElement.appendChild(h2Element);
        divElement.appendChild(pElement);
        divElement.appendChild(buttonElement);

        ELEMENTS.giftsDiv.appendChild(divElement);
    }

    function removeMe() {
        this.parentNode.remove();
    }

    function clearInputField() {
        ELEMENTS.typeInput.value = '';
        ELEMENTS.priceInput.value = '';
        ELEMENTS.descriptionInput.value = '';
    }


}