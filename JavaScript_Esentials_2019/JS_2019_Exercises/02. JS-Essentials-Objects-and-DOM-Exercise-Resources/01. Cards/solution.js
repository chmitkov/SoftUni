function solve() {
    Array.from(document.getElementsByTagName('img'))
        .forEach((img) =>
            img.addEventListener('click', onClickFunc));

    function onClickFunc(e) {
        let clickedCard = e.target;
        clickedCard.src = 'images\\whiteCard.jpg';
        clickedCard.removeEventListener('click', onClickFunc);

        let cardDeck = clickedCard.parentNode;
        let resultSpans = document.getElementById('result')
            .children;

        if (cardDeck.id === 'player1Div') {
            resultSpans[0].innerHTML = clickedCard.name;
        } else {
            resultSpans[2].innerHTML = clickedCard.name;
        }

        let winner;
        let looser;
        if (+resultSpans[0] > +resultSpans[2]) {
            winner = document.querySelector(
                `#player1Div img[name='${resultSpans[0].textContent}']`);
            looser = document.querySelector(
                `#player2Div img[name='${resultSpans[2].textContent}']`);
        } else {
            winner = document.querySelector(
                `#player2Div img[name='${resultSpans[2].textContent}']`);
            looser = document.querySelector(
                `#player1Div img[name='${resultSpans[0].textContent}']`);
        }

        winner.style.border = '2px solid green';
        looser.style.border = '2px solid darkred';

        let resultHistory = document.getElementById('history');

        resultHistory.innerHTML += `[${resultSpans[0].innerHTML} vs ${resultSpans[2].innerHTML}] `;

        setTimeout(function () {
            resultSpans[0].textContent = '';
            resultSpans[2].textContent = '';
        }, 2000);
    }
}