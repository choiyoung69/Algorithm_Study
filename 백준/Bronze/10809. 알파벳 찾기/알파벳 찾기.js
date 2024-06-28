const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

rl.on("line", function(line){
    for(let i = 97; i <= 122; i++){
        let ch = String.fromCharCode(i);
        process.stdout.write(line.indexOf(ch) + ' ');
    }
})