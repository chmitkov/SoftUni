/*
    Problem 01. Fruit 
*/
function fruit (fruit, weight, price){
    
    console.log(`I need $${(weight/1000 * price).toFixed(2)} to buy ${(weight/1000).toFixed(2)} kilograms ${fruit}.`)
};

//fruit('orange', 2500, 1.80);


/*
    Problem 02. Greatest Common Divisor – GCD 
*/

function gdc(num1, num2){
    let best = 0;
    let smallNumber = Math.min(+num1, +num2);
    let bigNumber = Math.max(+num1, +num2);
    for(let i = smallNumber; i > 0; i--){
        if(smallNumber%i === 0 && bigNumber%i===0){
            best = i;
            break;
        }
    }

    console.log(best);
    
}

//gdc(15, 5);


/*
    Problem 03. Same Numbers  
*/

function solve(num){
    let equal = true;
    let numberToString = num.toString();
    let sum = 0;
    for(let i= 0; i < numberToString.length - 1; i++){
        if(equal === true){
            if (numberToString.charAt(i) != numberToString.charAt(i+1)){
                equal = false;
            }
        }
        sum+= Number(numberToString.charAt(i));
    }
    console.log(equal);
    console.log(sum + Number(numberToString.charAt(numberToString.length-1)));  
}

//solve(222);


/*
    04. Time to Walk 
*/

function timeToWalk(steps, footprintInMeters, speed){
    let rests = parseInt((steps*footprintInMeters)/500);

    let totalSeconds = ((steps*footprintInMeters)/1000)/speed * 3600 + rests*60;

    let hours = parseInt(totalSeconds/3600);
    hours = hours < 10 ? '0'+hours : hours;
     
    let minutes = parseInt((totalSeconds%3600)/60);
    minutes = minutes < 10 ? '0'+minutes : minutes;

    let seconds  = Math.round(totalSeconds % 60);
    seconds = seconds < 10 ? '0'+seconds : seconds;    

    console.log(`${hours}:${minutes}:${seconds}`);
  
}

//timeToWalk(4000, 0.60, 5);


/*
    05. Calorie Object 
*/

function calories(arr){
    
    let obj = {};
    for(let i = 0; i < arr.length-1 ; i+=2){
        obj[arr[i]] = Number(arr[i+1]);
    } 

    console.log(obj);
    
}

//calories(['Yoghurt', 48, 'Rise', 138, 'Apple', 52])


/*
    06. Road Radar 
*/

function roadRadar(arr){
    let speed = +arr[0];
    let area =  arr[1];
    let result = '';

    function outputFunc(speed, limit){
        if(speed > limit){
            if (speed <= limit+20){
                return 'speeding';
            }else if(speed <= limit+40){
                return 'excessive speeding';
            }else {
                return 'reckless driving';
            }
        }else{
            return '';
        }
    }

    switch (area) {
        case 'motorway':
            result = outputFunc(speed, 130);
            break;
        case 'interstate':
            result = outputFunc(speed, 90);
            break;
        case 'city':
            result = outputFunc(speed, 50);
            break;
        case 'residential':
            result = outputFunc(speed, 20);
            break;
    }

    console.log(result);
    
}

//roadRadar([60, 'city']);

/*
    07. Cooking by Numbers 
*/

function cooking(arr){
    let number = Number(arr[0]);
    //console.log(number);
    
    for(let i = 1; i < arr.length; i++){
        number = makeOperation(number, arr[i]);
        console.log(number);
    }

    function makeOperation(num, operation){
        switch(operation){
            case 'chop':
                return num/2;
            case 'dice':
                return Math.sqrt(num);
            case 'spice':
                return ++num;
            case 'bake':
                return num*3;
            case 'fillet':
                return num * 0.8;
        }
    }
}

//cooking(['32', 'chop', 'chop', 'chop', 'chop', 'chop']);

/*
    08. Validity Checker  
*/

function checker(arr){
    let x1 = Number(arr[0]);
    let y1 = Number(arr[1]);
    let x2 = Number(arr[2]);
    let y2 = Number(arr[3]);
 
    function distance(x1, y1, x2, y2) {
        let distH = x1 - x2;
        let distY = y1 - y2;
        return Math.sqrt(distH**2 + distY**2);
    }
 
    if (Number.isInteger(distance(x1, y1, 0, 0))) {
        console.log(`{${x1}, ${y1}} to {0, 0} is valid`);
    } else {
        console.log(`{${x1}, ${y1}} to {0, 0} is invalid`);
    }
 
    if (Number.isInteger(distance(x2, y2, 0, 0))) {
        console.log(`{${x2}, ${y2}} to {0, 0} is valid`);
    } else {
        console.log(`{${x2}, ${y2}} to {0, 0} is invalid`);
    }
 
    if (Number.isInteger(distance(x1, y1, x2, y2))) {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`);
    } else {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`);
    }
}


/*
    9.	*Coffee Machine  
*/

function coffeMachine(array){
    let totalIncome = 0;
   
    

    function order(arr){
        let money = Number(arr[0]);
        let typeOfDrink = arr[1];
        let coffeeType = typeOfDrink === 'coffee' ? arr[2] : '';
        let sugar = Number(arr[arr.length-1]);
        let price = 0;
        switch(typeOfDrink){
            case 'coffee':
                price = coffeeType === 'decaf' ? 0.90 : 0.80;
                break;
            case 'tea':
                price += 0.80;
                break
        }

        if(arr[2] === 'milk' || arr[3] === 'milk') {
            price += Number((price*0.1).toFixed(1));
        }

        price += sugar === 0 ? 0 : 0.10;

        totalIncome += price<= money ? price : 0;

       return  money >= price 
            ? `You ordered ${typeOfDrink}. Price: $${price.toFixed(2)} Change: $${(money-price).toFixed(2)}`
            : `Not enough money for ${typeOfDrink}. Need $${(price-money).toFixed(2)} more.`;        
    }

    for(let ord of array){
        let orderArray = ord.split(', ');
        console.log(order(orderArray));
    }

    console.log(`Income Report: $${totalIncome.toFixed(2)}`);
}

coffeMachine(['1.00, coffee, caffeine, milk, 4', '0.40, tea, milk, 2', '1.00, coffee, decaf, 0']);









