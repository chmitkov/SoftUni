
handlers.getAdd = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    ctx.loadPartials({
        header: '../../views/common/header.hbs',
        footer: '../../views/common/footer.hbs'
    }).then(function () {
        this.partial('../views/flight/add.hbs');
    })
}

handlers.addFlight = function (ctx) {
    let flightObj = { ...ctx.params };

    flightService.createFlight(flightObj)
        .then((res) => console.log(res))
        .then(function () {
            notifications.showSuccess('Successfully create Event!');
            ctx.redirect('#/home');
        }).catch(function (err) {
            console.log(err);
        })
}

handlers.getDetails = async function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    ctx.flight = await flightService.getAFlight(ctx.params.id);

    ctx.loadPartials({
        header: '../../views/common/header.hbs',
        footer: '../../views/common/footer.hbs'
    }).then(function () {
        this.partial('../views/flight/details.hbs');
    })
}

handlers.getEdit = async function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    ctx.flight = await flightService.getAFlight(ctx.params.id);

    ctx.loadPartials({
        header: '../../views/common/header.hbs',
        footer: '../../views/common/footer.hbs'
    }).then(function () {
        this.partial('../views/flight/edit.hbs');
    })
}

handlers.editFlight = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    let flightObj = {};

    flightService.getAFlight(ctx.params.id)
        .then((res) => movieObj = res)
        .then(function () {
            flightObj.cost = ctx.params.cost;
            flightObj.departureDate = ctx.params.departureDate;
            flightObj.destination = ctx.params.destination;
            flightObj.img = ctx.params.img;
            flightObj.origin = ctx.params.origin;
            flightObj.public = ctx.params.public;
            flightObj.seats = ctx.params.seats;
        }).then(function () {
            flightService.updateFlight(ctx.params.id, flightObj)
                .then((res) => console.log(res))
                .then(function () {
                    notifications.showSuccess('Movie edited successfully');
                    ctx.redirect('#/home');
                })
        })
}

handlers.getMyFlights = async function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    flightService.getAllMyFlights()
        .then((res) => ctx.flights = Array.from(res))
        .then(function () {
            ctx.loadPartials({
                header: '../../views/common/header.hbs',
                footer: '../../views/common/footer.hbs',
                flight2: '../views/flight/flight2.hbs'
            }).then(function () {
                this.partial('../views/flight/myFlights.hbs');
            })
        })
}

handlers.removeFlight = function (ctx) {
    flightService.removeFlight(ctx.params.id)
        .then((res) => console.log(res))
        .then(function () {
            notifications.showSuccess('Successfylly remove flight');
            ctx.redirect('#/home');
        })
}
