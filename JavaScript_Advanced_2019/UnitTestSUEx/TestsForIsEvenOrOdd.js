function isOddOrEven(string) {
    if (typeof (string) !== 'string') {
        return undefined;
    }
    if (string.length % 2 === 0) {
        return "even";
    }

    return "odd";
}

let  expect = require('chai').expect;


describe('Testing isOddOrEven', function () {
    describe('Testing return undefined with wrong params', function () {
        it('should return undefined with number arg', function () {
            expect(isOddOrEven(5)).to.be.equal(undefined);
        });
        it('should return undefined with object arg', function () {
            expect(isOddOrEven({})).to.be.equal(undefined);
        });
    });
    describe('Testing with correct string arguments', function () {
        it('should return even with string with even length', function () {
            expect(isOddOrEven('NY'))
                .to.be.equal('even');
        });
        it('should return odd with strign with odd length', function () {
            expect(isOddOrEven('NYC'))
                .to.be.equal('odd');
        });
    })
});