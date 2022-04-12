n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

max_size, count = 0, 0

from collections import deque

def bfs(x, y) :
  q = deque()
  board[x][y] = 0  
  q.append((x,y))
  count = 1
  
  while q :
    x, y = q.popleft()
    for dx, dy in (1,0), (-1,0), (0,1), (0,-1) :
      nx, ny = x + dx, y + dy
      if(0 <= nx < n) and (0 <= ny <m) and board[nx][ny] == 1:
        board[nx][ny] = 0
        q.append((nx, ny))
        count += 1
  return count

for x in range(n):
    for y in range(m):
        if board[x][y]:
            max_size = max(max_size, bfs(x, y))
            count += 1

print(count)
print(max_size)
