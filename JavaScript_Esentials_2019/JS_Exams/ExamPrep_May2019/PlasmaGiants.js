function solve(arr, length) {
    let firstPart = arr.slice(0, arr.length / 2);
    let secondPart = arr.slice(arr.length / 2);

    function getGiantsPoint(array, length) {
        let total = 0;
        while (array.length > 0) {
            let currentArr = array.splice(0, length);
            total += currentArr.reduce((a, b) => a * b);
        }
        return total;
    }

    let min = Math.min(...arr);
    let max = Math.max(...arr);
    let firstGiant = getGiantsPoint(firstPart, length);
    let secondGiant = getGiantsPoint(secondPart, length);
    let rounds = 1;

    firstGiant -= max;
    secondGiant -= max;


    while (firstGiant > 0 && secondGiant > 0) {
        firstGiant -= min;
        secondGiant -= min;
        rounds++;
    }

    if (firstGiant === secondGiant) {
        console.log(`Its a draw ${firstGiant} - ${secondGiant}`)
    } else {
        console.log(`${firstGiant > secondGiant ? 'First' : 'Second'} Giant defeated ${firstGiant < secondGiant ? 'First' : 'Second'} Giant with result ${Math.max(firstGiant, secondGiant)} - ${Math.min(firstGiant, secondGiant)} in ${rounds} rounds`)
    }
}

solve([3, 3, 3, 4, 5, 6, 7, 8, 9, 10, 5, 4], 2);