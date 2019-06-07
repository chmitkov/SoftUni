function solve() {
    let btn = document.getElementById('searchBtn');
    btn.addEventListener('click', onClick);

    function onClick() {
        let searchedWordInputArea =
            document.getElementById('searchField');

        let searchedWord = searchedWordInputArea.value;
        console.log(searchedWord);

        let allTableRowsInArray = Array.from(document
            .getElementsByTagName('tr')
        );

        clearAllSelectedRows();

        for (let row of allTableRowsInArray) {
            for (let cell of row.cells) {
                if (cell.innerText.toLowerCase().includes(searchedWord.toLowerCase())) {
                    console.log('Yes');
                    row.className = 'select';
                }
            }
        }

        searchedWordInputArea.value = '';

        // setTimeout(function () {
        //     for (let row of allTableRowsInArray) {
        //         row.className = '';
        //     }
        // }, 2000)
        function clearAllSelectedRows() {
            for (let row of allTableRowsInArray) {
                for (let cell of row.cells) {
                    row.className = '';
                }
            }
        }
    }
}