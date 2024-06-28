const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});
let input = [];
rl.on("line", function(line){
    input.push(line);
}).on("close", function(){
    const N = Number(input[0]);
    const arr = input[1]
    let sum = 0;
    for(let i = 0; i < N; i++){
        sum += Number(arr[i])
    }
    console.log(sum)
})