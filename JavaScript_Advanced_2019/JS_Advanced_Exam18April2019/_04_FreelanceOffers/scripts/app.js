let ELEMENTS = {
    loginElement: document.getElementById('username'),
    loginButton: document.getElementById('loginBtn'),
    loginNotification: document.getElementById('notification'),
    createOfferDivContainer: document.getElementById('create-offers'),
    activeOffersDivContainer: document.getElementById('offers'),
};

(function start() {
    ELEMENTS.createOfferDivContainer.style.display = 'none';
    ELEMENTS.activeOffersDivContainer.style.display = 'none';
})();

ELEMENTS.loginButton.addEventListener('click', login);

function login() {
    let loginInput = ELEMENTS.loginElement.value;

    if (loginInput.length > 4 || loginInput.length < 10) {
        ELEMENTS.loginNotification.textContent =
            'The username length should be between 4 and 10 characters.';
    } else {
        ELEMENTS.loginElement.textContent = `Hello, ${loginInput}!`;
        ELEMENTS.loginElement.disable = true;
    }
}





