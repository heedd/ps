"""
- 문제 : 서강 그라운드
- 링크 : https://www.acmicpc.net/problem/14938
- 아이디어 : FW
"""

n, m, r = map(int, input().split())
region = list(map(int, input().split()))

INF = int(1e9)
mat = [[INF]*(n+1) for _ in range(n+1)]  #인덱스 1부터 시작


for _ in range(r):
    a, b, l = map(int, input().split())
    mat[a][b] = l
    mat[b][a] = l

for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            if a==b:
                mat[a][b] = 0
                continue
            mat[a][b] = min(mat[a][b], mat[a][k]+mat[k][b])

# for i in range(1,n+1):
#     print(mat[i][1:])

maxItem = 0
for start in range(1, n+1):
    tmpItem = 0
    for reg in range(1, n+1):
        if mat[start][reg] <= m: tmpItem += region[reg-1]
    maxItem = max(maxItem, tmpItem)

print(maxItem)