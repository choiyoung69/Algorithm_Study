const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

let input = [];

rl.on("line", function(line){
    input.push(line.split(" ").map((e1) => Number(e1)));
}).on("close", function(){
    let X = input[0][0];
    let N = input[1][0];
    let sum = 0;
    for(let i = 2; i < N + 2; i++){
        sum += (input[i][0]*input[i][1]);
    }
    if(sum === X) console.log("Yes");
    else console.log("No");
})