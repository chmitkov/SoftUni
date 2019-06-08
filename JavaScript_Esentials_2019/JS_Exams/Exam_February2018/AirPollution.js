function solve(matrix, arr) {
    let numberMatrix = [];
    for (let row of matrix) {
        numberMatrix.push(row.split(' ')
            .map(x => Number(x)));
    }

    for (let row of arr) {
        let commands = row.split(' ');
        let index = commands[0]
        switch (commands[0]) {
            case 'breeze':
                for (let col = 0; col < numberMatrix.length; col++) {
                    numberMatrix[index][col] -= 15;
                }
                break;
            case 'gale':
                for (let row = 0; row < numberMatrix.length; row++) {
                    numberMatrix[row][index] -= 20;
                }
                break;
            case 'smog':
                for (let row = 0; row < numberMatrix.length; row++) {
                    for (let col = 0; col < numberMatrix[row].length; col++) {
                        numberMatrix[row][col] += index;
                    }
                }
                break;
        }
    }

    console.log(numberMatrix);
}

solve([
        "5 7 72 14 4",
        "41 35 37 27 33",
        "23 16 27 42 12",
        "2 20 28 39 14",
        "16 34 31 10 24",
    ],
    ["breeze 1", "gale 2", "smog 25"]
);