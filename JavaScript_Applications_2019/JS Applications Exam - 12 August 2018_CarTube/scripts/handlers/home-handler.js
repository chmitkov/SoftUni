handlers.getHome = function (ctx) {
  ctx.isAuth = userService.isAuth();
  ctx.username = sessionStorage.getItem('username');

  if (ctx.isAuth) {
    carService.getAllCars()
      .then(res => Array.from(res))
      .then((data) => {
        ctx.cars = data;
        ctx.isCarsImpty = Array.from(data).length === 0;
      })
      .then(function () {
        ctx.loadPartials({
          header: '../views/common/header.hbs',
          footer: '../views/common/footer.hbs',
          carListings: '../views/car/carListings.hbs',
          car: '../views/car/car.hbs'
        }).then(function () {
          this.partial('../views/home/home.hbs');
        })
      })
  } else {
    ctx.loadPartials({
      header: '../views/common/header.hbs',
      footer: '../views/common/footer.hbs',
      carListings: '../views/car/carListings.hbs',
      car: '../views/car/car.hbs'
    }).then(function () {
      this.partial('../views/home/home.hbs');
    })
  }

}
