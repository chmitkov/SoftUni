function solve(arr) {
    let racers = arr.shift().split(' ');
    let commands = arr;

    for (let command of commands) {
        command = command.split(' ');
        let racerName = command[1];
        if(!racers.includes(racerName)){
            continue;
        }
        let indexOfCurrentRacer = racers.indexOf(command[1]);

        switch (command[0]) {
            case 'Pit':
                racers.splice(indexOfCurrentRacer - 1, 0, racerName);
                racers.splice(indexOfCurrentRacer + 1, 1);
                break;
            case 'Overtake':
                racers.splice(indexOfCurrentRacer, 1);
                racers.splice(indexOfCurrentRacer + 1, 0, racerName);
                break;
            case 'Crash':
                racers.splice(indexOfCurrentRacer, 1);
                break;
            case 'Join':
                if (!racers.includes(racerName)) {
                    racers.splice(0, 0, racerName);
                }
                break;
        }
    }
    console.log(racers.reverse().join(' ~ '));
}

solve(["Vetel Hamilton Raikonnen Botas Slavi",
    "Pit Hamilton",
    "Overtake LeClerc",
    "Join Ricardo",
    "Crash Botas",
    "Overtake Ricardo",
    "Overtake Ricardo",
    "Overtake Ricardo",
    "Crash Slavi"]
);