function solve() {
    let button = document.getElementsByTagName('button')[0];
    let resultParagraph = document.querySelector('#myCourses > div.courseFoot > p');

    function addCoursesInResultUl(courses) {
        let resultUlElement = document.querySelector('#myCourses > div.courseBody > ul');

        for (let course of courses) {
            let liElement = document.createElement('li');
            liElement.innerText = course;
            resultUlElement.appendChild(liElement);
        }
    }

    function calcSum() {
        let resultParagraph = document.querySelector('#myCourses > div.courseFoot > p');
        let courses = checkSelectedCourses();
        let priceMap = {
            'JS Fundamentals - January': 170,
            'JS Advanced - February': 180,
            'JS Applications - March': 190,
            'JS Web - April': 490,
        };
        let isOnSite = document
            .querySelector("input[type='radio']")
            .checked;
        let result = 0;

        if (courses.length === 4) {
            result = 170 + 180 + 190 + 490;
            courses.push('HTML and CSS');
        } else if (courses.includes('JS Fundamentals - January')
            && courses.includes('JS Advanced - February')
            && courses.includes('JS Applications - March')) {
            result = ((170 + 180 + 190) * 0.94).toFixed(2);
        } else if (courses.includes('JS Advanced - February')
            && courses.includes('JS Fundamentals - January')) {
            result = (170 + 180 * 0.9).toFixed(2);
        } else {
            result = courses
                .map(c => priceMap[c])
                .reduce((a, b) => a + b, 0);
        }

        //console.log(result);
        result = isOnSite
            ? result
            : (result * 0.94).toFixed(2);


        resultParagraph.innerText =
            `Cost: ${Math.round(result).toFixed(2)} BGN`;

        addCoursesInResultUl(courses);
    }

    resultParagraph.innerText = calcSum();
    button.addEventListener('click', calcSum);

    function checkSelectedCourses() {
        let allCheckboxes = document
            .querySelectorAll("input[type='checkbox']");
        let result = [];
        for (const checkbox of allCheckboxes) {
            if (checkbox.checked === true) {
                let parent = checkbox.parentElement;
                result.push(parent
                    .getElementsByTagName('label')[0]
                    .innerText)
            }
        }
        return result;
    }


}

solve();