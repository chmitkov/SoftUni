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


    //offers routes 
    this.get('#/create', handlers.getCreate);
    this.get('#/dashboard', handlers.getDashboard)
    this.get('#/edit/:id', handlers.getEdit);
    this.get('#/delete/:id', handlers.getDelete);
    this.get('#/details/:id', handlers.getDetails);
    this.get('#/profile', handlers.getProfile);
    this.get('#/buy/:id' , handlers.buyProduct);

    //offers POST routes
    this.post('#/create', handlers.createOffer);
    this.post('#/edit/:id', handlers.editOffer);
    this.post('#/delete/:id', handlers.deleteOffer);
  
  });
  app.run('#/home');
});