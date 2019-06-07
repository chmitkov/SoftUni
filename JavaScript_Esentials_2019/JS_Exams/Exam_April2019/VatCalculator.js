function solve(sum, vatpercent) {
    let onePercent = sum / (100 + vatpercent);

    console.log(sum - vatpercent * onePercent);

}

solve(120.00,
    20.00);