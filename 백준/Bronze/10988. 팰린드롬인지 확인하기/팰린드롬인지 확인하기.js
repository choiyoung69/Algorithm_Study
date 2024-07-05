const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

rl.on("line", function(line){
    var isPalendrom = true;
    for(let i = 0; i < Math.floor(line.length/2); i++){
        if(line[i] !== line[line.length - i - 1]){
            isPalendrom = false;
            break;
        }
    }
    if(isPalendrom) console.log("1");
    else console.log("0");
})