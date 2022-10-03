n, k = map(int, input().split())

# dp[n][k] : 0~n까지의 정수 k개를 더해서 합이 n이 되는 경우의 수
# 0~n, 1~k
dp = [[1]*(k+1) for _ in range(n+1)]

for nn in range(n+1):
    dp[nn][1] = 1

for kk in range(2, k+1):
    # kk=2일때
    for nn in range(1, n+1):
        # nn=1일떄
        for i in range(1,nn+1):
            dp[nn][kk] += dp[i][kk-1]

# for i in range(n+1):
#     for j in range(1,k+1):
#         print(dp[i][j],end=' ')
#     print()

print(dp[n][k]%1000000000)