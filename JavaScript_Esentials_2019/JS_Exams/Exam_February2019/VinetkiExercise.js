function solve(arrayFromObj) {
    let mapMostProfitableCity = {};
    let mapMostDrivenModel = {};
    arrayFromObj.forEach(x => {
        if (!mapMostProfitableCity.hasOwnProperty(x.town)) {
            mapMostProfitableCity[x.town] = x.price;
        } else {
            mapMostProfitableCity[x.town] = mapMostProfitableCity[x.town] + x.price;
        }
    });

    let townWithMaxProfit = '';
    let maxProfit = Number.MIN_VALUE;
    for (let c in mapMostProfitableCity) {
        if (mapMostProfitableCity[c] > maxProfit) {
            maxProfit = mapMostProfitableCity[c];
            townWithMaxProfit = c;
        } else if (mapMostProfitableCity[c] === maxProfit) {
            if (c.localeCompare(townWithMaxProfit) > 0) {
                townWithMaxProfit = c;
            }
        }
    }
    console.log(`${townWithMaxProfit} is most profitable - ${maxProfit} BGN`);

    mapMostDrivenModel = {};

    arrayFromObj.forEach(x => {
        if (x.town === townWithMaxProfit) {
            if (!mapMostDrivenModel.hasOwnProperty(x.model)) {
                mapMostDrivenModel[x.model] = 1;
            } else {
                mapMostDrivenModel[x.model] = mapMostDrivenModel[x.mode] + 1;
            }
        }
    });

    let bestCar = '';
    let carCount = 0;

    for (let car in mapMostDrivenModel) {
        if (mapMostDrivenModel[car] > carCount) {
            carCount = mapMostDrivenModel[car];
            bestCar = car;
        } else if (carCount === mapMostDrivenModel[car]) {
            let bestCarObj = findCarInTown(townWithMaxProfit, bestCar);
            let currentCarObj = findCarInTown(townWithMaxProfit, car);
            if (bestCarObj.price < currentCarObj.price) {
                bestCar = car;
            }
        }
    }

    console.log('Most driven model: ' + bestCar);

    function findCarInTown(town, carMake) {
        return arrayFromObj.filter(x => x.model === carMake && x.town === town);
    }

    let mapTownWithCarPlates = {};
    for (let obj of arrayFromObj) {
        if (obj.model === bestCar) {
            if (!mapTownWithCarPlates.hasOwnProperty(obj.town)) {
                mapTownWithCarPlates[obj.town] = [];
            }
            mapTownWithCarPlates[obj.town].push(obj.regNumber);
        }
    }

    let sortedKeys = Object.keys(mapTownWithCarPlates).sort();

    for (let key of sortedKeys) {
        console.log(`${key}: ${mapTownWithCarPlates[key].sort((a,b)=> a.localeCompare(b)).join(', ')}`)
    }
}

solve([{model: 'BMW', regNumber: 'B1234SM', town: 'Varna', price: 2},
    {model: 'BMW', regNumber: 'C5959CZ', town: 'Sofia', price: 8},
    {model: 'Tesla', regNumber: 'NIKOLA', town: 'Burgas', price: 9},
    {model: 'BMW', regNumber: 'A3423SM', town: 'Varna', price: 3},
    {model: 'Lada', regNumber: 'SJSCA', town: 'Sofia', price: 3}]
);