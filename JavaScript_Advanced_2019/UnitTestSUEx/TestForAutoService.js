class AutoService {

    constructor(garageCapacity) {
        this.garageCapacity = garageCapacity;
        this.workInProgress = [];
        this.backlogWork = [];
    }

    get availableSpace() {
        return this.garageCapacity - this.workInProgress.length;
    }

    repairCar() {

        let workingPlace = this.workInProgress.length > 0
            ? this.workInProgress : this.backlogWork;

        if (workingPlace.length > 0) {

            let keysForRepair = [];
            Object.keys(workingPlace[0].carInfo)
                .filter((k) => workingPlace[0].carInfo[k] === 'broken')
                .forEach((k) => keysForRepair.push(k));

            workingPlace.shift();
            if (keysForRepair.length > 0) {
                return `Your ${keysForRepair.join(' and ')} were repaired.`;
            } else {
                return 'Your car was fine, nothing was repaired.'
            }
        } else {
            return 'No clients, we are just chilling...'
        }
    }

    signUpForReview(clientName, plateNumber, carInfo) {

        let currentClient = {
            plateNumber,
            clientName,
            carInfo
        };

        if (this.availableSpace > 0) {
            this.workInProgress.push(currentClient);
        } else {
            this.backlogWork.push(currentClient);
        }
    }

    carInfo(plateNumber, clientName) {

        let checkCar =
            this.workInProgress.filter((carInfo) => carInfo.plateNumber === plateNumber && carInfo.clientName === clientName)[0] ||
            this.backlogWork.filter((carInfo) => carInfo.plateNumber === plateNumber && carInfo.clientName === clientName)[0];

        if (checkCar) {
            return checkCar;
        } else {
            return `There is no car with platenumber ${plateNumber} and owner ${clientName}.`;
        }
    }
}

let expect = require('chai').expect;

describe('Tests for Auto Service class', function () {
    let service;

    beforeEach('Create new instance of service before each test', function () {
        service = new AutoService(10);
    });

    describe('Constructor test', function () {
        it('should return new instance of Auto service', function () {
            expect(service.garageCapacity).to.be.equal(10);
            expect(service.workInProgress.length).to.be.equal(0);
            expect(service.backlogWork.length).to.be.equal(0);
        });
    });

    describe('Test get availableSpaces', function () {
        it('should return available space in service', function () {
            expect(service.availableSpace).to.be.equal(10);
        });
        it('should return 0 if service have not free space', function () {
            service = new AutoService(0);
            expect(service.availableSpace).to.be.equal(0);
        });
    })

    describe('Test singUpForReview funct ', function () {
        it(' test create client and add it to workInProgress', function () {
            service.signUpForReview('name', 'number', 'carInfo')
        });
        it(' test create client and add it to backLog', function () {

        });
    });
    
    
    describe('Test repair Car function', function () {
        it('should return No clients on new Instance', function () {
            expect(service.repairCar())
                .to.be.equal('No clients, we are just chilling...');
        });
        it('should ', function () {

        });
    });
});