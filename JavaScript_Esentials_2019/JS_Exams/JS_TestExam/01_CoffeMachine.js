function solve(arr) {
    let machineMoney = 0;
    for (let row of arr) {
        let rowArr = row.split(', ');
        let money = rowArr[0];
        let type = rowArr[1];
        let sugar = Number(rowArr[rowArr.length - 1]);
        let total = 0.8;

        if (type === 'coffee' && rowArr.includes('decaf')) {
            total += 0.1;
        }

        if (rowArr.includes('milk')) {
            total += 0.1;
        }

        if (sugar > 0) {
            total += 0.1;
        }

        machineMoney += money >= total ? total : 0;

        console.log(money >= total
            ? `You ordered ${type}. Price: ${total.toFixed(2)}$ Change: ${(money - total).toFixed(2)}$`
            : `Not enough money for ${type}. Need ${(total - money).toFixed(2)}$ more.`)
    }
    console.log(`Income Report: ${machineMoney.toFixed(2)}$`);
}

solve(['1.00, coffee, caffeine, milk, 4',
    '0.40, tea, milk, 2',
    '1.00, coffee, decaf, 0']
);