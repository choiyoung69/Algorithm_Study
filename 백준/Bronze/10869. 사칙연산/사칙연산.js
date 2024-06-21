const readline = require("readline");
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

let input;
let list = [];

rl.on("line", function(line){
    input = line;
    rl.close();
}).on("close", function(){
    list = input.split(' ').map((e1) => Number(e1));
    solution(list);
    process.exit();
});

function solution(list){
    let a = list[0];
    let b = list[1];
    console.log(a + b);
    console.log(a - b);
    console.log(a * b);
    let divi = parseInt(a / b)
    console.log(divi);
    console.log(a % b);
    
};