"""
- 문제 : 문자열 폭발
- 링크 : https://www.acmicpc.net/problem/9935
- 아이디어 : 스택
"""

str = input()
bomb = input()

"""
str  : 1 ~ 1_000_000
bomb : 1 ~ 36
"""

from collections import deque
st = deque()

l = 0
s = 0  # 폭탄 의심 시작부
idx = 0
prev = len(st)
while True:
    # 종료조건
    if idx == len(str): break

    next = str[idx]
    idx+=1

    # 폭탄 의심가면 l로 추적
    if next == bomb[l]: l+=1
    elif next == bomb[0]: l=1
    else : l=0
    st.append((next, l))

    # 폭탄 길이만큼 쌓였으면 제거
    # 제거 후 st에서 한번 더 확인
    if l == len(bomb) :
        for i in range(l):
            st.pop()
        # 기존 스택에서 bomb 의심목록 갱신해주기
        if st: l=st[-1][1]
        else: l = 0



if len(st) == 0: print("FRULA")
else:
    for i in range(len(st)):
        print(st.popleft()[0], end='')