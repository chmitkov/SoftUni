function solve(arr) {
    let fruitsMap = {
        peach: 0,
        cherry: 0,
        plum: 0,
    };
    for (let row of arr) {
        let commands = row.split(' ');
        if (!Object.keys(fruitsMap).includes(commands[0])) {
            fruitsMap[commands[0]] = 0;
        }
        fruitsMap[commands[0]] += Number(commands[1]);
    }

    let cheryKomp = fruitsMap.cherry !== 0
        ? fruitsMap.cherry * 1000 / (9 * 25) : 0;
    fruitsMap.cherry = fruitsMap.cherry * 1000 - cheryKomp * (9 * 25);
    let peachKomp = fruitsMap.peach !== 0
        ? fruitsMap.peach * 1000 / (2.5 * 140) : 0;
    fruitsMap.peach = fruitsMap.peach * 1000 - peachKomp * (2.5 * 140);
    let plumKomp = fruitsMap.plum !== 0
        ? fruitsMap.plum * 1000 / (10 * 20) : 0;
    fruitsMap.plum = fruitsMap.plum * 1000 - plumKomp * 200;
    let rakiaLiters = Object.values(fruitsMap)
        .reduce((a, b) => a + b, 0) * 0.2;


    console.log(`Cherry kompots: ${Math.floor(cheryKomp)}\nPeach kompots: ${Math.floor(peachKomp)}\nPlum kompots: ${Math.floor(plumKomp)}\nRakiya liters: ${rakiaLiters.toFixed(2)}`);
}

solve(['cherry 1.2',
    'peach 2.2',
    'plum 5.2',
    'peach 0.1',
    'cherry 0.2',
    'cherry 5.0',
    'plum 10',
    'cherry 20.0',
    'papaya 20']
);