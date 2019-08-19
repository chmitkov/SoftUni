handlers.getCreate = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');


    ctx.loadPartials({
        header: '../../views/common/header.hbs',
        footer: '../../views/common/footer.hbs'
    }).then(function () {
        this.partial('../views/offer/create.hbs');
    })
}

handlers.createOffer = function (ctx) {
    let offerObj = { ...ctx.params, buyer: '' };

    if (offerObj.product === '' || offerObj.descriptio === '' ||
        offerObj.price === '' ||
        !offerObj.pictureUrl.startsWith('http')) {
        notifications.showError('product, description and price should be non-empty strings.');
    } else {
        offerService.createOffer(offerObj)
            .then((res) => console.log(res))
            .then(function () {
                notifications.showSuccess('Successfully create Offer!');
                ctx.redirect('#/dashboard');
            }).catch(function (err) {
                console.log(err);
            })
    }
}

handlers.getDashboard = async function (ctx) {

    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    try {
        let offers = await offerService.getAllOffers();
        let userId = sessionStorage.getItem('id');
        let counter = -1;
        offers.forEach((o) => {
            o.isCreator = o._acl.creator === userId;
            o.number = ++counter;
        });

        ctx.offers = offers;

        ctx.loadPartials({
            header: '../views/common/header.hbs',
            footer: '../views/common/footer.hbs',
            offer: '../../views/offer/offer.hbs'
        }).then(function () {
            this.partial('../views/offer/dashboard.hbs');
        })
    } catch (e) {
        console.log(e);
    }

}

handlers.getEdit = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    offerService.getAnOffer(ctx.params.id)
        .then(res => ctx.offer = { ...res })
        .then(function () {
            ctx.loadPartials({
                header: '../../views/common/header.hbs',
                footer: '../../views/common/footer.hbs'
            }).then(function () {
                this.partial('../views/offer/edit.hbs');
            })
        })
}

handlers.editOffer = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    let offerObj = {};
    offerService.getAnOffer(ctx.params.id)
        .then((res) => offerObj = res)
        .then(function () {
            offerObj.product = ctx.params.product;
            offerObj.description = ctx.params.description;
            offerObj.price = ctx.params.price;
            offerObj.pictureUrl = ctx.params.pictureUrl;

        }).then(function () {
            offerService.updateOffer(ctx.params.id, offerObj)
                .then((res) => console.log(res))
                .then(function () {
                    notifications.showSuccess('Offer edited successfully');
                    ctx.redirect('#/dashboard');
                })
        })
}

handlers.getDelete = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    offerService.getAnOffer(ctx.params.id)
        .then(res => ctx.offer = { ...res })
        .then(function () {
            ctx.loadPartials({
                header: '../../views/common/header.hbs',
                footer: '../../views/common/footer.hbs'
            }).then(function () {
                this.partial('../views/offer/delete.hbs');
            })
        })
}

handlers.deleteOffer = function (ctx) {
    offerService.removeOffer(ctx.params.id)
        .then((res) => {
            notifications.showSuccess('Successfully remove offer!');
            ctx.redirect('#/dashboard');
        })
}

handlers.getDetails = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    offerService.getAnOffer(ctx.params.id)
        .then(res => ctx.offer = { ...res })
        .then(function () {
            ctx.loadPartials({
                header: '../../views/common/header.hbs',
                footer: '../../views/common/footer.hbs'
            }).then(function () {
                this.partial('../views/offer/details.hbs');
            })
        })
}

handlers.getProfile = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    offerService.getAllProductsIBuy()
        .then((res) => Array.from(res))
        .then((data) => {
            ctx.offers = data;
        })
        .then(function () {
            ctx.loadPartials({
                header: '../../views/common/header.hbs',
                footer: '../../views/common/footer.hbs',
            }).then(function () {
                this.partial('../views/user/profile.hbs');
            })
        })
}

handlers.buyProduct = function (ctx) {

    let offerObj = {};
    offerService.getAnOffer(ctx.params.id)
        .then((res) => offerObj = res)
        .then(function () {
            offerObj.buyer = sessionStorage.getItem('username');
        }).then(function () {
            offerService.updateOffer(ctx.params.id, offerObj)
                .then((res) => console.log(res))
                .then(function () {
                    notifications.showSuccess('Offer buyed successfully');
                    ctx.redirect('#/dashboard');
                })
        })

}

