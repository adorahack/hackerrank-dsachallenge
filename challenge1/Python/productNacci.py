import sys

sys.setrecursionlimit(10**7)

input_ = sys.stdin.readline

def read_line() -> str:
    return input_().strip()

def read_ints():
    return list(map(int, read_line().split()))

def get_n(n, p0, p1, X, memo = {}): 
    if n == 0: 
        return p0
    if n == 1: 
        return p1
    if n in memo: 
        return memo[n]
    memo[n] = (get_n(n - 1, p0, p1, X) * get_n(n - 2, p0, p1, X)) % X 
    return memo[n]

def solve():
    p0, p1, n, X = read_ints()
    print(get_n(n, p0, p1, X))

if __name__ == '__main__':
    solve()