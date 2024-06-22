const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

rl.on("line", function(line){
    let n = Number(line);
    for(let i = 0; i < n; i++){
        let result = "";
        for(let j = 0; j < i+1; j++){
            result += "*";
        }
        console.log(result);
    }
})