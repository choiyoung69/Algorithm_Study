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
    list = input.map((e1) => Number(e1));
    let x = list[0];
    let y = list[1];
    
    if(x > 0){
        if(y > 0) console.log(1);
        else console.log(4);
    }
    else{
        if(y > 0) console.log(2);
        else console.log(3);
    }
});