from collections import deque

# 1. 입력
r, c = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(r)]

dy = (-1,  0,  1,  0)
dx = ( 0, -1,  0,  1)


# 2. 녹는 치즈개수 count - 가장자리는 연결되어 있음
def bfs():
    visited = [[False] * c for _ in range(r)]
    cnt = 0

    q = deque()
    q.append((0,0))
    visited[0][0] = True

    while q:
        y, x = q.popleft()
        for d in range(4):
            ny, nx = y+dy[d], x+dx[d]
            if ny<0 or nx<0 or ny>=r or nx>=c or visited[ny][nx] == True:
                continue
            if grid[ny][nx] == 0:
                visited[ny][nx] = True
                q.append((ny,nx))
            elif grid[ny][nx] == 1:
                visited[ny][nx] = True
                grid[ny][nx] = 0
                cnt += 1
    return cnt


# 3. 시각별 남은 치즈개수 count
history = []  # history[시각-1]=치즈개수
while(True):

    cnt = bfs()

    if cnt == 0:
        break
    else:
        history.append(cnt)


print(len(history))
print(history[-1])