const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

rl.on("line", function(line){
    let N = Number(line);
    let sum = 0;
    for(let i = 1; i < N + 1; i++){
        sum += i;
    }
    console.log(sum);
})