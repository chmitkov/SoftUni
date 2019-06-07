function solve(matrix, inputToken) {
    let commands = inputToken.split(' ');
    let myObjArray = [];
    let result = '';

    for (let row = 1; row < matrix.length; row++) {
        let obj = {};
        for (let col = 0; col < matrix[row].length; col++) {
            obj[matrix[0][col]] = matrix[row][col];
        }
        myObjArray.push(obj);
    }

    if (commands[0] === 'hide') {
        for (let obj of myObjArray) {
            delete obj[commands[1]];
        }
    } else if (commands[0] === 'sort') {
        myObjArray.sort((a, b) => a[commands[1]].localeCompare(b[commands[1]]));
    } else if (commands[0] === 'filter') {
        myObjArray = myObjArray.filter(x => x[commands[1]] === commands[2]);
    }

    console.log(Object.keys(myObjArray[0]).join(' | '));
    myObjArray.forEach(x => {
        console.log(Object.values(x).join(' | '));
    })
}

solve([['firstName', 'age', 'grade', 'course'],
        ['Peter', '25', '5.00', 'JS-Core'],
        ['George', '34', '6.00', 'Tech'],
        ['Marry', '28', '5.49', 'Ruby']],
    'filter firstName Marry'
);