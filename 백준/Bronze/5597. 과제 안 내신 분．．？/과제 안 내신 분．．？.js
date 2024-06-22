const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});
let input = [];
rl.on("line", function(line){
    input.push(Number(line));
}).on("close", function(){
    let N = [];
    for(let i = 1; i < 31; i++){
        if(input.includes(i)) continue;
        N.push(i);
    }
    N.sort((a, b) => a - b);
    console.log(N.join(' '))
})