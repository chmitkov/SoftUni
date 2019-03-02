function f(array) {
    let result = [];
    for (let i = 0; i < array.length; i++) {
        let currWord = array[i].split(" ");
        let commands = currWord[0];
        let number = Number(currWord[1]);

        switch (commands) {

            case "add":
                result.push(number);
                break;
            case "remove":
                if (number >= 0 && number < result.length) {
                    result.splice(number,1);
                }
                break;

        }
    }
    console.log(result.join("\n"));

}
f(["add 3",
    "add 5",
    "remove 2",
    "remove 0",
    "add 7"]);