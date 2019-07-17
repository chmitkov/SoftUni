function solve() {

    const ELEMENTS = {
        info: document.querySelector("#info > span"),
        departBtn: document.getElementById('depart'),
        arriveBtn: document.getElementById('arrive'),
    };

    let nextStopId = 'depot';
    let nextStopName;

    function depart() {
        let url = `https://judgetests.firebaseio.com/schedule/${nextStopId}.json`;

        fetch(url)
            .then((response) => response.json())
            .then((data) => {
                ELEMENTS.info.textContent = `Next stop ${data.name}`;
                buttonsSwitch();
                nextStopId = data.next;
                nextStopName = data.name;
            })
            .catch(error => errorFunc(error));
    }

    function arrive() {
        buttonsSwitch();
        ELEMENTS.info.textContent = `Arriving at ${nextStopName}`;
    }


    function errorFunc(error) {
        ELEMENTS.arriveBtn.disabled = true;
        ELEMENTS.departBtn.disabled = true;
        ELEMENTS.info.textContent = 'Error';
    }

    function buttonsSwitch() {
        ELEMENTS.departBtn.disabled === true
            ? ELEMENTS.departBtn.disabled = false
            : ELEMENTS.departBtn.disabled = true;
        ELEMENTS.arriveBtn.disabled === true
            ? ELEMENTS.arriveBtn.disabled = false
            : ELEMENTS.arriveBtn.disabled = true;
    }


    return {
        depart,
        arrive
    };
}

let result = solve();