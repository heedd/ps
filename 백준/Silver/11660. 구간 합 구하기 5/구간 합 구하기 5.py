##########################################
# 문제 : 구간합 구하기5
# 구간합/부분합 : https://yiyj1030.tistory.com/489
##########################################

import sys
input = sys.stdin.readline


n, m = map(int, input().split())
# sum[r+1][c+1] : (0,0)~(r,c)까지의 합
arr = [list(map(int, input().split())) for _ in range(n)]
sum = [[0]*(n+1) for _ in range(n+1)]
for r in range(1,n+1):
    for c in range(1,n+1):
        sum[r][c] = sum[r-1][c] + sum[r][c-1] - sum[r-1][c-1] + arr[r-1][c-1]

for _ in range(m):
    y1, x1, y2, x2 = map(int, input().split())
    ans = sum[y2][x2] - (sum[y1-1][x2] + sum[y2][x1-1] - sum[y1-1][x1-1])
    print(ans)