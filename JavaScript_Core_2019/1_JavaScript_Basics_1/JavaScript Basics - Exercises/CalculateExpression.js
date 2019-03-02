function solve(str) {
    let array = str[0].split(' ').map(Number);
    let num1 = Number(array[0]);
    let num2 = Number(array[1]);
    let num3 = Number(array[2]);

    console.log((check(num1, num2, num3) ||
        check(num1, num3, num2) ||
        check(num3, num2, num1) ||
        "No"));

    function check(num1, num2, sum) {
        if (num1 + num2 != sum) {
            return false;
        }
        if (num1 >= num2) {
            [num1, num2] = [num2,num1];
        }
        return `${num1} + ${num2} = ${sum}`;
    }
}

solve([8, 15, 7]);