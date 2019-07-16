function solve() {
    const inputKingdomName = document.querySelector('#kingdom > div > input[type=text]:nth-child(1)');
    const inputKingName = document.querySelector('#kingdom > div > input[type=text]:nth-child(2)');
    const buttonRebuildKingdom = document.querySelector('#kingdom > div > button');
    buttonRebuildKingdom
        .addEventListener('click', rebuildKingdom);
    const buttonJoin = document.querySelector('#characters > div:nth-child(4) > button');
        buttonJoin.addEventListener('click', joinFunc);

    function rebuildKingdom() {

        let possibleKingdoms = ['CASTLE', 'DUNGEON', 'FORTRESS', 'INFERNO',
            'NECROPOLIS', 'RAMPART', 'STRONGHOLD', 'TOWER', 'CONFLUX'];
        let kingdomName = inputKingdomName.value;
        let kingName = inputKingName.value;

        if (kingName.length > 2
            && possibleKingdoms.includes(kingdomName.toUpperCase())) {
            console.log('ok');

            let myCastleElement = document
                .getElementById(kingdomName.toLowerCase());
            let h1Element = document.createElement('h1');
            h1Element.textContent = kingdomName.toUpperCase();
            let divElement = document.createElement('div');
            divElement.classList.add(kingdomName.toLowerCase());
            let h2Element = document.createElement('h2');
            h2Element.textContent = kingName;

            let fieldSet = createEmptyFieldSet();
            myCastleElement.appendChild(h1Element);
            myCastleElement.appendChild(divElement);
            myCastleElement.appendChild(h2Element);
            myCastleElement.appendChild(fieldSet);
            myCastleElement.style.display = 'block';


        } else {
            inputKingName.value = '';
            inputKingdomName.value = '';
        }
    }
    function createEmptyFieldSet() {
        let fieldSetElement = document.createElement('fieldset');
        let legendElement = document.createElement('legend');
        legendElement.innerText = 'Army';
        let firstP = document.createElement('p');
        firstP.textContent = 'TANKS - 0';
        let thirdP = document.createElement('p');
        thirdP.textContent = 'MAGES - 0';
        let divElement = document.createElement('div');
        divElement.classList.add('armyOutput');
        let second = document.createElement('p');
        second.textContent = 'FIGHTERS - 0';

        fieldSetElement.appendChild(legendElement);
        fieldSetElement.appendChild(firstP);
        fieldSetElement.appendChild(second);
        fieldSetElement.appendChild(thirdP);
        fieldSetElement.appendChild(divElement);

        return fieldSetElement;
    }
    function joinFunc() {
        
    }
}

solve();


