function f(array) {
    let dict = {};
    for (let i = 0; i < array.length - 1; i++) {
        let current = array[i].split(" ");
        let key2 = current[0];
        let val = current[1];
        for(let key1 in dict)
        {
            if (key1 === key2)
            {
                dict[key1]=val;
            }else{
                dict.add(key2,val);
            }
        }
    }
    let serchedKey = array[array.length - 1];
    for (let key in dict) {
        if (key == serchedKey) {
            console.log(dict[key]);
            return;
        }
    }
    console.log("None");
}

f(["key value",
    "key eulav",
    "test tset",
    "key"]);