handlers.getCreate = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    ctx.loadPartials({
        header: '../views/common/header.hbs',
        footer: '../views/common/footer.hbs',
    }).then(function () {
        this.partial('../views/recipe/create.hbs');
    })
}

handlers.createRecipe = function (ctx) {

    let recipeObj = { ...ctx.params, likesCounter: 0 };
    recipeObj.ingredients = ctx.params.ingredients.split(',');
    console.log(recipeObj);

    if (recipeObj.meal.length < 4 ||
        recipeObj.prepMethod.length < 5 ||
        recipeObj.description.length < 5 ||
        !recipeObj.foodImageURL.startsWith('http')) {

        notifications.showError('The title should be at least 6 characters long, description should be at least 10 characters long.');
    } else {
        recipeService.createRecipe(recipeObj)
            .then((res) => console.log(res))
            .then(function () {
                notifications.showSuccess('Successfully create Recipe!');
                ctx.redirect('#/home');
            }).catch(function (err) {
                console.log(err);
            })
    }
}

handlers.getDetails = async function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');


    ctx.recipe = await recipeService.getARecipe(ctx.params.id);

    ctx.loadPartials({
        header: '../views/common/header.hbs',
        footer: '../views/common/footer.hbs',
    }).then(function () {
        this.partial('../views/recipe/details.hbs');
    })
}

handlers.getEdit = async function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    ctx.recipe = await recipeService.getARecipe(ctx.params.id);

    ctx.loadPartials({
        header: '../views/common/header.hbs',
        footer: '../views/common/footer.hbs',
    }).then(function () {
        this.partial('../views/recipe/edit.hbs');
    })
}

handlers.editRecipe = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    let recipeObj = {};
    recipeService.getARecipe(ctx.params.id)
        .then((res) => recipeObj = res)
        .then(function () {
            recipeObj.meal = ctx.params.meal;
            recipeObj.foodImageURL = ctx.params.foodImageURL;
            recipeObj.description = ctx.params.description;
            recipeObj.category = ctx.params.category;
            recipeObj.ingredients = ctx.params.ingredients.split(',');
            recipeObj.prepMethod = ctx.params.prepMethod;
        }).then(function () {
            recipeService.updateRecipe(ctx.params.id, recipeObj)
                .then((res) => console.log(res))
                .then(function () {
                    notifications.showSuccess('Recipe edited successfully');
                    ctx.redirect('#/home');
                })
        })
}

handlers.deleteRecipe = function (ctx) {
    recipeService.removeRecipe(ctx.params.id)
        .then((res) => {
            notifications.showSuccess('Successfully remove movie!');
            ctx.redirect('#/home');
        })
}

handlers.likeRecipe =  function (ctx) {
    let recipeObj = {};
    recipeService.getARecipe(ctx.params.id)
        .then((res) => recipeObj = res)
        .then(function () {
            recipeObj.likesCounter = Number(recipeObj.likesCounter) + 1;
        }).then(function () {
            recipeService.updateRecipe(ctx.params.id, recipeObj)
                .then((res) => console.log(res))
                .then(function () {
                    notifications.showSuccess('Recipe liked successfully');
                    ctx.redirect('#/details/' + recipeObj._id);
                })
        })

}