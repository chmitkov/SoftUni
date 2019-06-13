function solve(days) {
    let totalCaffeine = 0;
    let morning = (3 * 150) / 100 * 40;
    let lunch = (2 * 250) / 100 * 8;
    let brunch = (3 * 350) / 100 * 20;
    for (let i = 1; i < days + 1; i++) {
        totalCaffeine += morning + lunch + brunch;
        if (i % 5 === 0) {
            totalCaffeine += ((3 * 500) / 100) * 30;
        }
        if (i % 9 === 0) {
            let colas = ((4 * 250) / 100) * 8;
            let energy = ((2 * 500) / 100) * 30;
            totalCaffeine += colas + energy;
        }
    }

    console.log(`${totalCaffeine} milligrams of caffeine were consumed`)
}

solve(5);