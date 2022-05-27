T = int(input())

#     0  1  2  3
dy = (0, 1, 0, -1)
dx = (1, 0, -1, 0)

for test_case in range(1, T + 1):
    n = int(input())
    board = [[0]*n for _ in range(n)]

    for i in range(n) :
        board[0][i] = i+1

    way = []
    s = 0
    for i in range(n-1, 0, -1) :
        for _ in range(2) :
            s = (s+1) % 4
            for _ in range(i) :
                way.append(s)

    y, x = 0, n-1
    val = n
    for i in way :
        y, x = y + dy[i], x + dx[i]
        val += 1
        board[y][x] = val


    print('#'+str(test_case))
    for i in range(n) :
        for j in range(n) :
            print(board[i][j], end=' ')
            if j == n-1 :
                print()