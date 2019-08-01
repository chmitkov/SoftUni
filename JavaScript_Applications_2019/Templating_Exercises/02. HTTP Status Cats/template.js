(() => {
    renderCatTemplate();
    addEventListenersToButton();

    function renderCatTemplate() {
        const rootElement = document.getElementById('root');
        let template = document.getElementById('cat-template').innerHTML;
        let compiled = Handlebars.compile(template);

        let rendered = compiled({ cats: window.cats });

        document.getElementById('allCats').innerHTML = rendered;
    };

    function addEventListenersToButton() {
        const btns = document.getElementsByTagName('button')
        for (let b of btns) {
            b.addEventListener('click', showInfo);
        }
    };

    function showInfo() {
        let parent = this.parentNode.querySelector('div');
        parent.style.display === 'block'
            ? parent.style.display = 'none'
            : parent.style.display = 'block';
    }

})();
