function solve(input) {
    let teamsMap = {};
    for (let row of input) {
        let commands = row.split(' -> ');
        let team = commands[0];
        let name = commands[1];
        let points = +commands[2];
        let pilot = {};
        pilot.name = name;
        if (!Object.keys(teamsMap).includes(team)) {
            teamsMap[team] = [];
        }
        if (!teamsMap[team].find(x => x.name === name)) {
            pilot.points = points;
            teamsMap[team].push(pilot);
        } else {
            teamsMap[team]
                .find(x => x.name === name)
                .points += points;
        }
    }
    let entries = Object.entries(teamsMap)
        .sort((a, b) => {
            return b[1].map(x => x.points)
                    .reduce((f, s) => f + s, 0) -
                a[1].map(x => x.points)
                    .reduce((f, s) => f + s, 0);
        });

    let counter = 0;
    for (const entry of entries) {
        counter++;
        if(counter > 3){
            break;
        }
        let teamName = entry[0];
        console.log(teamName + ': '
            + teamsMap[teamName]
                .map(x => x.points)
                .reduce((a, b) => a + b, 0));
        console.log(teamsMap[teamName]
            .map(x => `-- ${x.name} -> ${x.points}`)
            .join('\n'));
    }

}

solve(["Ferrari -> Kimi Raikonnen -> 25",
    "Ferrari -> Sebastian Vettel -> 18",
    "Mercedes -> Lewis Hamilton -> 10",
    "Mercedes -> Valteri Bottas -> 8",
    "Red Bull -> Max Verstapen -> 6",
    "Red Bull -> Daniel Ricciardo -> 4"]
);