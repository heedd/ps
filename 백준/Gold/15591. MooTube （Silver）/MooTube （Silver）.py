"""
- 문제 : MooTube (Silver)
- 링크 : https://www.acmicpc.net/problem/15591
- 아이디어 :  BFS

좀 더 쉽게 말해서, 존은 N-1개의 동영상 쌍을 골라서 
어떤 동영상에서 다른 동영상으로 가는 "경로가 반드시 하나 존재"하도록 했다.
=> 싸이클없는, 무향 그래프!

N (1 ≤ N ≤ 5,000)
Q (1 ≤ Q ≤ 5,000)
"""
# bfs
from collections import deque
def bfs(v):
    visited = [False]*(N+1)
    q = deque()
    q.append([v,0])
    visited[v] = True
    while q:
        cur = q.popleft()
        #print(usado[v][1:])
        for ad in adjList[cur[0]]:
            if visited[ad[0]]: continue
            usado[v][ad[0]] = min(usado[v][cur[0]], ad[1])
            q.append((ad[0],usado[v][ad[0]]))
            visited[ad[0]] = True

# main 시작
import sys
input = sys.stdin.readline

N, Q = map(int, input().split())

INF = int(1e9)
adjList= [[] for _ in range(N + 1)]   # 인덱스 1부터 시작
usado = [[INF]*(N+1) for _ in range(N + 1)]    # 인덱스 1부터 시작

# 그래프 입력받기
for i in range(N - 1):
    p, q, r = map(int, input().split())
    adjList[p].append((q,r))
    adjList[q].append((p,r))


# bfs로 usado 채우기
for i in range(1, N+1):
    bfs(i)
    #print(usado[i][1:])

# 질문에 답하기
for q in range(Q):
    k, v = map(int, input().split())
    cnt = 0
    for usd in usado[v]:
        if k <= usd < INF: cnt+=1
    print(cnt)