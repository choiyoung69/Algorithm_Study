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
    let X = input[0][1];
    let list = input[1];
    let result = "";
    
    for(let i = 0; i < N; i++){
        if(list[i] < X) result += list[i] + ' ';
    }
    console.log(result);
})