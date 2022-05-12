# 슬라이딩 윈도우
g, s = map(int, input().split())
W = input()
S = input()

answer = 0
wa = [0] * 58
sa = [0] * 58

# W의 알파벳 등장횟수
for x in W:
    wa[ord(x) - 65] += 1

# 윈도우 시작점, 크기
start, length = 0, 0
for i in range(s):
    sa[ord(S[i]) - 65] += 1
    length += 1

    if length == g: # W길이만큼 다 비교했을떄
        if wa == sa:
            answer += 1
        sa[ord(S[start]) - 65] -= 1 # sa 다시 백지로
        start += 1  # 윈도우 다음 칸으로 이동
        length -= 1

print(answer)