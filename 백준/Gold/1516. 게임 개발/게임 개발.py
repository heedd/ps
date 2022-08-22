# 위상정렬
# 건물을 짓기 위해 먼저 지어져야하는 건물들 ==> 선수과목? 위상정렬!

import sys
input = sys.stdin.readline
#########################################################################
n = int(input())
graph = [[] for _ in range(n+1)]    # graph[건물번호]=(짓는시간, 선수건물)
inDegree = [0]*(n+1) #인덱스 1부터 시작
time = [0]*(n+1)

for i in range(1, n+1):
    tmp = list(map(int, input().split()))
    time[i] += tmp[0]
    for x in tmp[1:-1]:
        inDegree[i] += 1
        graph[x].append(i)
##########################################################################
from collections import deque
import copy
q = deque()
result = copy.deepcopy(time)

# 진입차수가 0인 노드들 큐에 삽입
for i in range(1, n+1):
    if inDegree[i] == 0:
        q.append(i)

while q:
    cur = q.popleft()
    for i in graph[cur]:
        result[i] = max(result[i], result[cur]+time[i])
        inDegree[i] -= 1
        if inDegree[i] == 0:
            q.append(i)

for i in range(1, len(result)):
    print(result[i])
#print("\n".join(list(map(str, time))))