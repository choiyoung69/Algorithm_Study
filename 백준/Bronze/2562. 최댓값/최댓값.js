const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});
let input = [];

rl.on("line", function(line){
    input.push(Number(line));
}).on("close", function(){
    let max = Math.max(...input);
    let order = input.indexOf(max) +1;
    console.log(max);
    console.log(order);
})