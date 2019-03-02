function solve(arr){
    let nums = arr.map(Number);
    let sorted = nums.sort((a,b)=>b-a);
    let count = Math.min(3,sorted.length);
    let result = [];
    for (let i = 0; i < count; i++) {
        result.push(sorted[i]);
    }
    console.log(result.join("\n"));
}