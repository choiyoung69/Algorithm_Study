const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

rl.on("line", function(line){
    let N = Number(line);
    for(let i = 1; i < 10; i++){
        console.log(N+ " * " + i + ' = ' + N*i);
    }
})