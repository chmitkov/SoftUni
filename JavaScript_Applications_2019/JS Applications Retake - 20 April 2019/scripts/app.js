const handlers = {}

$(() => {
  const app = Sammy('#root', function () {
    this.use('Handlebars', 'hbs');
    // home page routes

    this.get('/index.html', handlers.getHome);
    this.get('/', handlers.getHome);
    this.get('#/home', handlers.getHome);

    // user routes
    this.get('#/register', handlers.getRegister);
    this.get('#/login', handlers.getLogin);
    this.get('#/logout', handlers.logoutUser);

    //user post routes
    this.post('#/register', handlers.registerUser);
    this.post('#/login', handlers.loginUser);

    //recipe routes
    this.get('#/create', handlers.getCreate);
    this.get('#/details/:id', handlers.getDetails);
    this.get('#/edit/:id', handlers.getEdit);
    this.get('#/delete/:id', handlers.deleteRecipe);
    this.get('#/like/:id', handlers.likeRecipe);

    //recipe POST routes
    this.post('#/create', handlers.createRecipe);
    this.post('#/edit/:id', handlers.editRecipe)
    
    
  
  });
  app.run('#/home');
});