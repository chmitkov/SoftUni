class Hotel {
    constructor(name, capacity) {
        this.name = name;
        this.capacity = capacity;
        this.bookings = [];
        this.currentBookingNumber = 0;
        this.allRoomsMap = {
            'single': parseInt((+capacity * 0.5).toFixed(0)),
            'double': parseInt((+capacity * 0.3).toFixed(0)),
            'maisonette': parseInt((+capacity * 0.2).toFixed(0))
        };
        this._roomPriceMap = {
            'single': 50,
            'double': 90,
            'maisonette': 135
        };
        this._servicesPriceMap = {
            'food': 10,
            'drink': 1,
            'housekeeping': 25
        };
    }

    rentARoom(name, roomType, nights) {

        if (this.allRoomsMap[roomType] === 0) {
            let resultString = `No ${roomType} rooms available!`;

            Object.keys(this.allRoomsMap)
                .filter(x => x != roomType
                    && this.allRoomsMap[x] > 0)
                .forEach(x => resultString
                    += ` Available ${x} rooms: ${this.allRoomsMap[x]}.`);

            return resultString;
        }

        this.allRoomsMap[roomType]--;

        let currentBooking = {
            clientName: name,
            roomType: roomType,
            nights: nights,
            roomNumber: ++this.currentBookingNumber
        };

        this.bookings.push(currentBooking);

        return `Enjoy your time here Mr./Mrs. ${name}. Your booking is ${currentBooking.roomNumber}.`
    }

    roomService(bookingNumber, serviceType) {
        if (bookingNumber <= 0 || bookingNumber > this.bookings.length) {
            return `The booking ${bookingNumber} is invalid.`;
        }

        if (!this.servicesPriceMap.hasOwnProperty(serviceType)) {
            return `We do not offer ${serviceType} service.`;
        }

        let room = this.bookings
            .find(x => x.roomNumber === bookingNumber);

        if (!room.hasOwnProperty('services')) {
            room['services'] = [];
        }

        room.services.push(serviceType);

        return `Mr./Mrs. ${room.clientName}, Your order for ${serviceType} service has been successful.`
    }

    checkOut(bookingNumber) {
        if (bookingNumber <= 0 || bookingNumber > this.bookings.length) {
            return `The booking ${bookingNumber} is invalid.`;
        }

        let room = this.bookings
            .find(x => x.roomNumber === bookingNumber);

        this.allRoomsMap[room.roomType]++;

        let priceForNights =
            this.allRoomsMap[room.roomType] * room.nights;

        if (room.hasOwnProperty('services')) {
            let servicesPrice = room.services
                .map(x => this.servicesPriceMap[x])
                .reduce((a, b) => a + b, 0);
            return `We hope you enjoyed your time here, Mr./Mrs. ${room.clientName}. The total amount of money you have to pay is ${priceForNights + servicesPrice} BGN. You have used additional room services, costing ${servicesPrice} BGN.`
        } else {
            return `We hope you enjoyed your time here, Mr./Mrs. ${room.clientName}. The total amount of money you have to pay is ${priceForNights} BGN.`
        }
    }

    report() {
        if (this.bookings.length === 0) {
            return `${this.name.toUpperCase()} DATABASE:\n--------------------\nThere are currently no bookings.`;
        }

        let resultString = `"${this.name.toUpperCase()} DATABASE:\n--------------------`;

        this.bookings.forEach(b => {
            resultString += `\nbookingNumber – ${b.roomNumber}\nclientName – ${b.clientName}\nroomType – ${b.roomType}\nnights – ${b.nights}`;
            resultString += b.hasOwnProperty('services')
                ? `\nservices: ${b.services.join(', ')}\n----------`
                : '\n----------';
        });

        return resultString;
    }


    get roomPriceMap() {
        return this._roomPriceMap;
    }

    get servicesPriceMap() {
        return this._servicesPriceMap;
    }
}


let hotel = new Hotel('HotUni', 10);

// act
hotel.rentARoom('Peter', 'single', 4);
hotel.rentARoom('Robert', 'double', 4);
hotel.rentARoom('Geroge', 'maisonette', 6);

hotel.roomService(3, 'housekeeping');
hotel.roomService(3, 'drink');
hotel.roomService(2, 'room');

console.log(hotel.report());

