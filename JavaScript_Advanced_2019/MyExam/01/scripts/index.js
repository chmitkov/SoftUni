(() => {
    const ELEMENTS = {
        questionInput: document.querySelector('#inputSection > textarea'),
        nameInput: document.querySelector('#inputSection > div > input[type=username]'),
        sendButton: document.querySelector('#inputSection > div > button'),
        pendingQ: document.getElementById('pendingQuestions'),
        openQ: document.getElementById('openQuestions'),
    };

    ELEMENTS.sendButton.addEventListener('click', sendQuestion);

    function sendQuestion() {
        if (ELEMENTS.questionInput.value !== '') {
            let name = ELEMENTS.nameInput.value === ''
                ? 'Anonymous' : ELEMENTS.nameInput.value;
            let message = ELEMENTS.questionInput.value;

            let firstDiv = document.createElement('div');
            firstDiv.classList.add('pendingQuestion');
            let img = document.createElement('img');
            img.src = './images/user.png';
            img.width = 32;
            img.height = 32;
            let span = document.createElement('span');
            span.textContent = name;
            let p = document.createElement('p');
            p.textContent = message;
            let secondDiv = document.createElement('div');
            secondDiv.classList.add('actions');
            let firstButton = document.createElement('button');
            firstButton.classList.add('archive');
            firstButton.textContent = 'Archive';
            firstButton.addEventListener('click', function () {
                this.parentElement.parentElement.remove();
            });
            let secondButton = document.createElement('button');
            secondButton.classList.add('open');
            secondButton.textContent = 'Open';
            secondButton.addEventListener('click', function () {
                firstDiv.classList.remove('pendingQuestion');
                firstDiv.classList.add('openQuestion');
                ELEMENTS.openQ.appendChild(firstDiv);
                firstDiv.getElementsByTagName('div')[0].remove();
                let secondDiv = document.createElement('div');
                secondDiv.classList.add('actions');
                let buttonReply = document.createElement('button');
                buttonReply.classList.add('reply');
                buttonReply.textContent = 'Reply';

                buttonReply.addEventListener('click', function () {
                    buttonReply.textContent =
                        buttonReply.textContent === 'Back'
                            ? 'Reply' : 'Back';

                    thirdDiv.style.display =
                        thirdDiv.style.display === 'none'
                            ? 'block' : 'none';

                });
                secondDiv.appendChild(buttonReply);
                firstDiv.appendChild(secondDiv);

                let thirdDiv = document.createElement('div');
                thirdDiv.classList.add('replySection');
                thirdDiv.style.display = 'none';

                firstDiv.appendChild(thirdDiv);

                let input = document.createElement('input');
                input.classList.add('replyInput');
                input.type = 'text';
                input.placeholder = 'Reply to this question here...';
                let buttonSend = document.createElement('button');
                buttonSend.classList.add('replyButton');
                buttonSend.textContent = 'Send';
                buttonSend.addEventListener('click', function () {
                   let li = document.createElement('li');
                   if(input.value !== ''){
                       li.textContent = input.value;
                       input.value = '';
                   }
                   ol.appendChild(li);
                });
                let ol = document.createElement('ol');
                ol.classList.add('reply');
                ol.type = '1';

                thirdDiv.appendChild(input);
                thirdDiv.appendChild(buttonSend);
                thirdDiv.appendChild(ol);


            });

            secondDiv.appendChild(firstButton);
            secondDiv.appendChild(secondButton);

            firstDiv.appendChild(img);
            firstDiv.appendChild(span);
            firstDiv.appendChild(p);
            firstDiv.appendChild(secondDiv);

            ELEMENTS.pendingQ.appendChild(firstDiv);
        }
        ;
    }


})();