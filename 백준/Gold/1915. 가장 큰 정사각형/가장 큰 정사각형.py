N, M = map(int, input().split())
A = []
for i in range(N):
    s = input()
    A.append(list(map(int, list(s))))

# A 탐색하면서 채울 DP 테이블
dp = [[0] * (M+1) for _ in range(N+1)]
size = 0    # 최대 변의 길이

for i in range(1, N+1):
    for j in range(1, M+1):
        if A[i-1][j-1]:
            dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1
            size = max(size, dp[i][j])
print(size ** 2)