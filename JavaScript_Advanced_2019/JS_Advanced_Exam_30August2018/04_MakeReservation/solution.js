function makeReservation() {
    const ELEMENTS = {
        fullName: document.getElementById('fullName'),
        email: document.getElementById('email'),
        phoneNumber: document.getElementById('phoneNumber'),
        address: document.getElementById('address'),
        postalCode: document.getElementById('postalCode'),
        submitButton: document.getElementById('submit'),
        editButton: document.getElementById('edit'),
        continueButton: document.getElementById('continue'),
        infoPreview: document.getElementById('infoPreview'),
    };
    const mapNameToElement = {
        'Name': 'fullName',
        'E-mail': 'email',
        'Phone': 'phoneNumber',
        'Address': 'address',
        'Postal Code': 'postalCode'
    };

    ELEMENTS.submitButton.addEventListener('click', submitFunc);
    ELEMENTS.editButton.addEventListener('click', editFunc);

    function submitFunc() {
        if (ELEMENTS.fullName.value === '' || ELEMENTS.email.value === '') {
            return;
        }

        changeButtons();
        cretePreview();
    }

    function cretePreview() {
        let nameLi = document.createElement('li');
        nameLi.textContent = 'Name: ' + ELEMENTS.fullName.value;
        let emailLi = document.createElement('li');
        emailLi.textContent = 'E-mail: ' + ELEMENTS.email.value;
        ELEMENTS.infoPreview.appendChild(nameLi);
        ELEMENTS.infoPreview.appendChild(emailLi);


        if (ELEMENTS.phoneNumber.value !== '') {
            let li = document.createElement('li');
            li.textContent = 'Phone: ' + ELEMENTS.phoneNumber.value;
            ELEMENTS.infoPreview.appendChild(li);
        }

        if (ELEMENTS.address.value !== '') {
            let li = document.createElement('li');
            li.textContent = 'Address: ' + ELEMENTS.address.value;
            ELEMENTS.infoPreview.appendChild(li);
        }

        if (ELEMENTS.postalCode.value !== '') {
            let li = document.createElement('li');
            li.textContent = 'Postal Code: ' + ELEMENTS.postalCode.value;
            ELEMENTS.infoPreview.appendChild(li);
        }

        clearInputs();
    }

    function editFunc() {
        for (const li of ELEMENTS.infoPreview.children) {
            let tokens = li.textContent.split(': ');
            ELEMENTS[mapNameToElement[tokens[0]]].value = tokens[1];
        }

        ELEMENTS.infoPreview.innerHTML = '';
        changeButtons();

    }

    function clearInputs() {
        ELEMENTS.fullName.value = '';
        ELEMENTS.email.value = '';
        ELEMENTS.phoneNumber.value = '';
        ELEMENTS.address.value = '';
        ELEMENTS.postalCode.value = '';
    }

    function changeButtons() {
        ELEMENTS.submitButton.disabled === true
            ? ELEMENTS.submitButton.disabled = false
            : ELEMENTS.submitButton.disabled = true;
        ELEMENTS.editButton.disabled === true
            ? ELEMENTS.editButton.disabled = false
            : ELEMENTS.editButton.disabled = true;
        ELEMENTS.continueButton.disabled === true
            ? ELEMENTS.continueButton.disabled = false
            : ELEMENTS.continueButton.disabled = true;

    }


}
