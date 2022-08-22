# 최소비용 신장트리(MST)
# 크루스칼 알고리즘

import sys
input = sys.stdin.readline

n, m = map(int, input().rstrip().split())
edges = []
############################################################
parents = [i for i in range(n+1)]   #인덱스 1부터 시작
def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])
    return parents[x]

def union(a, b):
    a = find(a)
    b = find(b)
    if a>b: parents[a] = b
    else : parents[b] = a
############################################################
for _ in range(m):
    a, b, c = map(int, input().rstrip().split())
    edges.append((a,b,c))
edges.sort(key = lambda x:x[2])

# 마을를 2개로 나눠 MST를 구하면됨
# => 전체 그래프에 대해 MST 구한뒤, 가장 비용이 큰 간선을 제거하면
#    2개의 최선의 MST 찾을 수 있다.
total = 0
for edge in edges:  #edge:(a,b,c)
    a, b, c = edge
    if find(a) != find(b):
        union(a,b)
        total+=c
        last = c
print(total-last)
############################################################