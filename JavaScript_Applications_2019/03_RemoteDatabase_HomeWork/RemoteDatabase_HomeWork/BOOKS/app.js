(function () {

    const KINVEY = {
        urlForAuthorization: `https://baas.kinvey.com/user/kid_Bysur-XzH/login`,
        url: `https://baas.kinvey.com/appdata/kid_Bysur-XzH/books`,
        username: 'user',
        password: 'user',
        authToken: '',
        appKey: 'kid_Bysur-XzH',
        appSecret: '9a82ec6a083c4cb2b0be55a518b5ab93',
    };

    const ELEMENTS = {
        titleInput: document.getElementById('title'),
        authorInput: document.getElementById('author'),
        isbnInput: document.getElementById('isbn'),
        submitBtn: document.getElementById('submitBtn'),
        confirmEditBtn: document.getElementById('confirmBtn'),
        cancelBtn: document.getElementById('cancelBtn'),
        loadBtn: document.getElementById('loadBooks'),
        tableBody: document.querySelector("body > table > tbody"),

    };

    addEventListenersToButtons();
    firstAuthorization();

    function addEventListenersToButtons() {
        ELEMENTS.loadBtn.addEventListener('click', loadBooks);
        ELEMENTS.submitBtn.addEventListener('click', createBook);
        ELEMENTS.cancelBtn.addEventListener('click', cancelEdit);
    }

    function firstAuthorization() {

        const body = {'username': 'user13', 'password': 'user11'};
        const headers = {
            method: 'POST',
            body: JSON.stringify(body),
            credentials: 'include',
            headers: {
                Authorization: 'Basic ' + btoa(`${KINVEY.username}:${KINVEY.password}`),
                'Content-Type': 'application/json'
            }
        };

        fetch(KINVEY.urlForAuthorization, headers)
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                localStorage.setItem('authToken', data._kmd.authtoken);
            });
    }

    function loadBooks(ev) {
        ev.preventDefault();

        // if (!createBookFirst) {
        //     alert('Create a book first!!!');
        // }

        const headers = {
            method: 'GET',
            credentials: 'include',
            headers: {
                Authorization: 'Kinvey ' + localStorage.getItem('authToken'),
            }
        };

        fetch(KINVEY.url, headers)
            .then(handler)
            .then((data) => createTrElements(data));

    }

    function createTrElements(data) {
        ELEMENTS.tableBody.innerHTML = '';

        data.forEach(book => {
            let tr = document.createElement('tr');
            let titleTd = document.createElement('td');
            titleTd.textContent = book.title;
            let authorTd = document.createElement('td');
            authorTd.textContent = book.author;
            let isbnTd = document.createElement('td');
            isbnTd.textContent = book.isbn;
            let actionTd = document.createElement('td');
            let deleteBtn = document.createElement('button');
            deleteBtn.id = book._id;
            deleteBtn.addEventListener('click', deleteBook);
            deleteBtn.textContent = 'Delete';
            let updateBtn = document.createElement('button');
            updateBtn.addEventListener('click', editBook);
            updateBtn.id = book._id;
            updateBtn.textContent = 'Edit';
            actionTd.appendChild(updateBtn);
            actionTd.appendChild(deleteBtn);

            tr.appendChild(titleTd);
            tr.appendChild(authorTd);
            tr.appendChild(isbnTd);
            tr.appendChild(actionTd);

            ELEMENTS.tableBody.appendChild(tr);
        });
    }

    function editBook() {
        const currentBook = this.parentElement.parentElement.children;
        const bookId = this.id;
        ELEMENTS.titleInput.value = currentBook[0].textContent;
        ELEMENTS.authorInput.value = currentBook[1].textContent;
        ELEMENTS.isbnInput.value = currentBook[2].textContent;

        btnSwitch(1);

        ELEMENTS.confirmEditBtn.addEventListener('click', function (ev) {
            ev.preventDefault();

            let title = ELEMENTS.titleInput.value;
            let author = ELEMENTS.authorInput.value;
            let isbn = ELEMENTS.isbnInput.value;

            const editedBookObject = {title, author, isbn};

            console.log(editedBookObject);
            const headers = {
                method: 'PUT',
                body: JSON.stringify(editedBookObject),
                credentials: 'include',
                headers: {
                    Authorization: 'Kinvey ' + localStorage.getItem('authToken'),
                    "Content-type": "application/json",
                }
            };

            fetch(KINVEY.url + '/' + bookId, headers)
                .then(handler)
                .then((data) => {
                    console.log(data);
                    clearInputFields();
                    btnSwitch();
                    ELEMENTS.loadBtn.click();
                })
                .catch((err) => console.error(err.message));
        });


    }

    function cancelEdit(ev) {
        ev.preventDefault();
        clearInputFields();
        btnSwitch();
    }

    function deleteBook() {
        console.log(this.id);

        const headers = {
            method: 'DELETE',
            credentials: 'include',
            headers: {
                Authorization: 'Kinvey ' + localStorage.getItem('authToken'),
            }
        };

        fetch(KINVEY.url + '/' + this.id, headers)
            .then(handler)
            .then((data) => {
                console.log(data);
                ELEMENTS.loadBtn.click();
            })
            .catch((err) => console.error(err.message));

    }

    function createBook(ev) {
        ev.preventDefault();

        const title = ELEMENTS.titleInput.value;
        const author = ELEMENTS.authorInput.value;
        const isbn = ELEMENTS.isbnInput.value;

        if (!title || !author || !isbn) {
            alert('Please fill all fields');
        }

        //createBookFirst = true;

        const bookObject = {
            title, author, isbn
        };

        const headers = {
            method: "POST",
            body: JSON.stringify(bookObject),
            credentials: "include",
            headers: {
                Authorization: "Basic " + btoa(`${KINVEY.username}:${KINVEY.password}`),
                "Content-type": "application/json",
            }
        };

        fetch(KINVEY.url, headers)
            .then(handler)
            .then((data) => {
                console.log(data);
                clearInputFields();
                ELEMENTS.loadBtn.click();
            })
            .catch((err) => console.log(err.message));
    }

    function clearInputFields() {
        ELEMENTS.authorInput.value = '';
        ELEMENTS.titleInput.value = '';
        ELEMENTS.isbnInput.value = '';
    }

    function handler(response) {
        if (response.status >= 400) {
            throw new Error(response.status);
        }
        return response.json();
    }

    function btnSwitch(type) {
        if (type === 1) {
            ELEMENTS.submitBtn.style.display = 'none';
            ELEMENTS.cancelBtn.style.display = 'block';
            ELEMENTS.confirmEditBtn.style.display = 'block';
        } else {
            ELEMENTS.submitBtn.style.display = 'block';
            ELEMENTS.cancelBtn.style.display = 'none';
            ELEMENTS.confirmEditBtn.style.display = 'none';
        }
    }
})();