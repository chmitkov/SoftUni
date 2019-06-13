function solve(capacity, arr) {
    let outOfTrain = 0;
    for (let i = 0; i < arr.length; i++) {
        arr[i] += outOfTrain;
        outOfTrain = 0;

        if (arr[i] > capacity) {
            outOfTrain += (arr[i] - capacity);
            arr[i] = capacity;
        }
    }

    console.log(arr);
    console.log(outOfTrain === 0 ? 'All passengers aboard' : `Could not fit ${outOfTrain} passengers`);
}

solve(10, [9, 39, 1, 0, 0]);