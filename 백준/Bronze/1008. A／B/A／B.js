const readline = require("readline");
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

let list = [];
let input;

rl.on("line", function(line){
    input = line;
    rl.close();
}).on("close", function(){
    list = input.split(' ').map((e1) => Number(e1));
    solution(list);
    process.exit();
});

function solution(list){
   let answer = list[0] / list[1];
   console.log(answer);
};