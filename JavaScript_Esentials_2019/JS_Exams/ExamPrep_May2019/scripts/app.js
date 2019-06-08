function getData() {
    let input = document.getElementsByTagName('textarea')[0];

    let arrOfObj = JSON.parse(input.value);
    let peopleIn = [];
    let peopleOut = [];
    let blackList = [];
    let orderCriteria = arrOfObj.pop();

    let peopleInParagraph = document.querySelector('#peopleIn p');
    let peopleOutParagraph = document.querySelector('#peopleOut p');
    let blacklistParagraph = document.querySelector('#blacklist p');


    for (let obj of arrOfObj) {
        let person = {};
        person.firstName = obj.firstName;
        person.lastName = obj.lastName;
        if (obj.action === 'peopleIn') {
            peopleInFunction(person);
        } else if (obj.action === 'peopleOut') {
            peopleGoOut(person);
        } else if (obj.action === 'blacklist') {
            peopleGoInBlackList(person);
        }
    }

    if (orderCriteria.action === 'peopleIn') {
        orderArray(peopleIn, orderCriteria.criteria);
    } else if (orderCriteria.action === 'peopleOut') {
        orderArray(peopleOut, orderCriteria.criteria);
    } else if (orderCriteria.action === 'blacklist') {
        orderArray(blackList, orderCriteria.criteria)
    }

    peopleInParagraph.textContent = peopleIn
        .map(p => JSON.stringify(p))
        .join(' ');
    peopleOutParagraph.textContent = peopleOut
        .map(p => JSON.stringify(p))
        .join(' ');
    blacklistParagraph.textContent = blackList
        .map(p => JSON.stringify(p))
        .join(' ');

    function orderArray(arr, orderBy) {
        if (orderBy === 'firstName') {
            arr.sort((a, b) => a.firstName.localeCompare(b.firstName));
        } else {
            arr.sort((a, b) => a.lastName.localeCompare(b.lastName));
        }
    }

    function peopleGoInBlackList(obj) {
        blackList.push(obj);
        if (checkArrayForObj(peopleIn, obj)) {
            peopleIn.splice(obj, 1);
            peopleOut.push(obj);
        }

    }

    function peopleGoOut(obj) {
        if (checkArrayForObj(peopleIn, obj)) {
            peopleIn.splice(obj, 1);
            peopleOut.push(obj);
        }
    }

    function peopleInFunction(obj) {
        if (!checkArrayForObj(blackList, obj)) {
            peopleIn.push(obj);
        }
    }

    function checkArrayForObj(arr, obj) {
        let found = arr.filter(x => x.firstName === obj.firstName
            && x.lastName === obj.lastName);
        return found.length !== 0;
    }

}