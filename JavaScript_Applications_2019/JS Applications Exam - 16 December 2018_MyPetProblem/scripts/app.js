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

    // songs routes
    this.get('#/allSongs', handlers.getAllSongs);
    this.get('#/createSong', handlers.getCreateSong);
    this.get('#/mySongs', handlers.getMySongs);
    this.get('#/remove/:id', handlers.removeSong);
    this.get('#/like/:id', handlers.likeSong);

    this.post('#/createSong', handlers.createSong);

    // pets routes
    this.get('#/dashboard/(:category)?', handlers.getDashboard);
    this.get('#/createPet', handlers.getCreatePet);
    this.get('#/myPets', handlers.getMyPets);
    this.get('#/details/(:id)?', handlers.getDetails);
    this.get('#/delete/:id', handlers.getDeletePet);
        this.get('#/otherDetails/:id', handlers.getOtherDetails);
        this.get('#/like', handlers.likePet);

  
    //pets post routs
    this.post('#/createPet', handlers.createPet);
    this.post('#/save/(:id)?', handlers.savePet);
    this.post('#/deletePet/(:id)?', handlers.deletePet);
  
  });
  app.run('#/home');
});