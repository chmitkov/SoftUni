class Vacation {
    constructor(organizer, destination, budget) {
        this._organize = organizer;
        this._destination = destination;
        this._budget = budget;
        this._kids = {};
    }

    get numberOfChildren() {
        let number = 0;
        for (let grade in this._kids) {
            if (this._kids.hasOwnProperty(grade)) {
                number += this._kids[grade].length;
            }
        }
        return number;
    }

    registerChild(name, grade, budget) {


        if (budget < this._budget) {
            return `${name}'s money is not enough to go on vacation to ${this._destination}.`;
        }

        if (this._kids.hasOwnProperty(grade)
            && this._kids[grade].find(k=>k.name === name)) {
            return `${name} is already in the list for this ${this._destination} vacation.`
        }

        let kidObject = {name, grade, budget};

        this.pushKidIntoKids(kidObject);

        //[ 'Lilly-2100', 'Pesho-2400' ]
        return this._kids[grade]
            .map(k => `${k.name}-${k.budget}`);
    }

    removeChild(name, grade) {
        if (this._kids.hasOwnProperty(grade) && this._kids[grade]
            .find(k => k.name === name)) {
            this._kids[grade] = this._kids[grade]
                .filter(k => k.name !== name);

            return this._kids[grade]
                .map(k => `${k.name}-${k.budget}`);
        }

        return `We couldn't find ${name} in ${grade} grade.`
    }

    pushKidIntoKids(kid) {
        if (!this._kids.hasOwnProperty(kid.grade)) {
            this._kids[kid.grade] = [];
        }
        this._kids[kid.grade].push(kid);
    }

    toString() {

        if (this.numberOfChildren === 0) {
            return `No children are enrolled for the trip and the organization of ${this._organize} falls out...`;
        }

        let resultString = `${this._organize} will take ${this.numberOfChildren} children on trip to ${this._destination}`;

        Object.keys(this._kids)
            .sort((a, b) => a - b)
            .forEach(grade => {
                resultString += `\nGrade: ${grade}`;
                let counter = 0;
                this._kids[grade]
                    .forEach(k => {
                        resultString += `\n${++counter}. ${k.name}-${k.budget}`
                    });
            });

        return resultString+'\n';
    }
}

let vacation = new Vacation('Miss Elizabeth', 'Dubai', 2000);
vacation.registerChild('Gosho', 5, 3000);
vacation.registerChild('Lilly', 6, 1500);
vacation.registerChild('Pesho', 7, 4000);
vacation.registerChild('Tanya', 5, 5000);
vacation.registerChild('Mitko', 10, 5500);
console.log(vacation.toString());


