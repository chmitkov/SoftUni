const recipeService = (() => {

    function createRecipe(data) {
        return kinvey.post('appdata', 'recipes', 'kinvey', data);
    }

    function getAllRecipes() {
        return kinvey.get('appdata', 'recipes', 'kinvey');
        //'?query={}&sort={"likeCounter": -1}'
    }

    // // // function getMyPets(id) {
    // // //     return kinvey.get('appdata', `pets?query={"_acl.creator":"${id}"}`, 'kinvey');
    // // // }

    // function getAllMyMovies () {
    //     return kinvey.get('appdata', 'movies', 'kinvey', `?query={"_acl.creator":"${sessionStorage.getItem('id')}"}`);
    // }

    function removeRecipe(id) {
        return kinvey.remove('appdata', `recipes/${id}`, 'kinvey');
    }

    function updateRecipe(id, recipe) {
        return kinvey.update('appdata', `recipes/${id}`, 'kinvey', recipe);
    }

    function getARecipe(id) {
        return kinvey.get('appdata', `recipes/${id}`, 'kinvey');
    }

    return {
      createRecipe,
      getAllRecipes,
      getARecipe,
      updateRecipe,
      removeRecipe,

    }
})();