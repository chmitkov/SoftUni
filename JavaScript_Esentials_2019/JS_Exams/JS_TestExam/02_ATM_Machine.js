function solve(arr) {

    let totalBanknotesArray = [];

    for (let row of arr) {
        if (row.length === 1) {
            report(row);
        } else if (row.length === 2) {
            withdraw(row);
        } else {
            insert(row);
        }
    }

    function insert(row) {
        for (let el of row) {
            totalBanknotesArray.push(el);
        }
        let sumOfRow = row.reduce((a, b) => a + b, 0);
        console.log(`Service Report: ${sumOfRow}$ inserted. Current balance: ${totalBanknotesArray.reduce((a, b) => a + b, 0)}$.`)

    }

    function withdraw(row) {
        let currentBalance = +row[0];
        let moneyToWithdraw = +row[1];

        if (currentBalance < moneyToWithdraw) {
            console.log(`Not enough money in your account. Account balance: ${currentBalance}$.`)
        } else {
            totalBanknotesArray.sort((a, b) => b - a);

            if (moneyToWithdraw > totalBanknotesArray.reduce((a, b) => a + b, 0)) {
                console.log('ATM machine is out of order!')
            } else {
                while (moneyToWithdraw > 0) {
                    for (let i = 0; i < totalBanknotesArray.length; i++) {
                        if (moneyToWithdraw === 0) {
                            break;
                        }
                        if (moneyToWithdraw - totalBanknotesArray[i] >= 0) {
                            moneyToWithdraw -= totalBanknotesArray[i];
                            totalBanknotesArray.splice(i,1);
                            i--;
                        }
                    }
                }
                console.log(`You get ${row[1]}$. Account balance: ${currentBalance-row[1]}$. Thank you!`)
            }

        }

    }

    function report(row) {
        let banknote = row[0];
        let banknoteQuantity = totalBanknotesArray
            .filter(x => x === Number(banknote))
            .length;
        console.log(`Service Report: Banknotes from ${banknote}$: ${banknoteQuantity}.`)
    }
}

solve([[20, 5, 100, 20, 1],
        [457, 25],
        [1],
        [10, 10, 5, 20, 50, 20, 10, 5, 2, 100, 20],
        [20, 85],
        [5000, 4500]]);