const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

rl.on("line", function(line){
    const N = Number(line);
    const K = parseInt((2*N-1)/2);
    
    let result = "";
    for(let i = 0; i < N; i++){
        for(let j = 0; j < K-i; j++){
            result += ' ';
        }
        for(let j = 0; j < 2*i+1; j++){
            result += '*';
        }
        result += '\n';
    }
    for(let i = N - 2; i >= 0; i--){
        for(let j = 0; j < K - i; j++){
            result += ' ';
        }
        for(let j = 0; j < 2*i + 1; j++){
            result += '*';
        }
        if(i === 0) break;
        result += '\n';
    }
    process.stdout.write(result)
})