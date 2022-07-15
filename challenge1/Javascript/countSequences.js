function processData(input) {
    let args = input.split("\n");
    let iterator = args[Symbol.iterator]();
    let numRange = []

    let current = iterator.next();
    let target = parseInt(current.value.split(" ")[1]);

    while (!current.done){
        current = iterator.next();
        let value = current.value;
        if (value){
            let array = [];
            value.split(" ").forEach(number=> array.push(parseInt(number)));
            numRange.push(array);
        }
    }
    let result = countSequences(0, 0, target, numRange);
    console.log(result);
}

function countSequences(index, currSum, target, numRange){
    if (index >= numRange.length){
        if (currSum === target){
            return 1;
        }
        return 0;
    }

    let l = numRange[index][0];
    let r = numRange[index][1];
    let count = 0;

    for(let i = l; i <= r; i++){
        count += countSequences(index+1, currSum+i, target, numRange);
    }
    return count;
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