const eventService = (() => {

    function createEvent(data) {
        return kinvey.post('appdata', 'events', 'kinvey', data);
    }

    function getAllSongs() {
        return kinvey.get('appdata', 'events', 'kinvey');
        //'?query={}&sort={"likeCounter": -1}'
    }

    // function getMyPets(id) {
    //     return kinvey.get('appdata', `pets?query={"_acl.creator":"${id}"}`, 'kinvey');
    // }

    function getAllMyEvents () {
        return kinvey.get('appdata', 'events', 'kinvey', `?query={"_acl.creator":"${sessionStorage.getItem('id')}"}`);
    }

    function removeEvent(id) {
        return kinvey.remove('appdata', `events/${id}`, 'kinvey');
    }

    function updateEvent(id, event) {
        return kinvey.update('appdata', `events/${id}`, 'kinvey', event);
    }

    function getAnEvent(id) {
        return kinvey.get('appdata', `events/${id}`, 'kinvey');
    }

    return {
        getAllSongs,
        createEvent,
        getAnEvent,
        updateEvent,
        removeEvent,
        getAllMyEvents
    }
})();