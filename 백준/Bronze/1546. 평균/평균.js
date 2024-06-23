const readline = require("readline")
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
})

let input = [];

rl.on("line", function(line){
    input.push(line.split(" ").map(Number))
}).on("close", function(){
    let number = input[0][0]
    let list = input[1]
    let sum = 0;
    
    list.forEach(element => {
        sum += element
    })
    console.log((100*sum)/(Math.max(...list)*number))
})