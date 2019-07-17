function getInfo() {
    const ELEMENTS = {
        input: document.getElementById('stopId'),
        stopDiv: document.getElementById('stopName'),
        busesDiv: document.getElementById('buses'),
    };

    let input = ELEMENTS.input.value.trim();
    let url = `https://judgetests.firebaseio.com/businfo/${input}.json`;

    fetch(url)
        .then((response) => {
            clearInputAndDivs();
            return response.json();
        })
        .then((data) => {
            displayInfo(data);
        })
        .catch((err) => {
            displayError(err);
        });

    function displayInfo(data) {
        ELEMENTS.stopDiv.textContent = data.name;
        let allBuses = Object.entries(data.buses);

        for (let [bus, time] of allBuses) {
            let liElement = document.createElement('li');
            liElement.textContent = `Bus ${bus} arrives in ${time} minutes`;
            ELEMENTS.busesDiv.appendChild(liElement);
        }
    }

    function displayError(err) {
        ELEMENTS.stopDiv.textContent = 'Error!';
    }

    function clearInputAndDivs() {
        ELEMENTS.input.value = '';
        ELEMENTS.stopDiv.textContent = '';
        ELEMENTS.busesDiv.innerHTML = '';
    }
}