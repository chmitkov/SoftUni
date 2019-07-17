function attachEvents() {
    const ELEMENTS = {
        phoneBook: document.getElementById('phonebook'),
        personInput: document.getElementById('person'),
        phoneInput: document.getElementById('phone'),
        btnLoad: document.getElementById('btnLoad'),
        btnCreate: document.getElementById('btnCreate')
    };
    const baseUrl = 'https://phonebook-nakov.firebaseio.com/phonebook.json';

    ELEMENTS.btnLoad.addEventListener('click', load);
    ELEMENTS.btnCreate.addEventListener('click', create);

    function load() {
        ELEMENTS.phoneBook.innerHTML = '';
        fetch(baseUrl)
            .then((response) => response.json())
            .then((data) => {
                let phones = Object.entries(data);
                console.log(data);
                for (const [key, value] of phones) {
                    //console.log(key);
                    let liElement = document.createElement('li');
                    liElement.textContent = `${value.person}: ${value.phone}`;
                    let btn = document.createElement('button');
                    btn.textContent = 'Delete';
                    btn.addEventListener('click', function () {
                        let deleteUrl = `https://phonebook-nakov.firebaseio.com/phonebook/${key}.json`;
                        fetch(deleteUrl, {
                            method: 'DELETE'
                        }).then((response) => console.log(response));
                            // .then((data)=> console.log(data))
                            // .catch((error) => console.log(error));
                        liElement.remove();
                    });
                    liElement.appendChild(btn);

                    ELEMENTS.phoneBook.appendChild(liElement);
                }
            })
            .catch(error => console.log(error.message));
    }


    function create() {
        const person = ELEMENTS.personInput.value;
        const phone = ELEMENTS.phoneInput.value;

        clearInputFields();

        let contact = {person, phone};

        fetch(baseUrl, {
            method: 'POST',
            body: JSON.stringify(contact)
        })
            .then((response) => console.log(response))
            .catch((error) => console.log(error));

    }

    function clearInputFields() {
        ELEMENTS.personInput.value = '';
        ELEMENTS.phoneInput.value = '';
    }
}

attachEvents();