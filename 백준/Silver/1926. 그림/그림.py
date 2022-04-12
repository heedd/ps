import sys
input = sys.stdin.readline
H, W = map(int, input().split())

# board 입력받기
graph = []
for _ in range(H) :
    graph.append(list(map(int,input().split())))

# BFS 함수
from collections import deque
d = [[0,1], [0, -1], [1, 0], [-1,0]]
def bfs(y, x, size) :
    q = deque()
    graph[y][x] = 0
    q.append([y,x])
    while q:
        y, x = q.popleft()
        for dy,dx in d :
            ny = y + dy
            nx = x + dx
            if 0 <= ny < H and 0<=nx<W and graph[ny][nx] == 1 :
                size += 1
                graph[ny][nx] = 0
                q.append([ny,nx])
    return size

result = []
pictures = 0
mx_size = 0
for i in range(H) :
    for k in range(W) :
        if graph[i][k] == 1 :
            mx_size = max(mx_size, bfs(i, k, 1))
            pictures += 1



print(pictures)
print(mx_size)