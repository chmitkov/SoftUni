function attachEvents() {
    const ELEMENTS = {
        inputLocation: document.getElementById('location'),
        btn: document.getElementById('submit'),
        forecast: document.getElementById('forecast'),
        current: document.getElementById('current'),
        upcoming: document.getElementById('upcoming'),
    };

    const SYMBOLS = {
        Sunny: '☀',
        Partly: '⛅',
        Overcast: '☁',
        Rain: '☂',
        Degrees: '°',
    };

    ELEMENTS.btn.addEventListener('click', getWeather);

    let allLocationsNameCodeMap = {};
    getAllLocationsNamesAndCodes();


    function getWeather() {
        showForecastDiv();
        const locationInput = ELEMENTS.inputLocation.value;
        let locationCode = allLocationsNameCodeMap[locationInput];

        if (locationCode === undefined) {

            createErrorDiv();

        } else {

            getTodayWeather(locationCode);
            getUpcomingWeather(locationCode);

        }

        clearInputs();

    }

    function getTodayWeather(locationCode) {
        let todayUrl = `https://judgetests.firebaseio.com/forecast/today/${locationCode}.json`;

        fetch(todayUrl)
            .then((response) => response.json())
            .then((data) => createTodayDiv(data))
            .catch((error) => console.log(error.message));
    }

    function createSingleDiv(day) {
        let symbol = day.condition === 'Partly sunny'
            ? SYMBOLS['Partly'] : SYMBOLS[day.condition];

        let mainSpan = document.createElement('span');
        mainSpan.classList.add('upcoming');

        let symbolSpan = document.createElement('span');
        symbolSpan.classList.add('symbol');
        symbolSpan.textContent = symbol;

        let degrSpan = document.createElement('span');
        degrSpan.classList.add('forecast-data');
        degrSpan.textContent =
            `${day.low}${SYMBOLS.Degrees}/${day.high}${SYMBOLS.Degrees}`;

        let conditionSpan = document.createElement('span');
        conditionSpan.classList.add('forecast-data');
        conditionSpan.textContent = day.condition;

        mainSpan.appendChild(symbolSpan);
        mainSpan.appendChild(degrSpan);
        mainSpan.appendChild(conditionSpan);

        ELEMENTS.upcoming.appendChild(mainSpan);
    }

    function createUpcomingDivs(data) {
        const threeDays = Object.values(data.forecast);

        for (const day of threeDays) {
            createSingleDiv(day);
        }
    }

    function getUpcomingWeather(locationCode) {
        let upcomingUrl = `https://judgetests.firebaseio.com/forecast/upcoming/${locationCode}.json`;

        fetch(upcomingUrl)
            .then((response) => response.json())
            .then((data) => createUpcomingDivs(data))
            .catch((error) => console.log(error));
    }

    function createTodayDiv(data) {
        let symbol = data.forecast.condition === 'Partly sunny'
            ? SYMBOLS['Partly'] : SYMBOLS[data.forecast.condition];

        let mainDivElement = document.createElement('div');
        mainDivElement.classList.add('forecasts');

        let symbolSpan = document.createElement('span');
        symbolSpan.classList.add('condition');
        symbolSpan.classList.add('symbol');
        symbolSpan.textContent = symbol;

        let locationSpan = document.createElement('span');
        locationSpan.classList.add('forecast-data');
        locationSpan.textContent = data.name;

        let degrSpan = document.createElement('span');
        degrSpan.classList.add('forecast-data');
        degrSpan.textContent =
            `${data.forecast.low}${SYMBOLS.Degrees}/${data.forecast.high}${SYMBOLS.Degrees}`;

        let conditionSpan = document.createElement('span');
        conditionSpan.classList.add('forecast-data');
        conditionSpan.textContent = data.forecast.condition;

        mainDivElement.appendChild(symbolSpan);
        mainDivElement.appendChild(locationSpan);
        mainDivElement.appendChild(degrSpan);
        mainDivElement.appendChild(conditionSpan);

        ELEMENTS.current.appendChild(mainDivElement);
    }

    function getAllLocationsNamesAndCodes() {
        let allLocationsUrl = 'https://judgetests.firebaseio.com/locations.json';
        fetch(allLocationsUrl)
            .then((response) => response.json())
            .then((data) => {
                for (const kvp of data) {
                    allLocationsNameCodeMap[kvp.name] = kvp.code;
                }
            });
    }

    function showForecastDiv() {
        ELEMENTS.forecast.style.display = 'block';
    }

    function clearInputs() {
        ELEMENTS.inputLocation.value = '';
    }

    function createErrorDiv() {
        let div = document.createElement('div');
        div.classList.add('forecasts');
        div.innerHTML = '<h1>Error</h1>';
        ELEMENTS.current.appendChild(div);
    }
}

attachEvents();