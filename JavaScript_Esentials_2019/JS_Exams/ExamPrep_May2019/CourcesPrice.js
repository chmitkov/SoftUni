function solve(fundamentals, advanced, applications, onsite) {
    let total = 0;

    if (fundamentals) {
        total += 170;
    }
    if (advanced) {
        total += 180;
    }
    if (applications) {
        total += 190;
    }

    if (fundamentals && advanced) {
        total -= 180 * 0.1;
    }

    if (fundamentals && advanced && applications) {
        total -= total * 0.06;
    }

    if (onsite !== 'onsite') {
        total -= total * 0.06;
    }

    console.log(Math.round(total));
}

solve(true, false, false, "onsite");