"""
- 문제 : 전구와 스위치
- 링크 : https://www.acmicpc.net/problem/2138
- 아이디어 :
"""

n = int(input())
current = list(map(int, list(input())))
current2 = current.copy()
goal = list(map(int, list(input())))
# current와 goal 같으면 0, 다르면 1

# if n==2:
#     if current == [0,0]: print(0)
#     elif current == [1,1]: print(1)
#     else: print(-1)
#
# else:
# 1. 첫번째 스위치 안누른 경우
cnt = 0
for i in range(1, n):
    if current[i-1] != goal[i-1]:
        if i<n-1:
            cnt+=1
            current[i-1]^=1
            current[i]^=1
            current[i+1]^=1
        else:
            cnt+=1
            current[i-1]^=1
            current[i]^=1
if current != goal: cnt = -1

# 1. 첫번째 스위치 누른 경우
cnt2 = 1
current2[0]^=1
current2[1]^=1
for i in range(1, n):
    if current2[i-1] != goal[i-1]:
        if i<n-1:
            cnt2+=1
            current2[i-1]^=1
            current2[i]^=1
            current2[i+1]^=1
        else:
            cnt2+=1
            current2[i-1]^=1
            current2[i]^=1

if current2 != goal: cnt2 = -1

if cnt == -1 and cnt2 == -1: print(-1)
elif cnt == -1: print(cnt2)
elif cnt2 == -1 : print(cnt)
else:
    print(min(cnt, cnt2))