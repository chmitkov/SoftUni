handlers.getHome = function (ctx) {
  ctx.isAuth = userService.isAuth();
  ctx.username = sessionStorage.getItem('username');

  if (ctx.isAuth) {
    eventService.getAllSongs()
      .then((response) => Array.from(response))
      .then((data) => ctx.events = data)
      .then(function () {
        ctx.loadPartials({
          header: '../views/common/header.hbs',
          footer: '../views/common/footer.hbs',
          event: '../views/events/event.hbs'
        }).then(function () {
          this.partial('../views/home/home.hbs');
        })
      })
  } else {
    ctx.loadPartials({
      header: '../views/common/header.hbs',
      footer: '../views/common/footer.hbs',
      event: '../views/events/event.hbs'
    }).then(function () {
      this.partial('../views/home/home.hbs');
    })
  }

}