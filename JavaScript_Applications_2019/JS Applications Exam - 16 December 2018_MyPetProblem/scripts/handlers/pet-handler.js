handlers.getDashboard = function (ctx) {

    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');
    ctx.userId = sessionStorage.getItem('id');

    let categoryParam = ctx.params.category.charAt(0).toUpperCase()
        + ctx.params.category.substr(1);
    console.log(categoryParam);

    petService.getAllPets()
        .then((response) => {
            let collection = categoryParam != null && categoryParam != 'All'
                ? Array.from(response).filter(p => p.category === categoryParam)
                : Array.from(response);
            ctx.pets = collection;
            return ctx.loadPartials({
                header: '../../views/common/header.hbs',
                footer: '../../views/common/footer.hbs',
                pet: '../../views/pet/otherPet.hbs',
            })
        }).then(function () {
            this.partial('../../views/pet/dashboard.hbs');
        });
}

handlers.getCreatePet = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    ctx.loadPartials({
        header: '../../views/common/header.hbs',
        footer: '../../views/common/footer.hbs',
    }).then(function () {
        this.partial('../../views/pet/createPet.hbs');
    });
}

handlers.createPet = function (ctx) {

    let petObj = { ...ctx.params, likes: 0 };

    petService.createPet(petObj).then(function (res) {
        notifications.showSuccess('Pet created successfully!');
        ctx.redirect('#/dashboard/all');
    }).catch(function (err) {
        console.log(err);
    })
}

handlers.getMyPets = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');
    ctx.userId = sessionStorage.getItem('id');

    petService.getMyPets(ctx.userId)
        .then((response) => {

            ctx.pets = Array.from(response);

            return ctx.loadPartials({
                header: '../../views/common/header.hbs',
                footer: '../../views/common/footer.hbs',
                pet: '../../views/pet/myPet.hbs',
            })
        }).then(function () {
            this.partial('../../views/pet/dashboard.hbs');
        })
}

handlers.getDetails = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');
    let id = ctx.params.id;

    petService.getAPet(id)
        .then((response) => {
            ctx.pet = response;
            console.log(response);
            return ctx.loadPartials({
                header: '../../views/common/header.hbs',
                footer: '../../views/common/footer.hbs',

            })
        }).then(function () {
            this.partial('../../views/pet/detailMyPet.hbs');
        })
}

handlers.savePet = function (ctx) {
    let descriptionNew = ctx.params.description;
    let id = ctx.params.id;
    let petObj = {};
    petService.getAPet(id)
        .then((res) => petObj = { ...res })
        .then(function () {
            petObj.description = descriptionNew;

            petService.updatePet(id, petObj)
                .then(function () {
                    notifications.showSuccess('Successfull update pet');
                    ctx.redirect('/#/myPets');
                })
        })
}

handlers.getDeletePet = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');
    let id = ctx.params.id;

    petService.getAPet(id)
        .then((response) => {
            ctx.pet = response;

            return ctx.loadPartials({
                header: '../../views/common/header.hbs',
                footer: '../../views/common/footer.hbs',
            })
        }).then(function () {
            this.partial('../../views/pet/deletePet.hbs');
        })
}

handlers.deletePet = function (ctx) {

    petService.removePet(ctx.params.id)
    .then((response)=> {
        notifications.showSuccess('Successfully remove Pet');
        ctx.redirect('#/myPets');
    })
}

handlers.likePet = function (ctx, ev) {
    console.log('ok');
}