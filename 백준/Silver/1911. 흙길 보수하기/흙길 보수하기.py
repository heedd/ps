"""
- 문제 : 흙길 보수하기
- 링크 : https://www.acmicpc.net/problem/1911
- 아이디어 : 정렬+그리디?
"""

"""
1 <= N <= 10,000
"""
import sys
input = sys.stdin.readline

N, L = map(int, input().split())

waters = [0]*N
for i in range(N):
    # 시작, 끝
    s, e = map(int, input().split())
    waters[i] = (s,e)
waters.sort(key = lambda x: x)  # NlogN


cnt = 0
prevBridgeEnd, nextWaterStart, nextWaterEnd = -1, 0, 0
for i in range(len(waters)):
    # 1. prev와 next 웅덩이가 멀리 떨어진 경우
    #>> 8
    nextWaterStart = waters[i][0]
    # 2. prev와 next 두 웅덩이가 널빤지 공유가능
    if prevBridgeEnd > nextWaterStart:
        nextWaterStart = prevBridgeEnd
    nextWaterEnd = waters[i][1]

    if ((nextWaterEnd - nextWaterStart)<=0) : continue

    tmpCnt = (nextWaterEnd - nextWaterStart)//L
    r = (nextWaterEnd - nextWaterStart)%L
    # 1. 널빤지가 웅덩이에 딱맞게 덮어지는 경우
    if r == 0:
        cnt += tmpCnt
        prevBridgeEnd = nextWaterEnd
    # 2. 널빤지가 웅덩이 너머로 더 길게 덮어지는 경우
    else:
        cnt += tmpCnt+1
        prevBridgeEnd = nextWaterEnd - r + L
    # print(waters[i],  cnt)

print(cnt)