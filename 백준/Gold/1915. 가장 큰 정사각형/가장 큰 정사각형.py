"""
- 문제 : 가장 큰 정사각형
- 링크 : https://www.acmicpc.net/problem/1915
- 아이디어 : DP
- 시간복잡도 : 1000*1000 n^2이지 않을까
"""
# import sys
# input = sys.stdin.readline

n, m = map(int, input().split())
# 인덱스 1부터 진짜
grid = []
for i in range(n):
    line = input()
    grid.append(list(map(int, list(line))))

    """
    시작점: 좌상, 끝점: 우하
    "좌|좌상|상" 값을 비교하자
    dp[er][ec] = sz : (er,ec)인 가장 큰 정사각형의 크기
    """
# 인덱스 1부터 진짜
mxLength = 0
dp = [[0]*(m+1) for _ in range(n+1)]
for r in range(1, n+1):
    for c in range(1, m+1):
        if grid[r-1][c-1] == 1:
            dp[r][c] = min(dp[r][c-1], dp[r-1][c-1], dp[r-1][c])+1
            mxLength = max(mxLength, dp[r][c])

print(mxLength*mxLength)