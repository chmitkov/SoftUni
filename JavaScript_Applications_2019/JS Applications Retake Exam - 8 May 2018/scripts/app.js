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


    //flights routs
    this.get('#/add', handlers.getAdd);
    this.get('#/details/:id', handlers.getDetails);
    this.get('#/edit/:id', handlers.getEdit);
    this.get('#/myFlights', handlers.getMyFlights);
    this.get('#/remove/:id', handlers.removeFlight);

    //flights POST routs
    this.post('#/add', handlers.addFlight);
    this.post('#/edit/:id', handlers.editFlight)

  });
  app.run('#/home');
});