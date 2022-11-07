"""
- 문제 : 뱀과 사다리 게임
- 링크 : https://www.acmicpc.net/problem/16928
- 아이디어 : 그리디?? DP?? 완탐??
"""


n, m = map(int, input().split())
ways = [0]*101 #인덱스 1부터 시작
for _ in range(n):  #사다리: 올라가기
    x,y = map(int, input().split())
    ways[x] = y
for _ in range(m):  #뱀: 내려가기
    u,v = map(int, input().split())
    ways[u] = v

from collections import deque

visited = [False]*101

def bfs():
    cnt = 0
    q = deque([1])
    visited[1] = True

    while q:
        # print(q)
        sz = len(q)
        for _ in range(sz):
            cur = q.popleft()
            if cur == 100:
                return cnt
            for i in range(1,7):
                next = cur+i
                if next>100 or visited[next]: continue
                if ways[next]!=0: next=ways[next]
                q.append(next)
                visited[next] = True
        cnt+=1


print(bfs())