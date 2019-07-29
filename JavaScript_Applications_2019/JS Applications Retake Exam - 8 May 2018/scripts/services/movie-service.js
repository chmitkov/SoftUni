const movieService = (() => {

    function createMovie(data) {
        return kinvey.post('appdata', 'movies', 'kinvey', data);
    }

    function getAllMovies() {
        return kinvey.get('appdata', 'movies', 'kinvey');
        //'?query={}&sort={"likeCounter": -1}'
    }

    // // function getMyPets(id) {
    // //     return kinvey.get('appdata', `pets?query={"_acl.creator":"${id}"}`, 'kinvey');
    // // }

    function getAllMyMovies () {
        return kinvey.get('appdata', 'movies', 'kinvey', `?query={"_acl.creator":"${sessionStorage.getItem('id')}"}`);
    }

    function removeMovie(id) {
        return kinvey.remove('appdata', `movies/${id}`, 'kinvey');
    }

    function updateMovie(id, event) {
        return kinvey.update('appdata', `movies/${id}`, 'kinvey', event);
    }

    function getAMovie(id) {
        return kinvey.get('appdata', `movies/${id}`, 'kinvey');
    }

    return {
       createMovie,
       getAllMovies,
       updateMovie,
       getAMovie,
       getAllMyMovies,
       removeMovie,
    }
})();