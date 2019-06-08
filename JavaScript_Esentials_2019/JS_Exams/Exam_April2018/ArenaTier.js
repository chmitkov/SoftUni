function solve(arr) {
    let pool = [];


    for (let row of arr) {
        let commands = row.includes('->')
            ? row.split(' -> ')
            : row.split(' vs ');

        if (commands.length === 3) {
            let name = commands[0];
            let technique = commands[1];
            let skill = Number(commands[2]);
            if (!pool.find(x => x.name === name)) {
                let obj = {};
                obj.name = name;
                obj.techniqueArr = [];
                pool.push(obj);
            }
            let searchedHero = pool.find(x => x.name === name);
            if (!searchedHero.techniqueArr.find(x => x.name === technique)) {
                let techniqueObj = {};
                techniqueObj.name = technique;
                techniqueObj.skill = skill;
                searchedHero.techniqueArr.push(techniqueObj);
            } else {
                let searchedTechnique = searchedHero.techniqueArr
                    .find(x => x.name === technique);
                if (searchedTechnique.skill < skill) {
                    searchedTechnique.skill = skill;
                }
            }
        } else if (commands.length === 2) {
            let heroOneName = commands[0];
            let heroTwoName = commands[1];

            if (pool.find(x => x.name === heroOneName) &&
                pool.find(x => x.name === heroTwoName)) {

                if (haveTheSameTechnique(heroOneName, heroTwoName) !== 'NotFound') {
                    let nameOfTech = haveTheSameTechnique(heroOneName, heroTwoName);
                    let heroOnePoints = pool
                        .find(x => x.name === heroOneName)
                        .techniqueArr
                        .find(x => x.name === nameOfTech)
                        .skill;
                    let heroTwoPoints = pool
                        .find(x => x.name === heroTwoName)
                        .techniqueArr
                        .find(x => x.name === nameOfTech)
                        .skill;

                    if (heroOnePoints !== heroTwoPoints) {
                        if (heroOnePoints > heroTwoPoints) {
                            pool = pool.filter(x => x.name !== heroTwoName);
                        } else {
                            pool = pool.filter(x => x.name !== heroOneName);
                        }
                    }
                }
            }
        }
    }

    pool.sort((a, b) => {
        let aPoints = a.techniqueArr
            .map(x => x.skill)
            .reduce((a, b) => a + b, 0);
        let bPoints = b.techniqueArr
            .map(x => x.skill)
            .reduce((a, b) => a + b, 0);

        return aPoints !== bPoints
            ? bPoints - aPoints
            : a.name.localeCompare(b.name);
    });

    for (let hero of pool) {
        let heroSkill = hero.techniqueArr
            .map(x => x.skill)
            .reduce((a, b) => a + b, 0);
        console.log(`${hero.name}: ${heroSkill} skill`);
        hero.techniqueArr
            .sort((a, b) => {
                return a.skill !== b.skill
                    ? b.skill - a.skill
                    : a.name.localeCompare(b.name);
            });
        console.log(hero.techniqueArr
            .map(x => `- ${x.name} <!> ${x.skill}`)
            .join('\n')
        );
    }


    function haveTheSameTechnique(heroOneName, heroTwoName) {
        let heroOne = pool.find(x => x.name === heroOneName);
        let heroTwo = pool.find(x => x.name === heroTwoName);

        for (let tech1 of heroOne.techniqueArr) {
            for (let tech2 of heroTwo.techniqueArr) {
                if (tech1.name === tech2.name) {
                    return tech1.name;
                }
            }
        }
        return 'NotFound';
    }
}

solve(["Pesho -> Duck -> 400",
    "Julius -> Shield -> 150",
    "Gladius -> Heal -> 200",
    "Gladius -> Support -> 250",
    "Gladius -> Shield -> 250",
    "Pesho vs Gladius",
    "Gladius vs Julius",
    "Ave Cesar"
]);