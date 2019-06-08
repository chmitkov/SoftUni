function solve(arr) {
    let income = 0;
    for (let row of arr) {
        let total = 0;
        let commands = row.split(', ');
        let money = Number(commands[0]);
        let sugar = Number(commands[commands.length - 1]);
        total += commands.includes('decaf') ? 0.9 : 0.8;
        total += commands.includes('milk') ? 0.1 : 0;
        total += sugar > 0 ? 0.1 : 0;

        console.log(money >= total
            ? `You ordered ${commands[1]}. Price: ${total.toFixed(2)}$ Change: ${(money - total).toFixed(2)}$`
            : `Not enough money for ${commands[1]}. Need ${(total - money).toFixed(2)}$ more`)

        income += money >= total ? total : 0;
    }
    console.log(`Income report: ${income.toFixed(2)}$`);
}

solve(['1.00, coffee, caffeine, milk, 4', '0.40, tea, milk, 2',
    '1.00, coffee, decaf, 0']
);