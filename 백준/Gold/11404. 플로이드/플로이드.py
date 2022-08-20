import sys
input = sys.stdin.readline

# 입력
n = int(input())
m = int(input())
INF = int(1e9)
grid = [[INF]*(n+1) for _ in range(n+1)]

# 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
for a in range(1, n + 1):
    for b in range(1, n + 1):
        if a == b:
            grid[a][b] = 0

# 테이블 초기화
for _ in range(m):
    a, b, c = map(int, input().split())
    grid[a][b] = min(grid[a][b], c)   # 문제의 특이조건: 노선이 하나가 아닐 수 있다 == 어쩄든 적은 비용 노선만 갈테니까 min으로 갱신

# 플로이드 와샬
for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            grid[a][b] = min(grid[a][b], grid[a][k]+grid[k][b])

#출력
for a in range(1, n+1):
    for b in range(1, n+1):
        if grid[a][b] == INF:
            print(0, end=' ')
        else:
            print(grid[a][b], end=' ')
    print()