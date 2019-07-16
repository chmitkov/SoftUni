function solve() {
    const ELEMENTS = {
        jsFundamentals: document.querySelector('#availableCourses > div.courseBody > ul > li:nth-child(1) > input[type=checkbox]'),
        jsAdvanced: document.querySelector('#availableCourses > div.courseBody > ul > li:nth-child(2) > input[type=checkbox]'),
        jsApp: document.querySelector('#availableCourses > div.courseBody > ul > li:nth-child(3) > input[type=checkbox]'),
        jsWeb: document.querySelector('#availableCourses > div.courseBody > ul > li:nth-child(4) > input[type=checkbox]'),
        onSite: document.querySelector('#educationForm > input[type=radio]:nth-child(2)'),
        signMeUpButton: document.querySelector('#availableCourses > div.courseFoot > button'),
        myCoursesUL: document.querySelector('#myCourses > div.courseBody > ul'),
        costParagraph: document.querySelector('#myCourses > div.courseFoot > p'),
    }

    const priceMap = {
        jsFundamentals: 170,
        jsAdvanced: 180,
        jsApp: 190,
        jsWeb: 490,
    };
    ELEMENTS.signMeUpButton.addEventListener('click', addCourses);

    function addCourses() {
        let total = 0;

        if()
    }
}

solve();