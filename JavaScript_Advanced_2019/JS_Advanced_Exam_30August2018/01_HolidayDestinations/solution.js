function addDestination() {
    const ELEMENTS = {
        cityInput: document.querySelector('#input > input:nth-child(2)'),
        countryInput: document.querySelector('#input > input:nth-child(4)'),
        destinationList: document.getElementById('destinationsList'),
    };

    if (isValidInput()) {
        addInStatistics(getSelectedSeason());
        addDestination();
        clearInput();
    }

    function addDestination() {
        let tr = document.createElement('tr');
        let firstTd = document.createElement('td');
        firstTd.textContent = `${ELEMENTS.cityInput.value}, ${ELEMENTS.countryInput.value}`;
        let secondTd = document.createElement('td');
        secondTd.textContent = getSelectedSeason();

        tr.appendChild(firstTd);
        tr.appendChild(secondTd);
        ELEMENTS.destinationList.appendChild(tr);
    }

    function addInStatistics(season) {
        let element = document.getElementById(season.toLowerCase());
        element.value = +element.value + 1;
    }

    function getSelectedSeason() {
        let selectElement = document.getElementById('seasons');
        let season = selectElement
            .children[selectElement.options.selectedIndex]
            .value;
        return season.charAt(0).toUpperCase() + season.substring(1);
    }

    function clearInput() {
        ELEMENTS.cityInput.value = '';
        ELEMENTS.countryInput.value = '';
    }

    function isValidInput() {
        return ELEMENTS.cityInput.value !== ''
            && ELEMENTS.countryInput.value !== '';
    }
}