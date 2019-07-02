class SoftUniFy {
    constructor() {
        this.allSongs = {};
    }

    downloadSong(artist, song, lyrics) {
        if (!this.allSongs[artist]) {
            this.allSongs[artist] = {rate: 0, votes: 0, songs: []}
        }

        this.allSongs[artist]['songs'].push(`${song} - ${lyrics}`);

        return this;
    }

    playSong(song) {
        let songArtists = Object.keys(this.allSongs).reduce((acc, cur) => {

            let songs = this.allSongs[cur]['songs']
                .filter((songInfo) => songInfo
                    .split(/ - /)[0] === song);

            if (songs.length > 0) {
                acc[cur] = songs;
            }

            return acc;
        }, {});

        let arr = Object.keys(songArtists);
        let output = "";

        if (arr.length > 0) {

            arr.forEach((artist) => {
                output += `${artist}:\n`;
                output += `${songArtists[artist].join('\n')}\n`;
            });

        } else {
            output = `You have not downloaded a ${song} song yet. Use SoftUniFy's function downloadSong() to change that!`
        }

        return output;
    }

    get songsList() {
        let songs = Object.values(this.allSongs)
            .map((v) => v['songs'])
            .reduce((acc, cur) => {
                return acc.concat(cur);
            }, []);

        let output;

        if (songs.length > 0) {
            output = songs.join('\n');
        } else {
            output = 'Your song list is empty';
        }

        return output;

    }

    rateArtist() {
        let artistExist = this.allSongs[arguments[0]];
        let output;

        if (artistExist) {

            if (arguments.length === 2) {
                artistExist['rate'] += +arguments[1];
                artistExist['votes'] += 1;
            }

            let currentRate = (+(artistExist['rate'] / artistExist['votes']).toFixed(2));
            isNaN(currentRate) ? output = 0 : output = currentRate;

        } else {
            output = `The ${arguments[0]} is not on your artist list.`
        }

        return output;
    }
}

let expect = require('chai').expect;

describe('Test class Softunify', function () {
    let soft;

    beforeEach('Make new instance of Softunify before each test', function () {
        soft = new SoftUniFy();
    });

    describe('Test constructor', function () {
        it('should return a empty object', function () {
            expect(Object.keys(soft.allSongs).length).to.be.equal(0);
        });
    });

    describe('Test downloadSong functions', function () {
        it('should return map with one song', function () {
            soft.downloadSong('Artist', 'Song', 'Lyrics');
            expect(soft.allSongs.hasOwnProperty('Artist'))
                .to.be.equal(true);

            expect(soft.allSongs['Artist']['songs'].length)
                .to.be.equal(1);

            expect(soft.allSongs['Artist']['songs'][0])
                .to.be.equal('Song - Lyrics');
        });
        
    });

    describe('Test songsList function', function () {
        it('should return message with empty songList', function () {
            expect(soft.songsList)
                .to.be.equal('Your song list is empty');
        });

        it('should work corrent with two songs', function () {
            soft.downloadSong('Artist1', 'Song1', 'Lyrics1');
            soft.downloadSong('Artist2', 'Song2', 'Lyrics2');

            expect(soft.songsList).to.be.equal('Song1 - Lyrics1\nSong2 - Lyrics2');
        });
    });

    describe('Test rateArtist function', function () {
        it('should return artist not in your list', function () {
            expect(soft.rateArtist('ArtistNotInMyList'))
                .to.be.equal('The ArtistNotInMyList is not on your artist list.');
        });
        it('should return 0 with second param string', function () {
            soft.downloadSong('Artist', 'Song', 'Lyrics');
            expect(soft.rateArtist('Artist', 'str'))
                .to.be.equal(0);
        });
        it('should return correct result for Artist', function () {
            soft.downloadSong('Artist', 'Song', 'Lyrics');
            expect(soft.rateArtist('Artist', 5.5))
                .to.be.equal(5.5);
        });
    });

    describe('Test playSong function', function () {
        it('should return "not downloaded yet"', function () {
            expect(soft.playSong('MissingSong'))
                .to.be.equal('You have not downloaded a MissingSong song yet. Use SoftUniFy\'s function downloadSong() to change that!')
        });
        it('should retrun list with songs to play', function () {
            soft.downloadSong('Artist', 'Song', 'Lyrics');
            soft.downloadSong('Artist2', 'Song', 'Lyrics2');
            soft.downloadSong('Artist3', 'Song3', 'Lyrics3');

            expect(soft.playSong('Song'))
                .to.be.equal('Artist:\nSong - Lyrics\nArtist2:\nSong - Lyrics2\n');
            expect(soft.playSong('Song3'))
                .to.be.equal('Artist3:\nSong3 - Lyrics3\n')
        });
    });
});
