const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});
let input = [];

rl.on("line", function(line){
    input.push(line.split(' ').map((e1) => Number(e1)));
}).on("close", function(){
    let N = input[0][0];
    let result = "";
    for(let i = 1; i < N + 1; i++){
        result += (input[i][0] + input[i][1]) + '\n';
    }
    console.log(result);
})