def solve(index):
    global n, ans, x
    
    if index == n:
        sum_or = 0
        for num in lis:
            sum_or = sum_or | num
        if sum_or == x:
            ans = ans + 1 
        return
    
    solve(index + 1)
    lis.append(arr[index])
    solve(index + 1)
    lis.pop()
             
def main():
    global n, x, arr, ans, lis
    lis = [] # a list 
    ans = 0
    n, x = map(int,input().split())
    arr = list(map(int,input().split()))
   
    solve(0)
    print(ans)
    
if __name__ == "__main__":
    main()