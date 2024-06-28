const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});
let input = [];
rl.on("line", function(line){
    input.push(line);
}).on("close", function(){
    let size = Number(input[0]);
    
    for(let i = 0; i < size; i++){
        let str = input[i+1];
        console.log(str[0] + str[str.length - 1]);
    }
})