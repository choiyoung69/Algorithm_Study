const readline = require('readline');
const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout,
});

rl.on("line", function(line){
    const alpha = {
        ABC : 3,
        DEF : 4,
        GHI : 5,
        JKL : 6,
        MNO : 7,
        PQRS : 8, 
        TUV : 9,
        WXYZ : 10
    }
    let sum = 0;
    for(let i = 0; i < line.length; i++){
        for(key in alpha){
            if(key.includes(line[i])) sum += alpha[key];
        }
    }
    console.log(sum);
})