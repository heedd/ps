#가로n 세로2
n = int(input())

# DP - 바텀업
# 2x인덱스 크기의 바닥을 채우기 위한 모든 경우의 수가 담길 dp테이블
dp = [0]*1001  #인덱스 1부터 시작.

dp[1] = 1
dp[2] = 3
for i in range(3, n+1):
    dp[i] = (dp[i-1] + dp[i-2]*2)%10007  #dp[3]부터는 dp[1], dp[2]로 커버가능하니까 dp[1], dp[2] case만으로 점화식 세워보자

print(dp[n])