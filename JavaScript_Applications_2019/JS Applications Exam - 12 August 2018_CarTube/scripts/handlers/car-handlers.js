handlers.getDetails = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    carService.getACar(ctx.params.id)
        .then(res => ctx.car = { ...res })
        .then(function () {
            ctx.loadPartials({
                header: '../views/common/header.hbs',
                footer: '../views/common/footer.hbs',
            }).then(function () {
                this.partial('../views/car/details.hbs');
            })
        })
}

handlers.getEdit = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    carService.getACar(ctx.params.id)
        .then(res => ctx.car = { ...res })
        .then(function () {
            ctx.loadPartials({
                header: '../views/common/header.hbs',
                footer: '../views/common/footer.hbs',
            }).then(function () {
                this.partial('../views/car/edit.hbs');
            })
        })
}

handlers.editCar = function (ctx) {
    let carObj = {};
    carService.getACar(ctx.params.id)
        .then(res => carObj = res)
        .then(function () {
            carObj.title = ctx.params.title;
            carObj.description = ctx.params.description;
            carObj.brand = ctx.params.brand;
            carObj.model = ctx.params.model;
            carObj.year = ctx.params.year;
            carObj.imageUrl = ctx.params.imageUrl;
            carObj.fuel = ctx.params.fuel;
            carObj.price = ctx.params.price;
        }).then(function () {
            carService.updateCar(ctx.params.id, carObj)
                .then(res => console.log(res))
                .then(function () {
                    notifications.showSuccess('Successfully edit Car');
                    ctx.redirect('#/');
                })
        })
}

handlers.getCreate = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    ctx.loadPartials({
        header: '../views/common/header.hbs',
        footer: '../views/common/footer.hbs',
    }).then(function () {
        this.partial('../views/car/create.hbs');
    })
}

handlers.createCar = function (ctx) {
    let carObj = { ...ctx.params };

    if (carObj.title.length > 33 || carObj.description.length > 450
        || carObj.model.length < 4 || Number(carObj.price) > 100000) {
        notifications.showError('Invalid car parameters!!!');
    } else {
        carService.createCar(carObj)
            .then(res => {
                notifications.showSuccess('Successfully create car!');
                ctx.redirect('#/home');
            });
    }
}

handlers.deleteCar = function (ctx) {
    carService.removeCar(ctx.params.id)
        .then(res => {
            notifications.showSuccess('Successfully remove Car');
            ctx.redirect('#/home');
        })
}

handlers.getMyCars = function (ctx) {
ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');


    carService.getAllMyCars()
        .then(res => Array.from(res))
        .then((data) => {
            ctx.cars = data;
            ctx.isCarsEmpty = Array.from(data).length === 0;
        })
        .then(function () {
            ctx.loadPartials({
                header: '../views/common/header.hbs',
                footer: '../views/common/footer.hbs',
                carListings: '../views/car/carListings.hbs',
                car: '../views/car/car.hbs'
            }).then(function () {
                this.partial('../views/home/home.hbs');
            })
        })
}