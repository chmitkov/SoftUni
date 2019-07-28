handlers.getCreate = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    // eventService.getAllSongs()
    //   .then((response) => )

    console.log('ok');
    ctx.loadPartials({
        header: '../views/common/header.hbs',
        footer: '../views/common/footer.hbs'
    }).then(function () {
        this.partial('../views/events/create.hbs');
    }).catch(function (err) {
        console.log(err);
    });
}

handlers.create = function (ctx) {
    let eventObj = {
        ...ctx.params,
        creator: sessionStorage.id,
        interested: 0,
        creatorName: sessionStorage.getItem('username'),
    };

    if (eventObj.name.length < 6 || eventObj.description.length < 10 ||
        !eventObj.imageURL.startsWith('http') ||
        !eventObj.imageURL.startsWith('https')) {

        notifications.showError('Event info is not correct!');
    } else {
        eventService.createEvent(eventObj)
            .then((res) => console.log(res))
            .then(function () {
                notifications.showSuccess('Successfully create Event!');
                ctx.redirect('#/home');
            }).catch(function (err) {
                console.log(err);
            })
    }
}

handlers.getDetails = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    eventService.getAnEvent(ctx.params.id)
        .then((res) => {
            ctx.isCreator = res.creator === sessionStorage.getItem('id');
            ctx.event = res;
        }).then(function () {
            ctx.loadPartials({
                header: '../views/common/header.hbs',
                footer: '../views/common/footer.hbs'
            }).then(function () {
                this.partial('../views/events/details.hbs');
            })
        })
}

handlers.getEdit = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    eventService.getAnEvent(ctx.params.id)
        .then((res) => ctx.event = res)
        .then(function () {
            console.log(ctx.event.description);
            ctx.loadPartials({
                header: '../views/common/header.hbs',
                footer: '../views/common/footer.hbs'
            }).then(function () {
                this.partial('../views/events/edit.hbs');
            })
        })
}

handlers.edit = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    let eventObj = {};
    eventService.getAnEvent(ctx.params.id)
        .then((res) => eventObj = res)
        .then(function () {
            eventObj.name = ctx.params.name;
            eventObj.dateTime = ctx.params.dateTime;
            eventObj.description = ctx.params.description;
            eventObj.imageURL = ctx.params.imageURL;
        }).then(function () {
            eventService.updateEvent(ctx.params.id, eventObj)
                .then((res) => console.log(res))
                .then(function () {
                    notifications.showSuccess('Event edited successfully');
                    ctx.redirect('#/home');
                })
        })
}

handlers.getJoin = function (ctx) {
    let eventObj = {};
    eventService.getAnEvent(ctx.params.id)
        .then((res) => eventObj = res)
        .then(function () {
            eventObj.interested = Number(eventObj.interested) + 1;
        }).then(function () {
            eventService.updateEvent(ctx.params.id, eventObj)
                .then((res) => console.log(res))
                .then(function () {
                    notifications.showSuccess('You join the event successfully.');
                    ctx.redirect('#/home');
                })
        })
}

handlers.getDelete = function (ctx) {

    eventService.removeEvent(ctx.params.id)
        .then((res) => console.log(res))
        .then(function(){
            notifications.showSuccess('Event closed successfully.');
            ctx.redirect('#/');
        })
}