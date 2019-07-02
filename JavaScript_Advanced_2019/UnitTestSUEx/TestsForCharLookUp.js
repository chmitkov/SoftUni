function lookupChar(string, index) {
    if (typeof (string) !== 'string' || !Number.isInteger(index)) {
        return undefined;
    }
    if (string.length <= index || index < 0) {
        return "Incorrect index";
    }

    return string.charAt(index);
}

let expect = require('chai').expect;

describe('Test lookupChar function', function () {
    describe('Test with wrong arguments', function () {
        it('should return undefined with number', function () {
            expect(lookupChar(9, 9))
                .to.be.equal(undefined);
        });
        it('should return undefined with string as index', function () {
            expect(lookupChar("testString", "str"))
                .to.be.equal(undefined);
        });
        // it('should retrun udefined with floating point number', function () {
        //     expect(lookupChar("testString", 4,4))
        //         .to.be.equal(undefined);
        // });
    });
    describe('Test with incorrect index', function () {
        it('should return incorrect index with -1', function () {
            expect(lookupChar('testString', -1))
                .to.be.equal("Incorrect index");
        });
        it('should return incorrect index with big index 99', function () {
            expect(lookupChar("testString", 99))
                .to.be.equal("Incorrect index");
        });
    });
    describe('Test with correct arguments', function () {
        it('should return B from Bulgaria at index 0', function () {
            expect(lookupChar('Bulgaria', 0))
                .to.be.equal('B');
        });
    });
});