n, m = map(int, input().split())
y, x, d = map(int, input().split())

board = [ list(map(int, input().split())) for _ in range(n) ]
clean = [[0]*m for _ in range(n)]
cnt = 0 
#     0321 북서남동 ↑ ← ↓ →
dy = (-1,0,1,0)
dx = (0,1,0,-1)

clean[y][x] = 1
cnt += 1

while 1 :
    flag = 0
    for _ in range(4):
        d = (d+3)%4
        ny = y + dy[d]
        nx = x + dx[d]

        if board[ny][nx] == 0 and clean[ny][nx] == 0 :
            y,x = ny, nx
            clean[ny][nx] = 1
            cnt += 1
            flag = 1
            break
    if flag == 0 :
        if board[y - dy[d]][x - dx[d]] == 1 :
            break
        else :
            y, x = y - dy[d], x - dx[d]

print(cnt)