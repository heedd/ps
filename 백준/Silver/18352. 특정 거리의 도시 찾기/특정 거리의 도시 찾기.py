import heapq
import sys

input = sys.stdin.readline

# 0. 입력
n, m, k, x = map(int, input().split())
INF = int(1e9)
distance = [INF] * (n + 1)  # 최단거리 테이블
graph = [[] * (n + 1) for _ in range(n + 1)]

for _ in range(m):
    s, e = map(int, input().split())
    graph[s].append((e, 1))  # (정점, 최단거리)

# 1. 다익스트라
# c와 연결된 정점들까지의 최단거리 문제로 치환가능
# 한점에서 다른 정점들까지의 최단거리가 필요하므로 => 다익스트라
hq = []
heapq.heappush(hq, (x, 0))  # (정점, 최단거리)
distance[x] = 0

while hq:
    cur, dist = heapq.heappop(hq)
    if distance[cur] < dist: continue

    for ad in graph[cur]:
        cost = dist + ad[1]
        if cost < distance[ad[0]]:
            distance[ad[0]] = cost
            heapq.heappush(hq, (ad[0], cost))

# 3. 출력
cnt = 0
for i in range(1, n + 1):
    if distance[i] == k:
        print(i)
        cnt += 1

if cnt == 0:
    print(-1)