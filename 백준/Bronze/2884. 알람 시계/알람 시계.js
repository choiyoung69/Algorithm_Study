const readline = require("readline");
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

let list = [];

rl.on("line", function(line){
    list = line.split(' ').map((e1) => Number(e1));
    let H = list[0];
    let M = list[1] + 15;
    
    if(parseInt(M/60) === 1){
        console.log(H + ' ' + (M%60));
    }
    else{
        if(H === 0) console.log(23 + ' ' + M);
        else console.log((H-1) + ' ' + M);
    }
});