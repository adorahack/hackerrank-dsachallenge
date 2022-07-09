n, S = map(int, input().split())

l = [0] * (n)
r = [0] * (n)

for i in range(0, n): 
    l[i], r[i] = map(int, input().split())
    
def solve(idx, total): 
    if idx == n: 
        if total == S: 
            return 1
        else:
            return 0
    res = 0
    for val in range(l[idx], r[idx] + 1): 
        res += solve(idx + 1, total + val)
    return res

print(solve(0, 0))