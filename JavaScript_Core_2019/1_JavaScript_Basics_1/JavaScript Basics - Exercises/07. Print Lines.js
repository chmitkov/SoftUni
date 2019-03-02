function f(args) {
    for (let i = 0; i < args.length; i++) {
        if (args[i] == "Stop") {
            break;
        }
        console.log(args[i]);

    }

}

f([1, 2, 4, 5, "stop"]);