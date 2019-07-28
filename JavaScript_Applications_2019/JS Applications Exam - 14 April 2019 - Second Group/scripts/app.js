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

    //movies routes
    this.get('#/add', handlers.getAdd);
    this.get('#/cinema', handlers.getCinema);
    this.get('#/details/:id', handlers.getDetails);
    this.get('#/buy/:id', handlers.buyTicket);
    this.get('#/myMovies', handlers.getMyMovies)
    this.get('#/edit/:id', handlers.getEditMovie);
    this.get('#/delete/:id', handlers.getDelete);

    //movies posts
    this.post('#/addMovie', handlers.addMovie);
    this.post('#/edit/:id', handlers.editMovie);
    this.post('#/search', handlers.search);
    
  
  });
  app.run('#/home');
});