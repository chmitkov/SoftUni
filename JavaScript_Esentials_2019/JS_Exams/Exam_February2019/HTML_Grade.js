function solve(examPoints, completedHW, allHW) {
    let grade = 0;
    if (examPoints === 400) {
        grade = 6;
    } else {
        grade = 3 + 2 * ((examPoints + completedHW) - 400 / 5) / (400 / 2);
    }
    console.log(grade.toFixed(2));

}

solve(300, 10, 10);