function solve() {
    document
        .getElementsByTagName('button')[0]
        .addEventListener("click", generate);


    document
        .getElementsByTagName('button')[1]
        .addEventListener("click", buy);

    function generate(e) {

        let objects = JSON.parse(
            document
                .getElementsByTagName('textarea')[0]
                .value
        );

        objects.forEach(function (obj) { objectGenerator(obj) })

    }

    function objectGenerator(obj) {

        let trElement = document.createElement('tr');
        let imgElementTd = document.createElement('td');

        imgElementTd.innerHTML = '<img src="' + obj.img + '">';

        document
            .getElementsByTagName('tbody')[0]
            .appendChild(trElement);

        trElement.appendChild(imgElementTd);

        let nameElementTd = document.createElement('td');
        let nameElementP = document.createElement('p');


        nameElementP.textContent = obj.name;
        nameElementTd.appendChild(nameElementP);
        trElement.appendChild(nameElementTd);


        let priceElementP = document.createElement('p');
        priceElementP.textContent = obj.price;

        let priceElementTd = document.createElement('td');
        priceElementTd.appendChild(priceElementP);

        trElement.appendChild(priceElementTd);

        let decFactorElement = document.createElement('td');
        let decFactorElementP = document.createElement('p');

        decFactorElementP.textContent = obj.decFactor;

        decFactorElement.appendChild(decFactorElementP);
        trElement.appendChild(decFactorElement);


        let checkBoxTd = document.createElement('td');
        checkBoxTd.innerHTML = '<input type="checkbox">';

        trElement.appendChild(checkBoxTd);

    }

    function buy(e) {
        let boughtFurniture = [];
        let totalPrice = 0;
        let avgDecFactor = 0;
        let count = 0;

        let allTr = Array.from(document.getElementsByTagName('tr'));

        for (let i = 2; i < allTr.length; i++) {

            if (allTr[i].children[4].children[0].checked) {
                count += 1;
                boughtFurniture.push(allTr[i].children[1].textContent);
                totalPrice += +allTr[i].children[2].textContent;
                avgDecFactor += +allTr[i].children[3].textContent;

            }

        }

        avgDecFactor = avgDecFactor / (count);


        document
            .getElementsByTagName('textarea')[1]
            .value =
            "Bought furniture: " +
            boughtFurniture.join(', ') +
            "\nTotal price: " +
            totalPrice.toFixed(2) +
            "\nAverage decoration factor: " +
            avgDecFactor;
    }

}