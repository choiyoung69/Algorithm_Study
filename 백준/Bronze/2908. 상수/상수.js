const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

rl.on("line", function(line){
    let arr = line.trim().split(' ')
    let num1 = "";
    let num2 = "";
    for(let i = 0; i < arr[0].length; i++){
        num1 += arr[0][arr[0].length - 1 - i];
    }
    for(let i = 0; i < arr[1].length; i++){
        num2 += arr[1][arr[1].length - 1 - i];
    }
    num1 = Number(num1);
    num2 = Number(num2);
    console.log(Math.max(num1, num2));
})