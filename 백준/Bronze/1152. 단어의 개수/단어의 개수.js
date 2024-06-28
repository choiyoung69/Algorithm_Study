const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

rl.on("line", function(line){
    let arr = [];
    arr = line.trim().split(" ");
    if(arr[0] === ''){
        console.log(0);
        process.exit(0)
    }
    console.log(arr.length);
})