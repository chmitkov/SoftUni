function realEstateAgency() {
    let ELEMENTS = {
        'rentPriceInput': document.querySelector('#regOffer > input[type=text]:nth-child(2)'),
        'apartTypeInput': document.querySelector('#regOffer > input[type=text]:nth-child(3)'),
        'commissionRentInput': document.querySelector('#regOffer > input[type=text]:nth-child(4)'),
        'regOfferButton': document.querySelector('#regOffer > button'),
        'familyBudgetInput': document.querySelector('#findOffer > input[type=text]:nth-child(2)'),
        'findApartTypeInput': document.querySelector('#findOffer > input[type=text]:nth-child(3)'),
        'familyNameInput': document.querySelector('#findOffer > input[type=text]:nth-child(4)'),
        'findButton': document.querySelector('#findOffer > button'),
        'messageP': document.getElementById('message'),
        'buildingDiv': document.getElementById('building'),
        'profitH1': document.querySelector('#roof > h1'),
    };

    const validateRegOfferFields = function () {
        return !(isNaN(ELEMENTS.rentPriceInput.value) || isNaN(ELEMENTS.commissionRentInput.value)
            || +ELEMENTS.rentPriceInput.value <= 0 || +ELEMENTS.commissionRentInput.value < 0
            || +ELEMENTS.commissionRentInput.value > 100
            || ELEMENTS.apartTypeInput.value.includes(':')
            || ELEMENTS.apartTypeInput.value === '');
    };
    const validateFindOfferFields = function () {
        return +ELEMENTS.familyBudgetInput.value > 0
            && ELEMENTS.findApartTypeInput.value !== ''
            && ELEMENTS.familyNameInput.value !== '';
    };


    const regFunc = function () {
        if (!validateRegOfferFields()) {
            ELEMENTS.messageP.textContent = 'Your offer registration went wrong, try again.';
        } else {
            postNewOffer(+ELEMENTS.rentPriceInput.value,
                ELEMENTS.apartTypeInput.value, +ELEMENTS.commissionRentInput.value);
            ELEMENTS.messageP.textContent = 'Your offer was created successfully.';
        }
        clearInput('register');
    };

    ELEMENTS.regOfferButton.addEventListener('click', regFunc);

    ELEMENTS.findButton.addEventListener('click', findFunc);


    function findFunc() {
        if (!validateFindOfferFields()) {
            //todo
        }
        for (const div of ELEMENTS.buildingDiv.children) {
            let currentRent = +div.children[0]
                .textContent.split(': ')[1];
            let currentType = div.children[1]
                .textContent.split(': ')[1];
            let currentCommission = +div.children[2]
                .textContent.split(': ')[1];
            let neededMoney = currentRent +
                currentRent * (currentCommission * 0.01);

            if (currentType === ELEMENTS.findApartTypeInput.value
                && neededMoney <= +ELEMENTS.familyBudgetInput.value) {

                getApartment(div);

                addProfit(currentRent * (currentCommission * 0.01));
            }
        }
    }


    function addProfit(profit) {
        let wordsArr = ELEMENTS.profitH1.textContent.split(' ');
        console.log('in');
        wordsArr[2] = +wordsArr[2] + profit;
        ELEMENTS.profitH1.textContent = wordsArr.join(' ');
    }

    function getApartment(div) {
        div.children[2].remove();
        div.children[0].textContent = ELEMENTS.familyNameInput.value;
        div.children[1].textContent = 'live here now';

        let button = document.createElement('button');
        button.textContent = 'MoveOut';
        button.addEventListener('click', function () {
            ELEMENTS.messageP.innerText = `They had found cockroaches in ${div.children[0].textContent}\'s apartment`
            this.parentElement.remove();
        });

        div.appendChild(button);

        ELEMENTS.messageP.textContent = 'Enjoy your new home! :))';
    }

    function postNewOffer(rent, apartType, commission) {
        let divElement = document.createElement('div');
        divElement.classList.add('apartment');
        let firstP = document.createElement('p');
        firstP.textContent = `Rent: ${rent}`;
        let secondP = document.createElement('p');
        secondP.textContent = `Type: ${apartType}`;
        let thirdP = document.createElement('p');
        thirdP.textContent = `Commission: ${commission}`;

        divElement.appendChild(firstP);
        divElement.appendChild(secondP);
        divElement.appendChild(thirdP);

        ELEMENTS.buildingDiv.appendChild(divElement);

    }

    function clearInput(type) {
        if (type === 'register') {
            ELEMENTS.rentPriceInput.value = '';
            ELEMENTS.apartTypeInput.value = '';
            ELEMENTS.commissionRentInput.value = '';
        } else {
            ELEMENTS.familyBudgetInput.value = '';
            ELEMENTS.findApartTypeInput.value = '';
            ELEMENTS.familyNameInput.value = '';
        }
    }

}