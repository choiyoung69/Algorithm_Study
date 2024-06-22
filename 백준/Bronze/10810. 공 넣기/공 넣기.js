const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});
let input = [];
rl.on("line", function(line){
    input.push(line.split(" ").map((e1) => Number(e1)));
}).on("close", function(){
    let arr = Array.from({length : input[0][0]}, () => 0);
    let m = input[0][1];
    let start = 0;
    let end = 0;
    let k = 0;
    
    for(let i = 0; i < m; i++){
        start = input[i+1][0];
        end = input[i+1][1];
        k = input[i+1][2];
        
        for(let j = start - 1; j < end; j++){
            arr[j] = k
        }
    }
    console.log(arr.join(" "));
    
})