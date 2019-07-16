const ELEMENTS = {
    createOfferDiv: document.getElementById('create-offers'),
    userNameInput: document.getElementById('username'),
    loginButton: document.getElementById('loginBtn'),
    notification: document.getElementById('notification'),
};

ELEMENTS.createOfferDiv.style.display = 'none';
ELEMENTS.loginButton.addEventListener('click', loginFunc);

function loginFunc() {
    if (ELEMENTS.userNameInput.value.length < 4
        || ELEMENTS.userNameInput.value.length > 10) {
        ELEMENTS.notification.textContent =
            `The username length should be between 4 and 10 characters.`
    }
}