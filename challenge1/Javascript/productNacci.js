function processData(input) {
    // input is a single containing arguments seperated by spaces
    // lines 3 - 8 splits input into tokens and then converts each token into its integer and BigInt equivalent respectively.
    const args = input.split(" ");
    let p0 = BigInt(args[0]);
    let p1 = BigInt(args[1]);
    let n = parseInt(args[2]);
    let x = BigInt(args[3]);

    //base case 1
    if (n === 0){
        console.log(p0.toString());
        return;
    }

    //base case 2
    if (n === 1){
        console.log(p1.toString());
        return;
    }

    let result = productNacci(p0, p1, 2, n, x).toString();
    console.log(result)
}
/*
*
* prev is same as p1
* prevPrev is same as p0
*
* */
function productNacci(prevPrev, prev, currN, n, x){
    /* for each recursive call:
    *   we increment the current value of n
    *   prev becomes prevPrev in the next recursive call.
    */
    if (currN <= n){
        let currValue = (prevPrev * prev) % x;
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