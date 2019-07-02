class Vacationer {
    constructor(namesAsArray, creditCardArr) {
        this.fullName = namesAsArray;
        this.idNumber = this.generateIdNumber(namesAsArray);
        this.addCreditCardInfo(creditCardArr);
        this.wishList = [];

    }

    set fullName(namesAsArray) {
        if (namesAsArray.length !== 3) {
            throw Error('Name must include first name, middle name and last name');
        }

        for (const name of namesAsArray) {
            let regex = /^[A-Z][a-z]+$/g;
            if (!regex.test(name)) {
                throw Error('Invalid full name');
            }
        }

        this._fullName = {
            firstName: namesAsArray[0],
            middleName: namesAsArray[1],
            lastName: namesAsArray[2]
        }
    }

    get fullName() {
        return this._fullName;
    }

    addCreditCardInfo = function(creditCardArr) {
        if (creditCardArr === undefined) {
            this._creditCard = {
                cardNumber: 1111,
                expirationDate: '',
                securityNumber: 111
            };
        } else if (creditCardArr.length !== 3) {
            throw Error('Missing credit card information');
        } else if (isNaN(creditCardArr[0] || isNaN(creditCardArr[2]))) {
            throw Error('Invalid credit card details');
        } else {
            this._creditCard = {
                cardNumber: +creditCardArr[0],
                expirationDate: creditCardArr[1],
                securityNumber: +creditCardArr[2]
            }
        }
    }

    get creditCard() {
        return this._creditCard()
    }

    generateIdNumber = function(namesAsArray) {
        let vowelArray = ["a", "e", "o", "i", "u"];
        let result = 231 * (namesAsArray[0].charCodeAt(0))
            + 139 * namesAsArray[1].length;

        result += vowelArray
            .includes(namesAsArray[2].charAt(namesAsArray[2].length - 1))
            ? '8' : '7';

        return result;
    }

    addDestinationToWishList = function(destination) {
        if (this.wishList.length === 0
            || this.wishList[this.wishList.length - 1].length <
            destination.length) {
            this.wishList.push(destination);
        } else {
            for (let i = 0; i < this.wishList.length; i++) {
                if (destination.length < this.wishList[i].length) {
                    this.wishList.splice(i, 0, destination);
                    break;
                }
            }
        }
    }

    getVacationerInfo = function() {
        return `Name: ${this._fullName.firstName} ${this._fullName.middleName} ${this._fullName.lastName}
  ID Number: ${this.idNumber}
  Wishlist:
  ${this.wishList.length === 0 ? 'empty' : this.wishList.join(', ')}
  Credit Card:
  Card Number: ${this._creditCard.cardNumber}
  Expiration Date: ${this._creditCard.expirationDate}
  Security Number: ${this._creditCard.securityNumber}`;
    }
}

// Initialize vacationers with 2 and 3 parameters
let
    vacationer1 = new Vacationer(["Vania", "Ivanova", "Zhivkova"]);
let
    vacationer2 = new Vacationer(["Tania", "Ivanova", "Zhivkova"],
        [123456789, "10/01/2018", 777]);
try {
    let
        vacationer3 = new Vacationer(["Vania", "Ivanova", "ZhiVkova"]);
} catch
    (err) {
    console.log("Error: " + err.message);
}
// Should throw an error (Missing credit card information)
try {
    let vacationer3 = new Vacationer(["Zdravko", "Georgiev", "Petrov"]);
    vacationer3.addCreditCardInfo([123456789, "20/10/2018"]);
} catch (err) {
    console.log("Error: " + err.message);
}

vacationer1.addDestinationToWishList('Spain');
vacationer1.addDestinationToWishList('Germany');
vacationer1.addDestinationToWishList('Bali');

console.log(vacationer1.getVacationerInfo());
console.log(vacationer2.getVacationerInfo());
