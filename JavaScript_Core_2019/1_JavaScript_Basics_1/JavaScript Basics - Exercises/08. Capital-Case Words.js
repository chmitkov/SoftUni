function solve(arr) {
    let text = arr.join(",");
    let words = text.split(/\W+/);
    let nonEmpty = words.filter(x=>x.length>0);
    let upWords = nonEmpty.filter(isUpperCase);
    console.log(upWords.join(", "));
    
    function  isUpperCase(str) {
        return str===str.toUpperCase();
    }
}