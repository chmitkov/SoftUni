function solve(arr) {
    let map = {};
    for (let row of arr) {
        let commands = row.split(' > ');
        let country = commands[0];
        let town = commands[1];
        town = town.charAt(0).toUpperCase()+town.slice(1);
        let cost = Number(commands[2]);

        if (!map.hasOwnProperty(country)) {
            map[country] = [];
        }
        if (!map[country].find(x => x.town === town)) {
            let obj = {};
            obj.town = town;
            obj.cost = cost;
            map[country].push(obj);
        } else {
            let findObj = map[country].find(x => x.town === town);
            if (findObj.cost > cost) {
                findObj.cost = cost;
            }
        }
    }

    for (let country in map) {
        map[country].sort((a, b) => a.cost - b.cost);
    }

    let sorted = Object.keys(map)
        .sort((a, b) => {
            return a.localeCompare(b)
        });

    for (let country of sorted) {
        let allTowns = map[country]
            .map(x => `${x.town} -> ${x.cost}`)
            .join(' ');
        console.log(`${country} -> ${allTowns}`);
    }
}

solve(["Bulgaria > Sofia > 500",
    "Bulgaria > Sopot > 800",
    "France > Paris > 2000",
    "Albania > Tirana > 1000",
    "Bulgaria > Sofia > 200"]
);