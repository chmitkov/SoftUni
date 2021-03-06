handlers.getRegister = function (ctx) {
  ctx.loadPartials({
    header: '../views/common/header.hbs',
    footer: '../views/common/footer.hbs'
  }).then(function () {
    this.partial('../../views/user/registerPage.hbs');
  }).catch(function (err) {
    console.log(err);
  });
}

handlers.registerUser = function (ctx) {

  console.log(ctx);

  let firstName = ctx.params.firstName;
  let lastName = ctx.params.lastName;
  let username = ctx.params.username;
  let password = ctx.params.password;
  let rePassword = ctx.params.repeatPassword;

  if (firstName.length < 2 || lastName.length < 2 || password.length < 6) {
    notifications.showError('First name and Last name must be at least 3 symbols", "Password must be at least 6 symbols');
  } else if (password !== rePassword) {
    notifications.showError('Passwords don\'t match!');
  } else {
    userService.register(username, password).then((res) => {
      userService.saveSession(res);
      notifications.showSuccess('User registered successfully');
      ctx.redirect('#/home');
    }).catch(function (err) {
      notifications.showError(err.responseJSON.description);
    });
  }

}

handlers.getLogin = function (ctx) {
  ctx.loadPartials({
    header: '../views/common/header.hbs',
    footer: '../views/common/footer.hbs'
  }).then(function () {
    this.partial('../../views/user/loginPage.hbs');
  }).catch(function (err) {
    console.log(err);
  });
}

handlers.loginUser = function (ctx) {
  let username = ctx.params.username;
  let password = ctx.params.password;

  if (username.length < 3 || password.length < 6) {
    notify.showError('Username must be at least 3 symbols", "Password must be at least 6 symbols');
  } else {
    userService.login(username, password).then((res) => {
      userService.saveSession(res);
      notifications.showSuccess('User logged in successfully');
      ctx.redirect('#/home');
    }).catch(function (err) {
      notifications.showError(err.responseJSON.description);
    });
  }

}

handlers.logoutUser = function (ctx) {
  userService.logout().then(() => {
    sessionStorage.clear();
    notifications.showSuccess('User logged out successfully');
    ctx.redirect('#/home');
  })
}



handlers.getProfile = function (ctx) {
  ctx.isAuth = userService.isAuth();
  ctx.username = sessionStorage.getItem('username');

  eventService.getAllMyEvents(sessionStorage.getItem('id'))
    .then((res) => Array.from(res))
    .then((data) => { ctx.events = data.map(e => e.name); })
    .then(function () {
      ctx.loadPartials({
        header: '../views/common/header.hbs',
        footer: '../views/common/footer.hbs'
      }).then(function () {
        this.partial('../../views/user/profile.hbs');
      })
    })
}