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

    //cars routs

    this.get('#/details/:id', handlers.getDetails);
    this.get('#/edit/:id', handlers.getEdit);
    this.get('#/create', handlers.getCreate);
    this.get('#/delete/:id', handlers.deleteCar);
    this.get('#/myCars', handlers.getMyCars);
    //cars POST routs
    this.post('#/edit/:id', handlers.editCar);
    this.post('#/create', handlers.createCar);
  
  });
  app.run('#/home');
});