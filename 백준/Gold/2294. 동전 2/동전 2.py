n, m = map(int, input().split())            #n화폐종류, m가치의합
money = [int(input()) for _ in range(n)]    #화폐 배열
money.sort()

# dp - 바텀업
# 해당 인덱스의 금액을 구성하기 위한 최소 화폐 개수를 담는 dp테이블
dp = [-1]*100001  #인덱스 1부터 시작

# money 원소는 그자체로 달성 가능 ==> dp테이블에 넣기
for mny in money:
    dp[mny] = 1

for i in range(1, m+1):
    for mny in money:
        if i-mny>=1 and dp[i-mny]!=-1:
            if dp[i] == -1:
                dp[i] = dp[i-mny]+1
            else:
                dp[i] = min(dp[i], dp[i-mny]+1)

print(dp[m])