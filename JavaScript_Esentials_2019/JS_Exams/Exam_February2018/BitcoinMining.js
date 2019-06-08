function solve(arr) {
    let bitCoins = 0;
    let dayOfFirstBuy = -1;
    let totalLeva = 0;
    let priceOfGold = 67.51;
    let priceOfBitCoin = 11949.16;


    for (let i = 0; i < arr.length; i++) {
        let income = Number(arr[i]);
        if (i+1 % 3 === 0) {
            income *= 0.7;
        }
        income *= priceOfGold;

        totalLeva += income;
        if (totalLeva >= priceOfBitCoin) {
            while (totalLeva >= priceOfBitCoin) {
                totalLeva -= priceOfBitCoin;
                bitCoins++;
            }
            if (dayOfFirstBuy === -1) {
                dayOfFirstBuy = i + 1;
            }
        }
    }
    console.log(`Bought bitcoins: ${bitCoins}
            Day of the first purchased bitcoin: ${dayOfFirstBuy}
            Left money: ${totalLeva.toFixed(2)} lv.`)


}

solve(["100", "200", "300"]);