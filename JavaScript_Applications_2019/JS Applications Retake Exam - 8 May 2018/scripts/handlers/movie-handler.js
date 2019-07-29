handlers.getAdd = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    ctx.loadPartials({
        header: '../../views/common/header.hbs',
        footer: '../../views/common/footer.hbs'
    }).then(function () {
        this.partial('../views/movie/add.hbs');
    })
}

handlers.addMovie = function (ctx) {
    let movieObj = {
        title: ctx.params.title,
        description: ctx.params.description,
        imageURL: ctx.params.imageUrl,
        tickets: ctx.params.tickets,
        genres: ctx.params.genres.split(' '),
    };

    if (movieObj.title.length < 6 || movieObj.description.length < 10 ||
        !movieObj.imageURL.startsWith('http') ||
        !movieObj.imageURL.startsWith('https')) {

        notifications.showError('The title should be at least 6 characters long, description should be at least 10 characters long.');
    } else {
        movieService.createMovie(movieObj)
            .then((res) => console.log(res))
            .then(function () {
                notifications.showSuccess('Successfully create Event!');
                ctx.redirect('#/home');
            }).catch(function (err) {
                console.log(err);
            })
    }
}

handlers.getCinema = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    movieService.getAllMovies()
        .then((res) => Array.from(res))
        .then((data) => {
            ctx.pageTitle = 'Cinema';
            ctx.movies = data;
        })
        .then(function () {
            ctx.loadPartials({
                header: '../../views/common/header.hbs',
                footer: '../../views/common/footer.hbs',
                movie: '../../views/movie/movie.hbs'
            }).then(function () {
                this.partial('../views/movie/cinema.hbs');
            })
        })
}

handlers.getDetails = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    movieService.getAMovie(ctx.params.id)
        .then((res) => ctx.movie = res)
        .then(function () {
            ctx.loadPartials({
                header: '../../views/common/header.hbs',
                footer: '../../views/common/footer.hbs'
            }).then(function () {
                this.partial('../views/movie/details.hbs');
            })
        })
}

handlers.buyTicket = function (ctx) {

    movieService.getAMovie(ctx.params.id)
        .then((res) => {
            if (Number(res.tickets) > 0) {
                let obj = { ...res };
                obj.tickets = Number(obj.tickets) - 1;
                movieService.updateMovie(ctx.params.id, obj)
                    .then((res) => {
                        notifications.showSuccess('You are buy ticket for ' + obj.title);
                        ctx.redirect('#/cinema')
                    })
            } else {
                notifications.showError('There is no more tickets!');
            }
        })
}

handlers.getMyMovies = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    movieService.getAllMyMovies(sessionStorage.getItem('id'))
        .then((res) => Array.from(res))
        .then((data) => {
            ctx.pageTitle = 'My Movies';
            ctx.movies = data;
        })
        .then(function () {
            ctx.loadPartials({
                header: '../../views/common/header.hbs',
                footer: '../../views/common/footer.hbs',
                movie: '../../views/movie/myMovie.hbs'
            }).then(function () {
                this.partial('../views/movie/cinema.hbs');
            })
        })
}

handlers.getEditMovie = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    movieService.getAMovie(ctx.params.id)
        .then(res => ctx.movie = { ...res })
        .then(function () {
            ctx.loadPartials({
                header: '../../views/common/header.hbs',
                footer: '../../views/common/footer.hbs'
            }).then(function () {
                this.partial('../views/movie/edit.hbs');
            })
        })
}

handlers.editMovie = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');

    let movieObj = {};
    movieService.getAMovie(ctx.params.id)
        .then((res) => movieObj = res)
        .then(function () {
            movieObj.title = ctx.params.title;
            movieObj.imageURL = ctx.params.imageUrl;
            movieObj.description = ctx.params.description;
            movieObj.genres = ctx.params.genres.split(',');
            movieObj.tickets = ctx.params.tickets;
        }).then(function () {
            movieService.updateMovie(ctx.params.id, movieObj)
                .then((res) => console.log(res))
                .then(function () {
                    notifications.showSuccess('Movie edited successfully');
                    ctx.redirect('#/home');
                })
        })
}

handlers.getDelete = function (ctx) {
    movieService.removeMovie(ctx.params.id)
        .then((res) => {
            notifications.showSuccess('Successfully remove movie!');
            ctx.redirect('#/myMovies');
        })
}

handlers.search = function (ctx) {
    ctx.isAuth = userService.isAuth();
    ctx.username = sessionStorage.getItem('username');
    let searchGanre = ctx.params.search;

    movieService.getAllMovies()
        .then((res) => Array.from(res))
        .then((data) => {
            ctx.pageTitle = 'Cinema';
            console.log(data);
            ctx.movies = Array.from(data).filter(m => m.genres.includes(searchGanre));
        })
        .then(function () {
            ctx.loadPartials({
                header: '../../views/common/header.hbs',
                footer: '../../views/common/footer.hbs',
                movie: '../../views/movie/movie.hbs'
            }).then(function () {
                this.partial('../views/movie/cinema.hbs');
            })
        })
}