const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});
let input = [];
rl.on("line", function(line){
    input.push(line.split(' ').map((e1) => Number(e1)));
}).on("close", function(){
    let i = 0;
    let result = "";
    while(true){
        if(input[i][0] === 0 && input[i][1] === 0) break;
        result += (input[i][0] + input[i][1]) + '\n';
        i++;
    }
    console.log(result);
})