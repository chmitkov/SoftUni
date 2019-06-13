function spaceshipCrafting() {
    let inputLossesPercent = document.getElementById('lossesPercent')
        .value * 0.01;
    //console.log(inputLossesPercent)
    inputLossesPercent /= 4;
    let inputTitaniumCore = document.getElementById('titaniumCoreFound').value;
    let inputAluminiumCore = document.getElementById('aluminiumCoreFound').value;
    let inputMagnesiumCore = document.getElementById('magnesiumCoreFound').value;
    let inputCarbonCore = document.getElementById('carbonCoreFound').value;

    inputTitaniumCore -= inputTitaniumCore * inputLossesPercent;
    inputAluminiumCore -= inputAluminiumCore * inputLossesPercent;
    inputMagnesiumCore -= inputMagnesiumCore * inputLossesPercent;
    inputCarbonCore -= inputCarbonCore * inputLossesPercent;

    let productMap = {};
    productMap['Titanium'] =  Math.round(inputTitaniumCore / 25);
    inputTitaniumCore -= productMap['Titanium'] * 25;
    productMap['Aluminum'] =  Math.round(inputAluminiumCore / 50);
    inputAluminiumCore -= productMap['Aluminium'] * 50;
    productMap['Magnesium'] =  Math.round(inputMagnesiumCore / 75);
    inputMagnesiumCore -= productMap['Magnesium'] * 75;
    productMap['Carbon'] = Math.round(inputCarbonCore / 100);
    inputCarbonCore -= productMap['Carbon'] * 100;

    let mapWithShips = {};
    let constructShip = true;
    while (constructShip) {
        constructShip = false;

        if (productMap.Titanium >= 7 && productMap.Aluminum >= 9 &&
            productMap.Magnesium >= 7 && productMap.Carbon >= 7) {

            productMap.Titanium -= 7;
            productMap.Aluminum -= 9;
            productMap.Magnesium -= 7;
            productMap.Carbon -= 7;
            constructShip = true;

            if (!mapWithShips.hasOwnProperty('The-Undefined-Ship')) {
                mapWithShips['The-Undefined-Ship'] = 0;
            }
            mapWithShips['The-Undefined-Ship'] += 1;
        }
        if (productMap.Titanium >= 5 && productMap.Aluminum >= 7 &&
            productMap.Magnesium >= 7 && productMap.Carbon >= 5) {

            productMap.Titanium -= 5;
            productMap.Aluminum -= 7;
            productMap.Magnesium -= 7;
            productMap.Carbon -= 5;
            constructShip = true;

            if (!mapWithShips.hasOwnProperty('Null-Master')) {
                mapWithShips['Null-Master'] = 0;
            }
            mapWithShips['Null-Master'] += 1;
        }
        if (productMap.Titanium >= 3 && productMap.Aluminum >= 5 &&
            productMap.Magnesium >= 5 && productMap.Carbon >= 2) {

            productMap.Titanium -= 3;
            productMap.Aluminum -= 5;
            productMap.Magnesium -= 5;
            productMap.Carbon -= 2;
            constructShip = true;

            if (!mapWithShips.hasOwnProperty('JSON-Crew')) {
                mapWithShips['JSON-Crew'] = 0;
            }
            mapWithShips['JSON-Crew'] += 1;
        }
        if (productMap.Titanium >= 2 && productMap.Aluminum >= 2 &&
            productMap.Magnesium >= 3 && productMap.Carbon >= 1) {

            productMap.Titanium -= 2;
            productMap.Aluminum -= 2;
            productMap.Magnesium -= 3;
            productMap.Carbon -= 1;
            constructShip = true;

            if (!mapWithShips.hasOwnProperty('False-Fleet')) {
                mapWithShips['False-Fleet'] = 0;
            }
            mapWithShips['False-Fleet'] += 1;
        }
    }

    let availableBarsElement = document.querySelector('#availableBars > p');
    availableBarsElement.textContent =
        `${productMap.Titanium} titanium bars, ${productMap.Aluminum} aluminum bars, ${productMap.Magnesium} magnesium bars, ${productMap.Carbon} carbon bars`
    //console.log(mapWithShips);

    let undefShip = mapWithShips['The-Undefined-Ship'];
    let masterShip = mapWithShips['Null-Master'];
    let jsonShip = mapWithShips['JSON-Crew'];
    let falseShip = mapWithShips['False-Fleet'];

    let resultStr = '';
    for(let ship in mapWithShips){
        if (mapWithShips[ship] >= 1 ){
            resultStr += `${mapWithShips[ship]} ${ship.toUpperCase()}, `;
        }
    }
    resultStr = resultStr.substring(0,resultStr.length-2);
    let builtShipsElement = document.querySelector('#builtSpaceships > p');
    builtShipsElement.textContent = resultStr;
        //`${undefShip} THE-UNDEFINED-SHIP, ${masterShip} NULL-MASTER, ${jsonShip} JSON-CREW, ${falseShip} FALSE-FLEET`;

}