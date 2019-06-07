
function solve(str) {
    let arr = str.split(' ');
    let mapWithCharacters = {
        '.-':'a',
        '-...':'b',
        '-.-.':'c',
        '-..':'d',
        '.':'e',
        '..-.':'f',
        '--.':'g',
        '....':'h',
        '..':'i',
        '.---':'j',
        '-.-':'k',
        '.-..':'l',
        '-.':'n',
        '---':'o',
        '.--.':'p',
        '--.-':'q',
        '.-.':'r',
        '...':'s',
        '-':'t',
        '..-':'u',
        '...-':'v',
        '.--':'w',
        '-..-':'x',
        '-.--':'y',
        '--..':'z',
    };
    let result = '';
    arr.forEach(x => {
        result += mapWithCharacters[x];
    });
    console.log(result);
}


solve(".... . .-.. .-.. ---");