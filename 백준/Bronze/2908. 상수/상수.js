const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

rl.on("line", function(line){
    let arr = line.split(' ');
    
    function strReverse(str){
        return Number(str.split('').reverse().join(''))
    }
    
    console.log(Math.max(strReverse(arr[0]), strReverse(arr[1])))
})