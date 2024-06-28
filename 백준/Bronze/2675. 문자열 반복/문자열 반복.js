const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});
let input = [];
rl.on("line", function(line){
    input.push(line);
}).on("close", function(){
    let N = input[0];
    
    for(let i = 0; i < N; i++){
        let arr = input[i + 1].split(' ');
        let R = Number(arr[0]);
        let str = arr[1];
        
        let result = "";
        for(let j = 0; j < str.length; j++){
            for(let k = 0; k < R; k++){
                result += str[j];
            }
        }
        console.log(result);
    }
})