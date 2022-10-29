dp=[0]*10001 #인덱스 1부터 시작
dp[1] = 1
dp[2] = 2
dp[3] = 3
for num in range(4, 10001):
    if num%3 == 0:
        dp[num] = dp[num-1] + dp[num-2] - dp[num-3]+1
    else:
        dp[num] = dp[num-1] + dp[num-2] - dp[num-3]

t = int(input())
for _ in range(t):
    print(dp[int(input())])