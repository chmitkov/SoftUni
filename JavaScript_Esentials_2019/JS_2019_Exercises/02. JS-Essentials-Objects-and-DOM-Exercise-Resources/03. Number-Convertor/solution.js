function solve() {
    document.getElementById('container')
        .children[7].addEventListener('click', onClick);

    function onClick(e) {
        let inputNumber = Number(document
            .getElementById('input').value);
        let resultDiv = document.getElementById('result');

        let typeToConvert = document
            .getElementById('selectMenuTo')
            .selectedOptions[0].value;
        console.log(typeToConvert.value);

        resultDiv.value = typeToConvert === 'hexadecimal'
            ? inputNumber.toString(16)
            : inputNumber.toString(2).toUpperCase();

    }
}