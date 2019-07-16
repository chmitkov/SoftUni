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

        let workingPlace = this.workInProgress.length > 0 ? this.workInProgress : this.backlogWork;

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

describe('Test AutoService class', function () {
    let service;

    beforeEach('Create new instance of AutoService class', function () {
        service = new AutoService(10);
    });
    describe('Test constructor', function () {
        it('should return capacity 10', function () {
            expect(service.garageCapacity === 10);
            expect(service.backlogWork.length === 0);
            expect(service.workInProgress.length === 0);
        });
    });

    describe('Test availableSpace getter', function () {
        it('should retrun 10', function () {
            expect(service.availableSpace === 10);
        });
    });

    describe('Test signUpForReview function', function () {
        it('should add client to work in progres', function () {
            service.signUpForReview('Client', 'PlateNumb',
                {'engine': 'MFRGG23', 'transmission': 'FF4418ZZ', 'doors': 'broken'});
            expect(service.workInProgress.length === 1);
            expect(service.workInProgress[0].clientName === 'Client');
            expect(service.workInProgress[0].plateNumber === 'PlateNumb');
        });
        it('should add client to backlogWork', function () {
            service = new AutoService(0);
            service.signUpForReview('Client', 'PlateNumb',
                {'engine': 'MFRGG23', 'transmission': 'FF4418ZZ', 'doors': 'broken'});
            expect(service.backlogWork.length === 1);
            expect(service.backlogWork[0].clientName === 'Client');
            expect(service.backlogWork[0].plateNumber === 'PlateNumb');
        });
    });

    describe('Test carInfo function', function () {
        it('should return message if car is not exists', function () {
            expect(service.carInfo( 'PB9999PB', 'PHILIP'))
                .to.be.equal('There is no car with platenumber PB9999PB and owner PHILIP.')
        });
        it('should return return client information object', function () {
            service.signUpForReview('Client','9999', {});
            let clientObj = service.carInfo('9999','Client');
            expect(clientObj.clientName === 'Client');
            expect(clientObj.plateNumber === '9999');
        });
    });

    describe('Test repairCar function', function () {
        it('should return message if there are no cars in two arrays', function () {
            expect(service.repairCar())
                .to.be.equal('No clients, we are just chilling...');
        });
        it('should return message if there are no broken parts in car', function () {
            service.signUpForReview('Client', 'PlateNumb',
                {'engine': 'MFRGG23', 'transmission': 'FF4418ZZ',
                    'doors': 'MGF221'});
            expect(service.repairCar())
                .to.be.equal('Your car was fine, nothing was repaired.');
        });
        it('should retrun message with repair parts', function () {
            service.signUpForReview('Client', 'PlateNumb',
                {'engine': 'broken', 'transmission': 'FF4418ZZ',
                    'doors': 'broken'});
            expect(service.repairCar())
                .to.be.equal('Your engine and doors were repaired.');
        });
    });
});
