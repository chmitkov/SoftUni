const flightService = (() => {

    function createFlight(data) {
        return kinvey.post('appdata', 'flights', 'kinvey', data);
    }

    function getAllFlights() {
        return kinvey.get('appdata', 'flights', 'kinvey');
        //'?query={}&sort={"likeCounter": -1}'
    }

    // // // function getMyPets(id) {
    // // //     return kinvey.get('appdata', `pets?query={"_acl.creator":"${id}"}`, 'kinvey');
    // // // }

    function getAllMyFlights() {
        return kinvey.get('appdata', 'flights', 'kinvey', `?query={"_acl.creator":"${sessionStorage.getItem('id')}"}`);
    }

    function removeFlight(id) {
        return kinvey.remove('appdata', `flights/${id}`, 'kinvey');
    }

    function updateFlight(id, flight) {
        return kinvey.update('appdata', `flights/${id}`, 'kinvey', flight);
    }

    function getAFlight(id) {
        return kinvey.get('appdata', `flights/${id}`, 'kinvey');
    }

    return {
        getAllFlights,
        createFlight,
        getAFlight,
        updateFlight,
        getAllMyFlights,
        removeFlight
    }
})();