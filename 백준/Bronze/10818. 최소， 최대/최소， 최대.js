const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

let input = [];

rl.on("line", function(line){
    input.push(line.split(' ').map((e1)=>Number(e1)));
}).on("close", function(){
    let N = input[0][0];
    let list = input[1];
    let min = list[0];
    let max = list[0];
    
    for(let i = 0; i < N; i++){
        if(min > list[i]) min = list[i];
        if(max < list[i]) max = list[i];
    }
    console.log(min + " " + max);
})