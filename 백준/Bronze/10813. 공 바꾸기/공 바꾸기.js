const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});
let input = [];
rl.on("line", function(line){
    input.push(line.split(' ').map(Number));
}).on("close", function(){
    let N = input[0][0];
    let M = input[0][1];
    let arr = Array(N).fill(0);
    
    for(let i = 1; i <= N; i++){
        arr[i - 1] = i;
    }
    
    for(let i = 0; i< M; i++){
        const [l, m] = input[i + 1];
        let tmp = arr[l-1];
        arr[l-1] = arr[m - 1];
        arr[m-1] = tmp;
    }
    
    console.log(arr.join(" "));
})