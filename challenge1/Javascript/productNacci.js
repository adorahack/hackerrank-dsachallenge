function processData(input) {
    //Enter your code here
    const args = input.split(" ");
    let p0 = BigInt(args[0]);
    let p1 = BigInt(args[1]);
    let n = parseInt(args[2]);
    let x = BigInt(args[3]);

    if (n === 0){
        console.log(p0.toString());
        return;
    }

    if (n === 1){
        console.log(p1.toString());
        return;
    }

    let result = productNacci(p0, p1, 2, n, x).toString();
    console.log(result)
}

function productNacci(prevPrev, prev, currN, n, x){
    if (currN <= n){
        let currValue = (prevPrev * prev)%x;
        return productNacci(prev, currValue, currN+1, n, x);
    } else {
        return prev;
    }
}

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
    processData(_input);
});