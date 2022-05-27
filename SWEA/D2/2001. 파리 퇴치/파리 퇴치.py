T = int(input())

for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    # 0,0 ~ 0,3
    # 3,0 ~ 3,3
    result = 0
    grid = [list(map(int, input().split())) for _ in range(n)]


    for i in range(n-(m-1)) :
        for j in range(n-(m-1)) :
            tmp = 0
            for k in range(m) :
                for n in range(m) :
                    tmp += grid[i+k][j+n]
            result = max(result, tmp)
    print('#'+str(test_case), result)