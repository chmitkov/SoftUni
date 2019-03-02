function solve(numAsString) {
    let num = Number(numAsString);
    let result = [];
    for (let i = 1; i <= num; i++) {
        if (checkIsSimetric(i))
        {
            result.push(i);
        }
    }
    console.log(result.join(" "));

    function checkIsSimetric(number) {
        let str = number.toString();
        if (str.length==1){
            return true;
        }else  {
            for (let i = 0; i < str.length/2; i++) {
                if (str[i]!=str[str.length-1-i])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
