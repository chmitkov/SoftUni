function f(arr) {
    let numArr = arr.map(Number);
    let num1 = Number(arr[0]);
    let num2 = Number(arr[1]);
    let num3 = Number(arr[2]);
    let counter = 0;
    if (num1==0||num2==0||num3==0) {
        console.log("Positive");
        return;
    }
    if (num1 < 0) {
        counter++;
    }
    if (num2 < 0) {
        counter++;
    }
    if (num3 < 0) {
        counter++;
    }
    return console.log(counter%2==0?"Positive":"Negative");
}

f([3, -3, 6])