"""
- 문제 : 1학년
- 링크 : https://www.acmicpc.net/problem/5557
- 아이디어 : DP........
"""

"""
N         : 3 ~ 100
tmpResult : 0 ~ 20
num       : 0 ~ 9
result    : 0 ~ 9
"""

"""
dp[idx][prevResult] = k
nubmers의 idx번째 수까지 고려했을 때 prevResult에 도달하는 경우의 수
"""

n = int(input())
*numbers, result = list(map(int, input().split()))

dp = [[0]*21 for _ in range(len(numbers))]
dp[0][numbers[0]] = 1
for idx in range(1, len(numbers)): # idx       : 0 ~ n-1
    for prevResult in range(21): # tmpResult : 0 ~ 20
        # prevResult +- numbers[idx] 값이 0~20사이라면 => dp테이블에 계산값 저장
        if 0 <= prevResult + numbers[idx] <= 20:
            dp[idx][prevResult + numbers[idx]] += dp[idx-1][prevResult]
        if 0 <= prevResult - numbers[idx] <= 20:
            dp[idx][prevResult - numbers[idx]] += dp[idx-1][prevResult]

print(dp[-1][result])