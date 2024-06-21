const readline = require("readline");
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

let input;
let list = [];

rl.on("line", function(line){
    input = line;
    list = input.split(' ').map((e1) => Number(e1));
    let a = list[0];
    let b = list[1];
    let c = list[2];
    
    console.log((a + b)%c)
    console.log(((a%c)+(b%c))%c)
    console.log((a * b)%c)
    console.log(((a%c)*(b%c))%c)   
})