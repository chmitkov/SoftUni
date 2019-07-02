function dart() {
    let scoreMap = {};
    let colorMap = {
        firstLayer: 'Green',
        secondLayer: 'Yellow',
        thirdLayer: 'Orange',
        fourthLayer: 'Red',
        fifthLayer: 'Purple',
        sixthLayer: 'Blue',
    };
    let firstOnTurn = true;
    let gameOver = false;
    (function addEventListenersOnAllRings() {
        let firstDiv = document.getElementById('firstLayer');
        firstDiv.addEventListener('click', hitTarget,);
        let secondDiv = document.getElementById('secondLayer');
        secondDiv.addEventListener('click', hitTarget,);
        let thirdDiv = document.getElementById('thirdLayer');
        thirdDiv.addEventListener('click', hitTarget);
        let fourthDiv = document.getElementById('fourthLayer');
        fourthDiv.addEventListener('click', hitTarget);
        let fifthDiv = document.getElementById('fifthLayer');
        fifthDiv.addEventListener('click', hitTarget);
        let sixthDiv = document.getElementById('sixthLayer');
        sixthDiv.addEventListener('click', hitTarget);

    })();
    (function () {
        let tableBodyElementChild = Array.from(document
            .querySelector('#scoreBoard > table > tbody').children);

        for (const row of tableBodyElementChild) {
            let currentRow = row.children;
            scoreMap[currentRow[0].textContent] =
                +currentRow[1].textContent.split(' ')[0];
        }
    })();

    function hitTarget(e) {
        e.stopPropagation();

        if (!gameOver) {
            addPlayerScore(scoreMap[colorMap[this.id]]);
            changePlayerTurn();
        }
    }

    let changePlayerTurn = (function () {
        let turnsDiv = document.getElementById('turns').children;
        let homeP = turnsDiv[0];
        let awayP = turnsDiv[1];


        return function () {
            homeP.style.textDecoration = firstOnTurn ? 'none' : 'underline';
            homeP.style.fontWeight = firstOnTurn ? 'normal' : 'bold';
            awayP.style.textDecoration = firstOnTurn ? 'underline' : 'none';
            awayP.style.fontWeight = firstOnTurn ? 'bold' : 'normal';
            firstOnTurn = !firstOnTurn;
        }
    })();

    let addPlayerScore = function (score) {
        let playerOneParElement = document.getElementById('Home')
            .children[0];
        let playerTwoParElement = document.getElementById('Away')
            .children[0];

        if (firstOnTurn) {
            if (+playerOneParElement.innerText + score >= 100) {
                winGame('home');
            } else {
                playerOneParElement.innerText =
                    +playerOneParElement.innerText + score;
            }
        } else {
            if (+playerTwoParElement.innerText + score >= 100) {
                winGame('away');
            } else {
                playerTwoParElement.innerText =
                    +playerTwoParElement.innerText + score;
            }
        }

    };

    let winGame = function (winner) {
        let playerOneSecondP = document.getElementById('Home')
            .children[1];
        let playerTwoSecondP = document.getElementById('Away')
            .children[1];
        playerOneSecondP.style.backgroundColor =
            winner === 'home' ? 'green' : 'red';
        playerTwoSecondP.style.backgroundColor =
            winner === 'home' ? 'red' : 'green';

        gameOver = true;
    }
}