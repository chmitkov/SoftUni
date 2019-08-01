(function () {
    const btnElement = document.getElementById('btnLoadTowns');
    const rootElement = document.getElementById('root');
    btnElement.addEventListener('click', loadTowns);

    function loadTowns() {
        let towns = document.getElementById('towns')
            .value
            .split(',')
            .map(t => ({ name: t.trim() }));

        renderTowns(towns);
    };

    function renderTowns(towns) {

        let template = document.getElementById('towns-template').innerText;
        let compiled = Handlebars.compile(template);
        let rendered = compiled({ towns });

        rootElement.innerHTML = rendered;
    }

})();