function ex1(array) {
    let delimiter = array.pop();
    console.log(array.join(delimiter));

}

// ex1(['One',
// //     'Two',
// //     'Three',
// //     'Four',
// //     'Five',
// //     '-']
// // );

function ex2(arr) {
    let step = +arr.pop();
    for (let i = 0; i < arr.length; i += step) {
        console.log(arr[i]);
    }
}

// ex2(['5',
//     '20',
//     '31',
//     '4',
//     '20',
//     '2']
// );

function ex3(array) {
    let counter = 0;
    let myArray = [];
    for (let command of array) {
        counter++;
        if (command.toLowerCase() === 'add') {
            myArray.push(counter);
        } else {
            if (myArray.length !== 0) {
                myArray.pop();
            }
        }
    }

    console.log(myArray.length === 0
        ? 'Empty' : myArray.join('\n'));
}

// ex3(['add',
//     'add',
//     'remove',
//     'add',
//     'add']
// );


function ex4(array) {

    let counter = array.pop();

    while (counter-- > 0) {
        array.unshift(array.pop());
    }
    console.log(array.join(' '));
}

// ex4(['1',
//     '2',
//     '3',
//     '4',
//     '2']
// );

function ex5(arr) {
    let resultArr = [];
    let maxValue = Number.MIN_VALUE;
    for (let i = 0; i < arr.length; i++) {
        if (i === 0) {
            resultArr.push(arr[i]);
            maxValue = arr[i];
        } else {
            if (maxValue < arr[i]) {
                resultArr.push(arr[i]);
                maxValue = arr[i];
            }
        }
    }
    resultArr.forEach(x => console.log(x));
}

// ex5([20,
//     3,
//     2,
//     15,
//     6,
//     1]
// );


function ex6(arr) {
    arr.sort((f, s) => {
        let result = f.length - s.length;
        return result === 0
            ? f.localeCompare(s)
            : result;
    })
        .forEach(x => console.log(x));
}

// ex6(['Isacc',
//     'Theodor',
//     'Jack',
//     'Harrison',
//     'George']
// );

function solve(arr, biggestNumber = -Infinity) {
    console.log(arr.filter(e => ([ret, biggestNumber] = [parseInt(e) >= biggestNumber, Math.max(biggestNumber, e)])[0]).join('\n'));
}

// solve([20,
//     3,
//     2,
//     15,
//     6,
//     1]);

function ex7(matrix) {
    let sum = matrix[0].reduce((a, b) => a + b);
    for (let row = 0; row < matrix.length; row++) {
        if (sum !== matrix[row].reduce((a, b) => a + b)) {
            console.log(false);
        }
    }
    for (let row = 0; row < 1; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            if (sum !== (matrix[row][col] + matrix[row + 1][col] + matrix[row + 2][col])) {
                console.log(false);
            }
        }
    }

    console.log(true);
}

// ex7([[4, 5, 6],
//     [6, 5, 4],
//     [5, 5, 5]]
// );


function ex8(num1, num2) {
    let matrix = [];
    for (let i = 0; i < num1; i++) {
        matrix.push([]);
    }
    //console.log(matrix);
    let counter = 0;
    for (let row = 0; row < num1; row++) {
        if (row % 2 === 0) {
            for (let col = 0; col < num2; col++) {
                matrix[row][col] = ++counter;
            }
        } else {
            for (let col = num2 - 1; col >= 0; col--) {
                matrix[row][col] = ++counter;
            }
        }
    }

    function printMatrix(matrix) {
        for (let row = 0; row < matrix.length; row++) {
            console.log(matrix[row].join(' '));
        }
    }

    printMatrix(matrix);
}

// ex8(5, 5);


function spiralMatrix([input]) {

    let [maxRows, maxCols] = input.split(' ').map(Number);
    let matrix = [];
    for (let i = 0; i < maxRows; i++) {
        matrix.push([]);
        for (let j = 0; j < maxCols; j++) {
            matrix[i].push(0);
        }
    }
    let element = 0;
    let col = -1;
    let row = 1;

    while (element < maxRows * maxCols) {
        row--;
        col++;
        while (col < maxCols && matrix[row][col] == 0) { // хоризонтално напред
            element++;
            matrix[row][col] = element;
            col++;
        }
        col--;
        row--;
        while (row >= 0 && matrix[row][col] == 0) {
            element++;
            matrix[row][col] = element;
            row--;
        }
        row++;
        col--;
        while (col >= 0 && matrix[row][col] == 0) {
            element++;
            matrix[row][col] = element;
            col--;
        }
        row++;
        col++;
        while (row < maxRows && matrix[row][col] === 0) {//
            element++;
            matrix[row][col] = element;
            row++;
        }
    }
    console.log(matrix.map(row => row.join(' ')).join('\n'));
}

function magic_Matrix(input) {

    let matrix = input;

    let sum = matrix[0].reduce((a, b) => (a + b));


    if (input.length === 2) {
        for (let row = 1; row < matrix.length; row++) {
            let sumRow = matrix[row].reduce((a, b) => (a + b));
            if (sum !== sumRow) {
                return false;
            }
        }

        for (let col = 0; col < matrix[0].length; col++) {
            let sumCol = 0;
            for (let row = 0; row < matrix.length; row++) {
                sumCol += matrix[row][col];
            }

            if (sumCol !== sum) {
                return false;
            }
        }

        return true;
    } else {
        for (let row = 1; row <= input.length; row++) {
            let sumRow = matrix[row].reduce((a, b) => (a + b));
            return sum === sumRow;
        }
    }
}

//console.log(magic_Matrix(['4 5 6', '6 5 4', '5 5 5']));
//console.log(magic_Matrix(['11 32 45', '21 0 1', '21 1 1']));
//console.log(magic_Matrix(['1 0 0', '0 0 1', '0 1 0']));


function ex9(matrix) {

    let sumFirstDiag = 0;
    let sumSecondDiag = 0;
    for (let row = 0; row < matrix.length; row++) {
        sumFirstDiag += +matrix[row][row];
    }
    console.log(sumFirstDiag);
    console.log(matrix)
}

ex9(['5 3 12 3 1',
    '11 4 23 2 5',
    '101 12 3 21 10',
    '1 4 5 2 2',
    '5 22 33 11 1']
);

function orbitOfMatrix(arr) {

    let size = [arr[0], arr[1]];
    let coordinates = [arr[2], arr[3]];
    let matrix = [];

    for (let i = 0; i < size[0]; i++) {
        let rs = [];
        for (let j = 0; j < size[1]; j++) {
            rs.push(0);
        }
        matrix.push(rs);
    }
    let number = 2;
    let colEnd = coordinates[1];
    let rowEnd = coordinates[0];
    let colStart = coordinates[1];
    let rowStart = coordinates[0];
    matrix[coordinates[0]][coordinates[1]] = 1;
    let counterRowEnd = rowEnd;
    let counterColEnd = colEnd;
    let counterRowStart = rowEnd;
    let counterColStart = colEnd;
    while (true) {
        counterRowEnd++;
        counterColEnd++;
        counterRowStart--;
        counterColStart--;
        //check if out of matrix size
        if (counterRowEnd > size[0] - 1 && counterColEnd > size[1] - 1 && counterRowStart < 0 && counterColStart < 0) break;
        if (rowEnd >= size[0] - 1) rowEnd = size[0] - 1;
        else rowEnd++;
        if (colEnd >= size[1] - 1) colEnd = size[1] - 1;
        else colEnd++;
        if (rowStart === 0) rowStart = 0;
        else rowStart--;
        if (colStart === 0) colStart = 0;
        else colStart--;
        for (let i = rowStart; i <= rowEnd; i++) {
            for (let j = colStart; j <= colEnd; j++) {
                if (matrix[i][j] === 0) {
                    matrix[i][j] = number;
                }
            }
        }
        number++;
    }
    for (let row of matrix) {
        console.log(row.join(' '));
    }
}