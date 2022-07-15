function processData(input) {
    let args = input.split("\n");
    let iterator = args[Symbol.iterator]();
    let grid = []

    let current = iterator.next();
    let rowNum = parseInt(current.value.split(" ")[0]);
    let columnNum = parseInt(current.value.split(" ")[1]);

    while (!current.done){
        current = iterator.next();
        let value = current.value;
        if (value){
            grid.push(value.split(""));
        }
    }
    let alicePos = findAlicePos(grid);
    console.log(findBob(alicePos[0], alicePos[1], grid) ? "YES" : "NO")
}
function findAlicePos(grid){
    for(let i = 0; i < grid.length; i++){
        for (let j = 0; j < grid[i].length; j++) {
            if ("A" === grid[i][j]){
                return [i, j];
            }
        }
    }
}
function findBob(r, c, grid){
    if (r < 0 || r >= grid.length){
        return false;
    }

    if (c < 0 || c >= grid[r].length){
        return false;
    }

    if ("#" === grid[r][c]){
        return false;
    }

    if ("B" === grid[r][c]){
        return true;
    }

    return (findBob(r, c+1, grid) || findBob(r+1, c, grid));
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
