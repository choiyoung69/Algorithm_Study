const readline = require("readline")
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
})

let input = [];

rl.on("line", function(line){
    input.push(line.split(' ').map(Number))
}).on("close", function(){
    let N = input[0][0];
    let M = input[0][1];
    
    let list = [];
    
    for(let i = 1; i <= N; i++){
        list.push(i)
    }
    
    for(let i = 0; i < M; i++){
        const [a, b] = input[i + 1];
        
        for(let j = 0; j < (b - a + 1)/2; j++){
            let tmp = list[a + j - 1];
            list[a + j -1] = list[b - j-1];
            list[b - j -1] = tmp;
         }
    }
    
    console.log(list.join(' '))
})