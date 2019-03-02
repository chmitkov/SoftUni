function solve(array) {
    let objects = array.map(JSON.parse);
    let sum = {};
    for (let object of objects) {
        if (object.town in sum) {
            sum[object.town] += object.income;
        } else {
            sum[object.town] = object.income;
        }
    }
    let towns = Object.keys(sum).sort();
    for (let town of towns) {
        console.log(`${town} -> ${sum[town]}`);
    }
}