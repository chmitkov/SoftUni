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

handlers.registerUser = function (ctx) {

  console.log('Im in register user')
  let username = ctx.params.username;
  let password = ctx.params.password;
  if (username.length < 3 || password.length < 6) {
    notify.showError('Username must be at least 3 symbols", "Password must be at least 6 symbols');
    ctx.redirect('#/register');
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

handlers.logoutUser = function (ctx) {
  userService.logout().then(() => {
    sessionStorage.clear();
    notifications.showSuccess('User logged out successfully');
    ctx.redirect('#/home');
  })
}

handlers.loginUser = function (ctx) {
  let username = ctx.params.username;
  let password = ctx.params.password;

  if (username.length < 3 || password.length < 6) {
    notify.showError('Username must be at least 3 symbols", "Password must be at least 6 symbols');
    ctx.redirect('#/login');
  } else {

    userService.login(username, password).then((res) => {
      userService.saveSession(res);
      notifications.showSuccess('User logged in successfully');
      ctx.redirect('#/dashboard/all');
    }).catch(function (err) {
      notifications.showError(err.responseJSON.description);
    });
  }

}