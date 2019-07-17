function attachEvents() {
    const ELEMENTS = {
        textarea: document.getElementById('messages'),
        nameInput: document.getElementById('author'),
        messageInput: document.getElementById('content'),
        sendBtn: document.getElementById('submit'),
        refreshBtn: document.getElementById('refresh'),
    };

    ELEMENTS.sendBtn.addEventListener('click', sendFunc);
    ELEMENTS.refreshBtn.addEventListener('click', refreshFunc);

    const url = 'https://rest-messanger.firebaseio.com/messanger.json';

    function refreshFunc() {
        ELEMENTS.textarea.textContent = '';
        fetch(url)
            .then((response) => response.json())
            .then((data) => {
                createChatElements(data);
            })
            .catch(err => console.log(err));
    }

    function sendFunc() {
        const author = ELEMENTS.nameInput.value === ''
            ? 'Anonymous'
            : ELEMENTS.nameInput.value;
        const content = ELEMENTS.messageInput.value;

        if (content === '') {
            return;
        }

        let obj = {author, content};

        fetch(url, {
            method: 'POST',
            body: JSON.stringify(obj),
        })
            .then((response) => console.log(response))
            .catch((err) => console.log(err));

        clearInputElements();
    }

    function createChatElements(data) {
        let allMsg = Object.values(data);
        for (const msg of allMsg) {

            ELEMENTS.textarea.textContent +=
                `${msg.author}: ${msg.content}\n`;
        }
    }

    function clearInputElements() {
        ELEMENTS.nameInput.value = '';
        ELEMENTS.messageInput.value = '';
    }

}

attachEvents();