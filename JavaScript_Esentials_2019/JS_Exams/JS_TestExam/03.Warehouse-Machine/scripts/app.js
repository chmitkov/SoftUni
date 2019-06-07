function coffeeStorage(x, y) {
    let input = document.getElementsByTagName('textarea')[0].value;
    let reportParagraph = document.querySelector('body > section > div:nth-child(4) > p');
    let inspectionParagraph = document.querySelector('body > section > div:nth-child(6) > p');
    let repo = [];


    for (let c of JSON.parse(input)) {
        let command = c.split(', ');
        switch (command[0]) {
            case 'IN':
                inFunction(command);
                break;
            case 'OUT':
                outFunction(command);
                break;
            case 'REPORT':
                reportParagraph.innerHTML = report(command);
                break;
            case 'INSPECTION':
                inspectionParagraph.innerHTML = inspectionFunction(command);
                break;
        }
    }

    console.log(repo);


    function inspectionFunction(command) {
        let sortedRepo = repo.sort((a, b) => a.key.localeCompare(b.key));
        let resultString = '';
        for (let arr in sortedRepo) {
            resultString += `${arr}: `;
            let sortedArrOfObj = sortedRepo[arr]
                .sort((a, b) => b.quantity - a.quantity);

            for (let obj of sortedArrOfObj) {
                resultString += `${obj.make} - ${obj.date} - ${obj.quantity}. `
            }

            resultString.trimEnd();
            resultString += '<br>';
        }

        console.log(resultString);
        return resultString;
    }


    function outFunction(command) {
        let brand = command[1];
        let make = command[2];
        let date = command[3];
        let quantity = command[4];

        for (let repoKeys in repo) {
            if (repoKeys === brand) {
                for (let obj of repo[repoKeys]) {
                    if (obj.make === make &&
                        obj.date.localeCompare(date) >= 0 &&
                        obj.quantity >= quantity) {
                        obj.quantity -= quantity;
                    }
                }
            }
        }
    }

    function report(command) {
        //debugger;
        let resultString = '';
        for (let repoElement of Object.keys(repo)) {
            resultString += `${repoElement}: `;
            for (let makeObj of repo[repoElement]) {
                resultString += `${makeObj.make} - ${makeObj.date} - ${makeObj.quantity}. `
            }
            resultString.trimEnd();
            resultString += '<br>'
        }
        //console.log(resultString);
        return resultString;
    }

    function inFunction(command) {
        let brand = command[1];
        let make = command[2];
        let date = command[3];
        let quantity = +command[4];

        if (!Object.keys(repo).includes(brand)) {
            repo[brand] = [];
        }

        if (!checkIfExists(repo[brand], make)) {
            let obj = {};
            obj.make = make;
            obj.date = date;
            obj.quantity = quantity;
            repo[brand].push(obj);
        } else {
            let element = repo[brand].filter(x => x.make === make)[0];
            let resultOfComparing = element.date < date;
            //debugger;
            if (element.date < date) {
                repo[brand].splice(element, 1);
                let obj = {};
                obj.make = make;
                obj.date = date;
                obj.quantity = quantity;
                repo[brand].push(obj);
            } else if (element.date === date) {
                element.quantity += quantity;
            }
        }

    }

    function checkIfExists(repoElement, make) {
        for (let obj of repoElement) {
            if (obj.make === make) {
                return true;
            }
        }

        return false;
    }
}

coffeeStorage();