handlers.getHome = async function (ctx) {
  ctx.isAuth = userService.isAuth();
  ctx.username = sessionStorage.getItem('username');
  let recipes;
  if(ctx.isAuth){
     recipes = await recipeService.getAllRecipes();
    ctx.isEmpty = recipes.length === 0;
    ctx.recipes = Array.from(recipes); 
  }

  ctx.loadPartials({
    header: '../views/common/header.hbs',
    footer: '../views/common/footer.hbs',
    notFound: '../views/recipe/notFound.hbs',
    allRecipes: '../views/recipe/sharedRecipes.hbs',
    recipe: '../views/recipe/recipe.hbs'
  }).then(function () {
    this.partial('../views/home/home.hbs');
  })
}
