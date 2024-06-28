const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

let chess = [1,1,2,2,2,8]
rl.on("line", function(line){
    let result = new Array(7);
    const arr = line.trim().split(' ').map(Number);
    
    for(let i = 0; i < chess.length; i++){
        result[i] = chess[i] - arr[i];
    }
    console.log(result.join(' '));
})