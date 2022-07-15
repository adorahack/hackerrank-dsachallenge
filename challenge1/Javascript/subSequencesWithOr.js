function processData(input) {
    let args = input.split("\n");
    let iterator = args[Symbol.iterator]();
    let current = iterator.next();
    let n = parseInt(current.value.split(" ")[0]);
    let x = parseInt(current.value.split(" ")[1]);
    let array = []



    while (!current.done){
        current = iterator.next();
        let value = current.value;
        if (value && value !== ""){
            value.split(" ").forEach(number=> array.push(parseInt(number)));
        }
    }

    let result = countSubSequenceOr(0, 0, array, n, x);
    console.log(result);
}

function countSubSequenceOr(currentIndex, accumOr, array, length, target){
    /*
    * base case */
    if (currentIndex === length){
        if (accumOr === target){
            return 1;
        }
        return 0;
    }
    /*
    *    for each call of the recursive loop, it's either the element at the current index
    *   sums up to the target_Or or it does not
    */
    let picked = countSubSequenceOr(currentIndex + 1, accumOr | array[currentIndex], array, length, target);
    let notPicked = countSubSequenceOr(currentIndex + 1, accumOr, array, length, target);

    return picked + notPicked;
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
