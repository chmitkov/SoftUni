function solve(kingdomArray, inputArray) {
    let repo = [];

    for (let row of kingdomArray) {
        let obj = row;
        obj.wins = 0;
        obj.losses = 0;
        if (!repo.find(x => x.kingdom === obj.kingdom) ||
            !repo.find(x => x.kingdom === obj.kingdom &&
                x.general === obj.general)) {
            repo.push(obj);
        } else {
            repo.find(x => x.kingdom === obj.kingdom &&
                x.general === obj.general)
                .army += obj.army;
        }
    }


    for (let row of inputArray) {
        let attackKingdom = row[0];
        let attackGeneral = row[1];
        let defendKingdom = row[2];
        let defendGeneral = row[3];

        if (attackKingdom === defendKingdom) {
            continue;
        }

        let attackHero = repo
            .find(x => x.kingdom === attackKingdom &&
                x.general === attackGeneral);
        let defendHero = repo
            .find(x => x.kingdom === defendKingdom &&
                x.general === defendGeneral);

        if (attackHero.army > defendHero.army) {
            attackHero.army =
                Math.floor(attackHero.army * 1.1);
            defendHero.army =
                Math.floor(defendHero.army * 0.9);
            attackHero.wins += 1;
            defendHero.losses += 1;
        } else {
            defendHero.army =
                Math.floor(defendHero.army * 1.1);
            attackHero.army =
                Math.floor(attackHero.army * 0.9);
            defendHero.wins += 1;
            attackHero.losses += 1;
        }
    }

    let kingdomWithWinsAndLosses = [];

    for (let hero of repo) {
        if (!kingdomWithWinsAndLosses.find(x =>
            x.kingdom === hero.kingdom)) {
            let obj = {};
            obj.kingdom = hero.kingdom;
            obj.wins = hero.wins;
            obj.losses = hero.losses;
            kingdomWithWinsAndLosses.push(obj);
        } else {
            let searchedObj = kingdomWithWinsAndLosses
                .find(x => x.kingdom === hero.kingdom);
            searchedObj.wins += hero.wins;
            searchedObj.losses += hero.losses;
        }
    }
    //console.log(repo)
    //console.log(kingdomWithWinsAndLosses);
    kingdomWithWinsAndLosses.sort((a, b) => {
        let compareInt = b.wins - a.wins;
        if (compareInt === 0) {
            compareInt = a.losses = b.losses;
        }
        if (compareInt === 0) {
            compareInt = a.kingdom.localeCompare(b.kingdom);
        }
        return compareInt;
    });
    //console.log(kingdomWithWinsAndLosses);
    let winnerKingdom = kingdomWithWinsAndLosses[0].kingdom;
    console.log(`Winner: ${winnerKingdom}`);
    console.log(repo
        .filter(x => x.kingdom === winnerKingdom)
        .sort((a, b) => a.general.localeCompare(b.general))
        .map(x => `/\\general: ${x.general}\n---army: ${x.army}\n---wins: ${x.wins}\n---losses: ${x.losses}`)
        .join('\n'));


}

solve([{kingdom: "Maiden Way", general: "Merek", army: 5000},
        {kingdom: "Stonegate", general: "Ulric", army: 4900},
        {kingdom: "Stonegate", general: "Doran", army: 70000},
        {kingdom: "YorkenShire", general: "Quinn", army: 0},
        {kingdom: "YorkenShire", general: "Quinn", army: 2000},
        {kingdom: "Maiden Way", general: "Berinon", army: 100000}],
    [["YorkenShire", "Quinn", "Stonegate", "Ulric"],
        ["Stonegate", "Ulric", "Stonegate", "Doran"],
        ["Stonegate", "Doran", "Maiden Way", "Merek"],
        ["Stonegate", "Ulric", "Maiden Way", "Merek"],
        ["Maiden Way", "Berinon", "Stonegate", "Ulric"]]
);