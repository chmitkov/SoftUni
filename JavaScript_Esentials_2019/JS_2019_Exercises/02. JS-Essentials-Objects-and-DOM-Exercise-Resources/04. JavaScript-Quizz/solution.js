function solve() {

    let sections = document
        .getElementsByTagName('section');

    let rightAnswer = 0;
    let resultHeader = document.querySelector('#results > li > h1');

    function showNextSection(nextSection) {
        if (nextSection === 3) {
            sections[2].style.display = 'none';
            document.querySelector('#results')
                .style.display = 'block';
            resultHeader.innerHTML = rightAnswer === 3
                ? 'You are recognized as top JavaScript fan!'
                : `You have ${rightAnswer} right answers`;
        } else {
            sections[nextSection - 1].style.display = 'none';
            sections[nextSection].style.display = 'block';
        }
    }

    let firstQuestionButtonOne = document
        .querySelector('#quizzie > section:nth-child(2) > ul > li.quiz-answer.low-value > div > p');
    firstQuestionButtonOne
        .addEventListener('click', function () {
            rightAnswer++;
            showNextSection(1);
        });

    let firstQuestionButtonTwo = document
        .querySelector('#quizzie > section:nth-child(2) > ul > li.quiz-answer.high-value > div > p');
    firstQuestionButtonTwo
        .addEventListener('click', function () {
            showNextSection(1);
        });

    let secondQuestionButtonOne = document
        .querySelector('#quizzie > section:nth-child(3) > ul > li.quiz-answer.low-value > div > p');
    secondQuestionButtonOne
        .addEventListener('click', function () {
            showNextSection(2);
        });

    let secondQuestionButtonTwo = document
        .querySelector('#quizzie > section:nth-child(3) > ul > li.quiz-answer.high-value > div > p');
    secondQuestionButtonTwo
        .addEventListener('click', function () {
            rightAnswer++;
            showNextSection(2);
        });

    let thirdQuestionButtonOne = document
        .querySelector('#quizzie > section:nth-child(4) > ul > li.quiz-answer.low-value > div > p');
    thirdQuestionButtonOne
        .addEventListener('click', function () {
            rightAnswer++;
            showNextSection(3);
        });

    let thirdQuestionButtonTwo = document
        .querySelector('#quizzie > section:nth-child(4) > ul > li.quiz-answer.high-value > div > p');
    thirdQuestionButtonTwo
        .addEventListener('click', function () {
            showNextSection(3);
        });
}
