function  f (array) {
    let result = [];
    for (let i = 0; i < array.length; i++) {
        let currentRow = array[i].split(" -> ");
        let currName = currentRow[0];
        let currAge = Number(currentRow[1]);
        let currGrade = currentRow[2];
        let currStudent = {
            name:currName,
            age:currAge,
            grade: currGrade
        };
        result.push(currStudent);
    }
    for (let stu of result){
        console.log(`Name: ${stu.name}\nAge: ${stu.age}\nGrade: ${stu.grade}`);
    }
}
f([
    "Pesho -> 13 -> 6.00",
    "Ivan -> 12 -> 5.57",
    "Toni -> 13 -> 4.90"
])