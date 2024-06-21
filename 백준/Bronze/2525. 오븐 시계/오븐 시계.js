const readline = require("readline");
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

let input = [];
let list = [];

rl.on("line", function(line){
    input.push(line);
}).on("close", function(){
    list = input[0].split(' ').map((e1) => Number(e1));  
    let plusMinute = Number(input[1]);
    let H = list[0];
    let M = list[1] + plusMinute;
    
    H = (H + parseInt(M/60))%24;
    M = M%60;
    
    console.log(H + ' '+ M);
});