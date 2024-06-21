const readline = require("readline");
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

let input = [];

rl.on("line", function(line){
    input = line.split(' ').map((e1) => Number(e1));
    console.log(input[0] + input[1] + input[2]);
});