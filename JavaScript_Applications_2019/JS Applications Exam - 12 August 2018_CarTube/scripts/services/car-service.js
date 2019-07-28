const carService = (() => {

    function createCar(data) {
        return kinvey.post('appdata', 'cars', 'kinvey', data);
    }

    function getAllCars() {
        return kinvey.get('appdata', 'cars'+'?query={}&sort={"_kmd.ect": -1}', 'kinvey');
    }

    // // // function getMyPets(id) {
    // // //     return kinvey.get('appdata', `pets?query={"_acl.creator":"${id}"}`, 'kinvey');
    // // // }

    function getAllMyCars () {
        return kinvey.get('appdata', 'cars', 'kinvey', `?query={"_acl.creator":"${sessionStorage.getItem('id')}"}`);
    }

    function removeCar(id) {
        return kinvey.remove('appdata', `cars/${id}`, 'kinvey');
    }

    function updateCar(id, car) {
        return kinvey.update('appdata', `cars/${id}`, 'kinvey', car);
    }

    function getACar(id) {
        return kinvey.get('appdata', `cars/${id}`, 'kinvey');
    }

    return {
       getAllCars,
       getACar,
       updateCar,
       createCar,
       removeCar,
       getAllMyCars
    }
})();