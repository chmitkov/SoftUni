function solve() {
    let targetDiv = document
        .getElementsByClassName('my-message')[0];

    let button = document.getElementById('send');
    button.addEventListener('click', onClick);
    let mainMessageDiv = document.getElementById('chat_messages');

    function onClick(e) {
        let cloneDiv = targetDiv.cloneNode();
        let inputTextArea = document.getElementById('chat_input');
        cloneDiv.innerHTML = inputTextArea.value;
        mainMessageDiv.appendChild(cloneDiv);
        inputTextArea.value = '';
    }
}



