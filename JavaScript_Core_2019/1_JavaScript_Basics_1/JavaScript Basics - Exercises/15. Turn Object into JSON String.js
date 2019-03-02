function f(array) {
    let obj = {};
    for (let i = 0; i <array.length; i++) {
        let current = array[i].split(" -> ");
        if (current[0]=="grade"||current[0]=="age"){
            obj[current[0]] = Number(current[1]);
        }else {
            obj[current[0]] = current[1];
        }

    }
    let str = JSON.stringify(obj);
    console.log(str);
}
f([
    "name -> Angel",
    "surname -> Georgiev",
    "age -> 20",
    "grade -> 6.00",
    "date -> 23/05/1995",
    "town -> Sofia"
])