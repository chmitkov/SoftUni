const expect = require('chai').expect;

function isOddOrEven(string) {

    if (typeof (string) != 'string') {
        return undefined;
    }

    if (string.length % 2 === 0) {
        return 'even';
    }else{
        return 'odd';
    }
}


describe('isOddOrEven', function () {
    //if the parameter is not String (number);
    //if the parameter is not String (object);
    it('test with number paramete, should return undefined', function () {
        let expected = isOddOrEven(100);
        expect(expected).to.equal(undefined, "Function did not return correct result");
    });
});
