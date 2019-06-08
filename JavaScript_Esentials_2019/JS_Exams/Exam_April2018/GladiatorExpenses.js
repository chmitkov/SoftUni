function solve(fights, helmetPrice, swordPrice, shieldPrice, armorPrice) {

    let brokenHelmet = 0;
    let brokenSword = 0;
    let brokenShield = 0;
    let brokenArmor = 0;

    for (let i = 1; i < fights; i++) {
        if (i % 2 === 0) {
            ++brokenHelmet;
        }
        if (i % 3 === 0) {
            ++brokenSword;
        }
        if (i % 2 === 0 && i % 3 === 0) {
            ++brokenShield;
        }
        if (brokenShield !== 0 && brokenShield % 2 === 0) {
            ++brokenArmor;
        }
    }

    let total = brokenArmor * armorPrice +
        helmetPrice * brokenHelmet +
        swordPrice * brokenSword +
        shieldPrice * brokenShield;

    console.log(`Gladiator expenses: ${total.toFixed(2)} aureus`);
}

solve(7, 2, 3, 4, 5);