################################################################
# 문제 : 편집 거리
# 아이디어 : DP
# 참고 : 알고리즘 :: 이것이 코딩 테스트다 :: DP :: Q36 :: 편집 거리
#################################################################

A = list(input())
B = list(input())
length_A = len(A)
length_B = len(B)
min_cnt = int(1e9)

# row[i][0]:A, col[0][i]:B
# row의 ch에서 col의 ch가 되기 위한 편집거리를 담을 dp테이블
dp = [[0] * (length_B + 1) for _ in range(length_A + 1)]
for i in range(length_B+1):
    dp[0][i] = i
for i in range(length_A+1):
    dp[i][0] = i
for a in range(1, length_A+1):
    for b in range(1, length_B+1):
        # 두 문자가 같은 경우, 추가 연산 필요 없음
        if A[a-1] == B[b-1]: dp[a][b] = dp[a - 1][b - 1]
        # 두 문자가 다른 경우, (교체,추가,삭제) 중 cost가 가장 적은 것을 dist에 기록
        else: dp[a][b] = min(dp[a - 1][b - 1], dp[a - 1][b], dp[a][b - 1]) + 1


print(dp[length_A][length_B])