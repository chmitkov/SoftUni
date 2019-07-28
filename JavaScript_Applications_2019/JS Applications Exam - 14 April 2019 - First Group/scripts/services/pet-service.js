const petService = (() => {

    function createPet(data) {
        return kinvey.post('appdata', 'pets', 'kinvey', data);
    }

    function getAllPets() {
        return kinvey.get('appdata', 'pets?query={}&sort={"likeCounter": -1}', 'kinvey');
        //'?query={}&sort={"likeCounter": -1}'
    }

    function getMyPets(id) {
        return kinvey.get('appdata', `pets?query={"_acl.creator":"${id}"}`, 'kinvey');
    }

    // function getAllMySongs () {
    //     return kinvey.get('appdata', 'songs', 'kinvey', `?query={"_acl.creator":"${sessionStorage.getItem('id')}"}`);
    // }

    function removePet (id) {
        return kinvey.remove('appdata', `pets/${id}`, 'kinvey');
    }

    function updatePet (id, pet) {
        return kinvey.update('appdata', `pets/${id}`, 'kinvey', pet);
    }

    function getAPet (id) {
        return kinvey.get('appdata', `pets/${id}`, 'kinvey');
    }

    return {
        createPet,
        getAllPets,
        getMyPets,
        getAPet,
        updatePet,
        removePet,

    }
})();