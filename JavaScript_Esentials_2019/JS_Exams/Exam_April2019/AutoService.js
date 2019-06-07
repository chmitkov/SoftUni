function solve(inputArr) {
    let instructionsArray = [];
    let carPartsMap = [];

    // console.log(JSON.stringify(inputArr));

    for (let row of inputArr) {
        let commands = row.split(' ');
        switch (commands[0]) {
            case 'instructions':
                instructionsArray.push(commands[1]);
                break;
            case 'addPart':
                if (!carPartsMap.hasOwnProperty(commands[1])) {
                    carPartsMap[commands[1]] = [];
                }

                let part = {};
                part[commands[2]] = commands[3];
                carPartsMap[commands[1]].push(part);

                console.log(`${commands[1]} - {"${commands[2]}":["${commands[3]}"]}`);
                break;
            case 'repair':
                let carSpecObj = JSON.parse(commands[2]);
                if (!instructionsArray.includes(commands[1])) {
                    console.log(`${commands[1]} is not supported`)
                } else {
                    for (let parts in carSpecObj) {
                        if (carSpecObj[part] === 'broken') {
                            if (Object.keys(carPartsMap).includes(part)) {
                                carSpecObj[part] = carPartsMap[part];
                            }
                        }
                    }
                    console.log(`${commands[1]} client - ${JSON.stringify(carSpecObj)}`)
                }
                break;
        }
    }
}

solve([
    'instructions bmw',
    'addPart opel engine GV1399SSS',
    'addPart opel transmission SMF556SRG',
    'addPart bmw engine GV1399SSS',
    'addPart bmw transmission SMF444ORG',
    'addPart opel transmission SMF444ORG',
    'instructions opel',
    'repair opel {"engine":"broken","transmission":"OP8766TRS"}',
    'repair bmw {"engine":"ENG999FPH","transmission":"broken","wheels":"broken"}'
]
);