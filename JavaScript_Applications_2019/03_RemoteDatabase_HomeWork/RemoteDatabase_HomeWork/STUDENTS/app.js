const ELEMENTS = {
    idInput: document.getElementById('id'),
    firstNameInput: document.getElementById('firstName'),
    lastNameInput: document.getElementById('lastName'),
    facNumberInput: document.getElementById('facNumber'),
    gradeInput: document.getElementById('grade'),
    btn: document.getElementById('submitBtn'),
    tableBody: document.querySelector("#results > tbody"),
};

const KINVEY = {
    urlForAuthorization: `https://baas.kinvey.com/user/kid_Bysur-XzH/login`,
    url: 'https://baas.kinvey.com/appdata/kid_Bysur-XzH/students',
    authToken: '51aa852c-f6ab-43a5-a744-e6ec74d3cfa0.tRSl+W+pk4oDF3MxsmR/mL8JSbCvuVPnzMYBuy51P54=',
};

ELEMENTS.btn.addEventListener('click', createStudent);

loadStudents();

function loadStudents() {

    const headers = {
        method: 'GET',
        credentials: 'include',
        headers: {
            Authorization: 'Kinvey ' + KINVEY.authToken,
            'Content-Type': 'application/json'
        }
    };

    fetch(KINVEY.url, headers)
        .then((response) => response.json())
        .then((data) => {
            ELEMENTS.tableBody.innerHTML = '';
            data
                .sort((a, b) => a.id - b.id)
                .forEach(student => {
                    createRowForStudent(student);
                });

        });

}

function createRowForStudent(student) {
    const tr = document.createElement('tr');
    const idTd = document.createElement('td');
    idTd.textContent = student.id;
    const firstNameTd = document.createElement('td');
    firstNameTd.textContent = student.firstName;
    const lastNameTd = document.createElement('td');
    lastNameTd.textContent = student.lastName;
    const facNumTd = document.createElement('td');
    facNumTd.textContent = student.facNumber;
    const gradeTd = document.createElement('td');
    gradeTd.textContent = (+student.grade).toFixed(2);

    tr.appendChild(idTd);
    tr.appendChild(firstNameTd);
    tr.appendChild(lastNameTd);
    tr.appendChild(facNumTd);
    tr.appendChild(gradeTd);

    ELEMENTS.tableBody.appendChild(tr);
}

function createStudent(ev) {
    ev.preventDefault();
    const id = ELEMENTS.idInput.value;
    const firstName = ELEMENTS.firstNameInput.value;
    const lastName = ELEMENTS.lastNameInput.value;
    const facNumber = ELEMENTS.facNumberInput.value;
    const grade = ELEMENTS.gradeInput.value;

    if (!(id && firstName && lastName && facNumber && grade)) {
        alert('Fill all input Fields!!!');
        return;
    }

    if(+grade > 6 || grade < 0){
        alert('Invalid Grade!!!');
        return;
    }

    const studentObj = {
        'id': id,
        'firstName': firstName,
        'lastName': lastName,
        'facNumber': facNumber,
        'grade': grade
    };

    const headers = {
        method: 'POST',
        body: JSON.stringify(studentObj),
        credentials: 'include',
        headers: {
            Authorization: "Kinvey " + KINVEY.authToken,
            'Content-Type': 'application/json'
        }
    };

    fetch(KINVEY.url, headers)
        .then((response) => {
            console.log(response);
            clearInputs();
            loadStudents();
        });
}

function clearInputs() {
    ELEMENTS.idInput.value = '';
    ELEMENTS.firstNameInput.value = '';
    ELEMENTS.lastNameInput.value = '';
    ELEMENTS.facNumberInput.value = '';
    ELEMENTS.gradeInput.value = '';
}

