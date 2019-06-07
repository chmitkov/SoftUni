function solve() {

    let expressionOutput = document.getElementById('expressionOutput');
    let resultOutput = document.getElementById('resultOutput');
    // console.log(expressionOutput);
    // console.log(resultOutput);

    let allButtons = document.getElementsByTagName('button');
       console.log(allButtons);

    // let btnEquals = document.querySelector('#calculator > div.keys > button:nth-child(15)')
    //     .addEventListener('click', equalsFunc);

    for (let i = 0; i < allButtons.length; i++) {
        if (i === 0) {
            allButtons[i].addEventListener('click', clearFunc);
        } else if (i === allButtons.length - 2) {
            allButtons[i].addEventListener('click', equalsFunc);
        } else if (i === 4 || i === 8 || i === 12 || i === allButtons.length - 1) {
            allButtons[i].addEventListener('click', function () {
                expressionOutput.innerHTML += ' ' + allButtons[i].value + ' ';
            })
        } else {
            allButtons[i].addEventListener('click', function () {
                    expressionOutput.innerHTML += allButtons[i].value;
                }
            )
        }
    }



    function equalsFunc() {
        let expression = expressionOutput.innerHTML;
        //console.log("test");
        //expressionOutput.innerHTML = '';
        let result = '';
        if (expression.includes('+')) {
            if (expression.split('+').length === 2) {
                result = Number(expression.split('+')[0]) +
                    Number(expression.split('+')[1]);
            }
        } else if (expression.includes('-')) {
            if (expression.split('-').length === 2) {
                result = Number(expression.split('-')[0]) -
                    Number(expression.split('-')[1]);
            }
        } else if (expression.includes('*')) {
            if (expression.split('*').length === 2) {
                result = Number(expression.split('*')[0]) *
                    Number(expression.split('*')[1]);
            }
        } else if (expression.includes('/')) {
            if (expression.split('/').length === 2) {
                result = Number(expression.split('/')[0]) /
                    Number(expression.split('/')[1]);
            }
        }

        if (result === '') {
            resultOutput.innerHTML = 'NaN';
        } else {
            resultOutput.innerHTML = result;
        }
    }
    function clearFunc() {
        expressionOutput.innerHTML = '';
        resultOutput.innerHTML = '';
    }
}