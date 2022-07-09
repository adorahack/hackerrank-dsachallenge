def dfs(x, y):
    global n, m, grid, found

    if x >= n or y >= m:
        return
    if grid[x][y] == '#':
        return
    if grid[x][y] == 'B':
        found = True
        return
    dfs(x + 1, y)
    dfs(x, y + 1)


def main():
    global n, m, grid, found
    found = False
    (n, m) = map(int, input().split())
    grid = []
    for i in range(n):
        s = input()
        grid.append(s)
    (x, y) = (-1, -1)
    for i in range(0, n):
        for j in range(0, m):
            if grid[i][j] == 'A':
                (x, y) = (i, j)
    dfs(x, y)
    if found == True:
        print ('YES')
    else:
        print ('NO')

if __name__ == '__main__':
    main()
