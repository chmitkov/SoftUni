function solve() {
    let inputElement = document.getElementById('array');

    let [key, text] = JSON.parse(inputElement.value);

    console.log(key);
    console.log(text);

    let regexMessage = `(^| )${key}\\s+([a-zA-Z!%#$]{8,})(\\s|\\.|,)`;
    let regex = new RegExp(regexMessage, 'gi');

    let matcher = text.match(regex);
    // console.log(matcher)
    for (let m of matcher) {
        let current = m.replace(new RegExp(`${key}`, "gi"), "")
            .trim();
        let pass = convertPass(current);
        let regString = `${current}`;
        text = text.replace(new RegExp(regString,'gi'), pass);
    }

    console.log(text);
    function convertPass(pass) {
        pass = pass.toLowerCase();
        pass = pass.replace(new RegExp(/!/g), '1',)
            .replace(new RegExp(/%/g), '2')
            .replace(new RegExp(/#/g), '3')
            .replace(new RegExp(/\$/g), '4');

        return pass;
    }


    // Worked Regex
    //(^| )specialKey\s+([a-zA-Z!%#$]{8,})(\s|\.|,)
}

solve();
