function solve(matrix1, matrix2) {
    console.log(matrix1);
    console.log(matrix2);

    let result = [];
    let remainder = 0;
    for (let row = 0; row < matrix1.length; row++) {
        result.push([]);
        for (let col = 0; col < matrix1[row].length; col++) {
            let sum = matrix1[row][col] + matrix2[row][col] + remainder;
            remainder = 0;
            if (sum > 9) {
                remainder++;
                sum -= 10;
            }
            result[row][col] = sum;

            if (col === matrix1[row].length - 1 && remainder > 0) {
                result[row][col + 1] = [remainder];
            }

        }
    }

    console.log(result);
}

solve([[1, 2, 3], [3, 4, 5], [5, 6, 7]],
    [[1, 1, 1], [1, 1, 1], [1, 1, 1]]
);