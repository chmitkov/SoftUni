function f(array) {

    for (let i = 0; i < array.length; i++) {
        let currObj = JSON.parse(array[i]);
        console.log(`Name: ${currObj.name}`)
        console.log(`Age: ${currObj.age}`)
        console.log(`Date: ${currObj.date}`)
    }

}

