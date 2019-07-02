class HolidayPackage {
    constructor(destination, season) {
        this.vacationers = [];
        this.destination = destination;
        this.season = season;
        this.insuranceIncluded = false; // Default value
    }

    showVacationers() {
        if (this.vacationers.length > 0)
            return "Vacationers:\n" + this.vacationers.join("\n");
        else
            return "No vacationers are added yet";
    }

    addVacationer(vacationerName) {
        if (typeof vacationerName !== "string" || vacationerName === ' ') {
            throw new Error("Vacationer name must be a non-empty string");
        }
        if (vacationerName.split(" ").length !== 2) {
            throw new Error("Name must consist of first name and last name");
        }
        this.vacationers.push(vacationerName);
    }

    get insuranceIncluded() {
        return this._insuranceIncluded;
    }

    set insuranceIncluded(insurance) {
        if (typeof insurance !== 'boolean') {
            throw new Error("Insurance status must be a boolean");
        }
        this._insuranceIncluded = insurance;
    }

    generateHolidayPackage() {
        if (this.vacationers.length < 1) {
            throw new Error("There must be at least 1 vacationer added");
        }
        let totalPrice = this.vacationers.length * 400;

        if (this.season === "Summer" || this.season === "Winter") {
            totalPrice += 200;
        }

        totalPrice += this.insuranceIncluded === true ? 100 : 0;

        return "Holiday Package Generated\n" +
            "Destination: " + this.destination + "\n" +
            this.showVacationers() + "\n" +
            "Price: " + totalPrice;
    }
}

let expect = require('chai').expect;

describe('Tests for Holiday class', function () {
    let holiday;
    beforeEach('Create new instance of class', function () {
        holiday = new HolidayPackage('Sofia', 'Summer');
    });

    describe('Test constructor', function () {
        it('should return new instance', function () {
            expect(holiday.destination === 'Sofia');
            expect(holiday.season === 'Summer');
        });
    });
    describe('Test showVacationers function', function () {
        it('should return error message with 0 vacationers', function () {
            expect(holiday.showVacationers())
                .to.be.equal('No vacationers are added yet');
        });
        it('should return list from vacationers', function () {
            holiday.vacationers.push('FirstVac');
            holiday.vacationers.push('SecondVac');
            expect(holiday.showVacationers())
                .to.be.equal('Vacationers:\nFirstVac\nSecondVac');
        });
    });
    describe('Test addVacationer function', function () {
        it('should throw error with non string arg', function () {
            expect(() => holiday.addVacationer(5))
                .to.throw('Vacationer name must be a non-empty string')
        });
        it('should throw error with one white space', function () {
            expect(() => holiday.addVacationer(" "))
                .to.throw('Vacationer name must be a non-empty string')
        });
        it('should throw error whit only one name as arg', function () {
            expect(() => holiday.addVacationer("OnlyFirstName"))
                .to.throw('Name must consist of first name and last name')
        });
        it('should work correct and add a vacationer', function () {
            holiday.addVacationer('Ivan Ivanov');
            expect(holiday.vacationers.includes('Ivan Ivanov'));
        });
    });
    // describe('Test set InsuranceInclude', function () {
    //     it('should return error with non boolean arg', function () {
    //         expect(()=>holiday.proto)
    //             .to.throw('Insurance status must be a boolean');
    //     });
    //     it('should work correct', function () {
    //
    //     });
    // });
    describe('Test generateHolidayPackage function', function () {
        it('should throw error with 0 vacationers', function () {
            expect(() => holiday.generateHolidayPackage())
                .to.throw('There must be at least 1 vacationer added');
        });
        it('should work correct in Summer season', function () {
            holiday.season = 'Summer';
            holiday.vacationers.push('Ivan Ivanov');
            expect(holiday.generateHolidayPackage())
                .to.be.equal('Holiday Package Generated\nDestination: Sofia\nVacationers:\nIvan Ivanov\nPrice: 600');
        });
        it('should work correct in Spring season', function () {
            holiday.season = 'Spring';
            holiday.vacationers.push('Ivan Ivanov');
            expect(holiday.generateHolidayPackage())
                .to.be.equal('Holiday Package Generated\nDestination: Sofia\nVacationers:\nIvan Ivanov\nPrice: 400');
        });
        it('should work corret with insurance', function () {
            holiday.season = 'Winter';
            holiday.vacationers.push('Ivan Ivanov');
            holiday._insuranceIncluded = true;
            expect(holiday.generateHolidayPackage())
                .to.be.equal('Holiday Package Generated\nDestination: Sofia\nVacationers:\nIvan Ivanov\nPrice: 700');
        });
    });
});