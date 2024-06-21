const readline = require("readline");
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

let list = [];

rl.on("line", function(line){
    list = line.split(' ').map((e1)=>Number(e1));
    let a = list[0];
    let b = list[1];
    let c = list[2];
    
    if(a === b && a === c){
        console.log(10000 + a*1000);
    }
    else if(a === b || a === c){
        console.log(1000 + 100 * a);
    }
    else if(b === c){
        console.log(1000 + 100 * b);
    }
    else{
        let max = Math.max(a, b, c);
        console.log(max * 100);
    }
})