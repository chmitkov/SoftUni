const offerService = (() => {

    function createOffer(data) {
        return kinvey.post('appdata', 'offers', 'kinvey', data);
    }

    function getAllOffers() {
        return kinvey.get('appdata', 'offers', 'kinvey');
    }


    function getAllProductsIBuy () {
        return kinvey.get('appdata', 'offers', 'kinvey', `?query={"buyer":"${sessionStorage.getItem('username')}"}`);
    }

    function removeOffer(id) {
        return kinvey.remove('appdata', `offers/${id}`, 'kinvey');
    }

    function updateOffer(id, offer) {
        return kinvey.update('appdata', `offers/${id}`, 'kinvey', offer);
    }

    function getAnOffer(id) {
        return kinvey.get('appdata', `offers/${id}`, 'kinvey');
    }

    return {
        createOffer,
        getAllOffers,
        getAnOffer,
        updateOffer,
        removeOffer,
        getAllProductsIBuy
    }
})();