class FilmStudio {

    constructor(studioName) {
        this.name = studioName;
        this.films = [];
    }

    casting(actor, role) {
        let isTheActorIsUnemployed = true;
        let output;

        if (this.films.length) {

            for (let f of this.films) {

                let roles = f.filmRoles.filter((r) => r.role === role);

                if (roles.length) {
                    let filmIndex = this.films.indexOf(f);
                    let wantedRole = this.films[filmIndex].filmRoles.filter((fR) => fR.role === role)[0];
                    let roleIndex = this.films[filmIndex].filmRoles.indexOf(wantedRole);

                    this.films[filmIndex].filmRoles[roleIndex].actor = actor;
                    isTheActorIsUnemployed = false;
                    output = `You got the job! Mr. ${actor} you are next ${role} in the ${f.filmName}. Congratz!`;
                    break;
                }
            }

            if (isTheActorIsUnemployed) {
                output = `${actor}, we cannot find a ${role} role...`;
            }

        } else {
            output = `There are no films yet in ${this.name}.`;
        }

        return output;
    }

    makeMovie(filmName, roles) {

        if (arguments.length === 2) {

            let firstArgIsString = typeof arguments[0] === 'string';
            let secondArgIsArray = arguments[1] instanceof Array;

            if (firstArgIsString && secondArgIsArray) {
                let findedFilms = this.films.filter((f) => f.filmName.includes(filmName));

                let filmRoles = roles.reduce((acc, cur) => {
                    let curFilmRole = {
                        role: cur,
                        actor: false
                    };
                    acc.push(curFilmRole);
                    return acc;
                }, []);

                let film = {
                    filmName,
                    filmRoles
                };

                if (findedFilms.length > 0) {
                    film.filmName += ` ${++findedFilms.length}`;
                }

                this.films.push(film);
                return film;
            } else {
                throw ('Invalid arguments')
            }

        } else {
            throw ('Invalid arguments count')
        }
    }

    lookForProducer(film) {

        let f = this.films.filter((f) => f.filmName === film)[0];
        let output;

        if (f) {
            output = `Film name: ${f.filmName}\n`;
            output += 'Cast:\n';
            Object.keys(f.filmRoles).forEach((role) => {
                output += `${f.filmRoles[role].actor} as ${f.filmRoles[role].role}\n`;
            });
        } else {
            throw new Error(`${film} do not exist yet, but we need the money...`)
        }

        return output;
    }
}

let expect = require('chai').expect;


describe("Film Studio", function () {

    let studio;

    beforeEach(function () {
        studio = new FilmStudio('TestName');
    });

    describe("Constructor Test", function () {
        it('should work with correct arguments', function () {
            studio = new FilmStudio("TestName");
            expect(studio.name).to.be.equal('TestName');
            expect(studio.films.length).to.be.equal(0);
            //expect(studio.films.isArray()).to.be.equal(true);
        });
    });

    describe('Make movie', function () {
        it('test with only one argument', function () {
            expect(() => studio.makeMovie('FirstArg'))
                .to.throw('Invalid arguments count');
        });
        it('test with three argument', function () {
            expect(() => studio.makeMovie('FirstArg', 'Second', 'Third'))
                .to.throw('Invalid arguments count');
        });

        it('test with number as first argument', function () {
            expect(() => studio.makeMovie(2, ["TestRole"]))
                .to.throw('Invalid arguments');
        });

        it('test with string as second argument', function () {
            expect(() => studio.makeMovie("TestName", 'string'))
                .to.throw('Invalid arguments');
        });

        it('test with object as first argument', function () {
            expect(() => studio.makeMovie({name: "Test"}, ["TestRole"]))
                .to.throw('Invalid arguments');
        });

        it('test with object as second argument', function () {
            expect(() => studio.makeMovie("TestName", {name: 'Test'}))
                .to.throw('Invalid arguments');
        });

        it('should work with right parameters', function () {
            let film = studio.makeMovie('TestName', ['TestRole']);

            expect(typeof film).to.be.equal('object');
            expect(film.filmName).to.be.equal('TestName');
            expect(studio.films.length).to.be.equal(1);
            //expect(film.filmRoles).to.be.equal([ { role: 'TestRole', actor: false } ]);
        });

        it('should work with sequal fils', function () {
            let firstFilm = studio.makeMovie('TestName', ['TestRole']);
            let secondFilm = studio.makeMovie('TestName', ['TestRole']);

            expect(secondFilm.filmName).to.be.equal('TestName 2');
            expect(studio.films.length).to.be.equal(2);
        });
    });

    describe('Casting', function () {
        it('if there are no films yet', function () {
            expect(studio.casting('TestActor', 'testRole'))
                .to.be.equal('There are no films yet in TestName.');
        });

        it('can\'t find role for this actor', function () {
            studio.makeMovie('FilmOne', ['RoleOne']);
            expect(studio.casting('ActorOne', 'RoleTwo'))
                .to.be.equal('ActorOne, we cannot find a RoleTwo role...')
        });

        it('successful find work for actor', function () {
            let movie = studio.makeMovie('FilmOne', ['RoleOne']);
            expect(studio.casting('ActorOne', 'RoleOne'))
                .to.be.equal('You got the job! Mr. ActorOne you are next RoleOne in the FilmOne. Congratz!')

            let roles = movie.filmRoles;
            console.log();
            expect(movie.filmRoles[0].actor)
                .to.be.equal('ActorOne');
        });
    })

    describe('Look for producer', function () {
        it("can't find given movie", function () {
            expect(()=>studio.lookForProducer("FilmTwo"))
                .to.throw('FilmTwo do not exist yet, but we need the money...');
        });

        it('should work correct with all right arguments', function () {
            studio.makeMovie('FilmOne', ['RoleOne']);
            studio.casting('ActorOne', 'RoleOne');

            expect(studio.lookForProducer("FilmOne"))
                .to.be.equal('Film name: FilmOne\nCast:\nActorOne as RoleOne\n');
        });
    })

});

