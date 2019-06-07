function solve() {
    let inputElement = document.getElementById('input');
    let resultElement = document.getElementById('resultOutput');

    let inputText = inputElement.value;
    let toCut = calcWeight(inputText);

    inputText = inputText.substring(toCut, inputText.length - toCut);

    let convertedText = convertBinaryToText(inputText);

    resultElement.innerHTML += convertedText;

    function convertBinaryToText(inputText) {
        let resultString = '';
        for (let i = 0; i < inputText.length; i += 8) {
            let part = inputText.slice(i, i + 8);

            resultString += String.fromCharCode(parseInt(part, 2));
        }
        return resultString;
    }

    function calcWeight(inputText) {
        let totalSumOfOnes = inputText
            .split('')
            .reduce((a, b) => +a + +b, 0);

        if (totalSumOfOnes < 10) {
            return totalSumOfOnes;
        } else {
            while (totalSumOfOnes.toString().length > 1) {
                let sum = 0;
                for (let char of totalSumOfOnes.toString().split('')) {
                    sum += Number(char);
                }
                totalSumOfOnes = sum;
            }
            return totalSumOfOnes;
        }
    }
}