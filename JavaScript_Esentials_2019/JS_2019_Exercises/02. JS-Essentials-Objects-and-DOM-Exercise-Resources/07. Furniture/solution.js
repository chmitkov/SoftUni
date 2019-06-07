function solve() {

    let btnGenerate = document.getElementsByTagName('button')[0];
    btnGenerate.addEventListener('click', generateFunc);

    function generateFunc() {
        let textArea = document.getElementsByTagName('textarea')[0];
        let inputObjectsFromJSON = JSON.parse(textArea.value);
        let table = document.getElementsByTagName('table')[0];
        //console.log(table);

        for (let obj of inputObjectsFromJSON) {
            let row = table.insertRow();
            let cell = row.insertCell();
            let imgElement = document.createElement('img');
            imgElement.setAttribute('src', obj.img);
            cell.appendChild(imgElement);

            let nameCell = row.insertCell();
            let nameElement = document.createElement('p');
            nameElement.innerHTML = obj.name;
            nameCell.appendChild(nameElement);

            let priceCell = row.insertCell();
            let priceElement = document.createElement('p');
            priceElement.innerHTML = obj.price;
            priceCell.appendChild(priceElement);

            let decFactorCell = row.insertCell();
            let decFactorElement = document.createElement('p');
            decFactorElement.innerHTML = obj.decFactor;
            decFactorCell.appendChild(decFactorElement);

            let markCell = row.insertCell();
            let markElement = document.createElement('input');
            markElement.setAttribute('type', 'checkbox')
            markCell.appendChild(markElement);
        }

    }

    let buyBtnElement = document.getElementsByTagName('button')[1];
    buyBtnElement.addEventListener('click', buyFunction);

    function buyFunction() {
        let resultTextArea = document.getElementsByTagName('textarea')[1];

        let allRows = document.getElementsByTagName('tr');
        let totalPrice = 0;
        let totalDecFactory = 0;
        let allProducts = '';
        for (let i = 2; i < allRows.length; i++) {
            let currRow = allRows[i];
            if (currRow.children[4].children[0].checked) {
                allProducts += currRow.children[1].innerText;
                allProducts += ', ';
                totalPrice += Number(currRow.children[2].innerText);
                totalDecFactory += Number(currRow.children[3].innerText)
            }
        }
        allProducts = allProducts.substring(0, allProducts.length - 2);
        let averageDec = totalDecFactory / (allRows.length - 2);
        resultTextArea.value =
            `Bought furniture: ${allProducts}\nTotal price: ${totalPrice.toFixed(2)}\nAverage decoration factor: ${averageDec.toFixed(1)}`

    }


}