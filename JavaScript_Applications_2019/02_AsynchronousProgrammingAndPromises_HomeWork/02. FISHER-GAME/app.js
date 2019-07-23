function attachEvents() {
    const ELEMENTS = {
        loadBtn: document.querySelector('button.load'),
        updateBtn: document.querySelector('button.update'),
        deleteBtn: document.querySelector('button.delete'),
        addBtn: document.querySelector('button.add'),
        catches: document.getElementById('catches'),
        addForm: document.getElementById('addForm'),
    };

    ELEMENTS.loadBtn.addEventListener('click', loadFunc);
    ELEMENTS.addBtn.addEventListener('click', createFunc);
    ELEMENTS.updateBtn.addEventListener('click', updateFunc);

    let template = document
        .getElementById('catches')
        .children[0];

    function createFunc() {
        let createUrl = 'https://fisher-game.firebaseio.com/catches.json';
        let obj = {};

        Array.from(ELEMENTS.addForm.querySelectorAll('input'))
            .forEach(x => obj[x.className] = x.value);

        fetch(createUrl, {
            method: 'POST',
            body: JSON.stringify(obj),
        }).then((response) => console.log(response))
            .then(() => setTimeout(ELEMENTS.loadBtn.click(), 2000))
            .catch(error => console.log(error));


        ELEMENTS.addForm.querySelectorAll('input')
            .forEach(x => x.value = '');

    }

    function updateFunc() {
        let updateUrl = `https://fisher-game.firebaseio.com/catches/${this.parentNode.getAttribute('data-id')}.json`;
        let divElement = this.parentNode;
        let obj = {};

        Array.from(divElement.querySelectorAll('input'))
            .forEach(x => obj[x.className] = x.value);

        fetch(updateUrl, {
            method: 'PUT',
            body: JSON.stringify(obj)
        }).then((response) => console.log(response))
            .then(() => setTimeout(ELEMENTS.loadBtn.click(), 2000));


    }

    function deleteFunc() {
        let deleteUrl = `https://fisher-game.firebaseio.com/catches/${this.parentNode.getAttribute('data-id')}.json`;
        let obj = {};

        fetch(deleteUrl, {
            method: 'DELETE'
        }).then((response) => console.log(response))
            .then(() => setTimeout(ELEMENTS.loadBtn.click(), 2000));
    }

    function loadFunc() {
        ELEMENTS.catches.innerHTML = '';
        let loadUrl = 'https://fisher-game.firebaseio.com/catches.json';
        fetch(loadUrl)
            .then((response) => response.json())
            .then((data) => createCatchElements(data))
            .catch(error => console.log(error));

    }

    function createCatchElements(data) {
        Object.entries(data)
            .forEach(entry => createCatch(entry[0], entry[1], template));
    }

    function createCatch(key, value, template) {

        let div = template.cloneNode(true);
        div.setAttribute('data-id', key);
        div.querySelector('.angler').value = value.angler;
        div.querySelector('.weight').value = value.weight;
        div.querySelector('.species').value = value.species;
        div.querySelector('.location').value = value.location;
        div.querySelector('.bait').value = value.bait;
        div.querySelector('.captureTime').value = value.captureTime;
        div.querySelector('button.update').addEventListener('click', updateFunc);
        div.querySelector('button.delete').addEventListener('click', deleteFunc);

        ELEMENTS.catches.appendChild(div);

    }
}

attachEvents();

