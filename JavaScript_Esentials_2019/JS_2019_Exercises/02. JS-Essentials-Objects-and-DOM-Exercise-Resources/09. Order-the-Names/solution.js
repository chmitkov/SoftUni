function solve() {

    let olElement = document.getElementsByTagName('ol')[0];
    let allUlElements = olElement.children;
    let btnAdd = document.getElementsByTagName('button')[0];
    btnAdd.addEventListener('click', addName);

    function addName() {
        let inputText = document.getElementsByTagName('input')[0]
            .value;

        let position = inputText.toUpperCase().charCodeAt(0) - 65;
        if (position >= 0 && position < 26) {
            let searchedRow = allUlElements[position];

            if (searchedRow.textContent === '') {
                searchedRow.textContent += inputText;
            } else {
                searchedRow.textContent += `, ${inputText}`;
            }
            document.getElementsByTagName('input')[0].value = '';
        }
    }
}