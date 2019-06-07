function solve() {
    let levskiSeats = document
        .querySelectorAll('.Levski .seat');
    let litexSeats = document
        .querySelectorAll('.Levski .seat');
    let vipSeats = document
        .querySelectorAll('.Levski .seat');

    function seatSelect(seat, team, sector) {
        seat.style.setProperty('backGrounColor', "rgb(255,0,0)");
        if (seat.style.backgroundColor === 'rgb(255,0,0)') {
            console.log(`Seat ${seat.innerText} in zone ${team} sector ${sector} is unavailable.`)
        }
            console.log(``)
    }

    console.log(levskiSeats);
}