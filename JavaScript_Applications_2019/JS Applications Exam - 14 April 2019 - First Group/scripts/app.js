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

    this.post('#/register', handlers.registerUser);
    this.post('#/login', handlers.loginUser);
    this.get('#/logout', handlers.logoutUser);

    //event routes
    this.get('#/create', handlers.getCreate);
    this.get('#/details/:id', handlers.getDetails);
    this.get('#/edit/:id', handlers.getEdit);
    this.get('#/join/:id', handlers.getJoin);
    this.get('#/delete/:id', handlers.getDelete);
    this.get('#/profile', handlers.getProfile);

    //event post
    this.post('#/create', handlers.create);
    this.post('#/edit/:id', handlers.edit)
  
  });
  app.run('#/home');
});