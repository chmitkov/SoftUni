let mathEnforcer = {
    addFive: function (num) {
        if (typeof (num) !== 'number') {
            return undefined;
        }
        return num + 5;
    },
    subtractTen: function (num) {
        if (typeof (num) !== 'number') {
            return undefined;
        }
        return num - 10;
    },
    sum: function (num1, num2) {
        if (typeof (num1) !== 'number' || typeof (num2) !== 'number') {
            return undefined;
        }
        return num1 + num2;
    }
};


let expect = require('chai').expect;

describe('Tests for Math Enforcer', function () {
    describe('Test for addFive functions', function () {
        it('should return undefined with string parameter', function () {
            expect(mathEnforcer.addFive("str"))
                .to.be.equal(undefined);
        });
        it('should return right result with 10 arguments', function () {
            expect(mathEnforcer.addFive(10))
                .to.be.equal(15);
        });
        it('should return right result with negative arguments', function () {
            expect(mathEnforcer.addFive(-10))
                .to.be.equal(-5);
        });
        it('should return right result with floating-point number', function () {
            expect(mathEnforcer.addFive(5.5))
                .to.be.closeTo(10.5, 0.01);
        });
    });
    describe('Test for subtractTen functions', function () {
        it('should return undefined with string parameter', function () {
            expect(mathEnforcer.subtractTen("str"))
                .to.be.equal(undefined);
        });
        it('should return right result with 10 arguments', function () {
            expect(mathEnforcer.subtractTen(10))
                .to.be.equal(0);
        });
        it('should return right result with negative arguments', function () {
            expect(mathEnforcer.subtractTen(-10))
                .to.be.equal(-20);
        });
        it('should return right result with floating-point number', function () {
            expect(mathEnforcer.subtractTen(5.5))
                .to.be.closeTo(-4.5, 0.01);
        });
    });
    describe('Test for sum functions', function () {
        it('should return undefined with wrong first argument', function () {
            expect(mathEnforcer.sum("str", 1))
                .to.be.equal(undefined);
        });
        it('should return undefined with wrong second argument', function () {
            expect(mathEnforcer.sum(1, "str"))
                .to.be.equal(undefined);
        });
        it('should return right result with floating-point number as first arg', function () {
            expect(mathEnforcer.sum(5.5, 5))
                .to.be.closeTo(10.5, 0.01);
        });
        it('should return right result with floating-point number as second arg', function () {
            expect(mathEnforcer.sum(5, 5.5))
                .to.be.closeTo(10.5, 0.01);
        });
        it('should return right result with negative numbers', function () {
            expect(mathEnforcer.sum(-5, -5))
                .to.be.equal(-10);
        });

    });
});