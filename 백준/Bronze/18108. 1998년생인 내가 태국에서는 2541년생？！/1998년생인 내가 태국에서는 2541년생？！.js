const readline = require("readline");
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

let input;

rl.on("line", function(line){
    input = Number(line);
    console.log(input - 543);
});