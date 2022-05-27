T = int(input())

for test_case in range(1, T + 1):
    answer = 0
    s = ''
    n = int(input())
    grid = [input() for _ in range(n)]

    # 윗 부분
    x = int(n//2)
    c = 0
    for y in range(int(n//2)+1) :
        s += grid[y][x-c:x+c+1]
        c+=1


    # 아랫 부분
    c = 0
    for y in range(n-1, int(n//2), -1) :
        s += grid[y][x - c:x + c + 1]
        c+=1

    for i in s:
        answer += int(i)

    print('#'+str(test_case), answer)