import sys
input = sys.stdin.readline
n, m = map(int, input().split())
bridges = []
for i in range(m):
    a, b, c = map(int, input().split())
    bridges.append((a, b, c))
src, dst = map(int, input().split())
maxWeight = 0

# union find
parents = [i for i in range(n+1)]
def find(a):
    if parents[a] == a: return a
    parents[a] = find(parents[a])
    return parents[a]

def union(a,b):
    pa,pb = find(a), find(b)
    if pa != pb: parents[pa] = pb

# 크루스칼 활용 - 부분트리 확장해나가면서 src, dst가 둘다 포함된다면 stop
# 중량제한이 큰 bridge부터 포함
bridges.sort(key=lambda x: -x[2])
for bridge in bridges:
    a, b, c = bridge[0], bridge[1], bridge[2]
    union(a,b)
    if find(src) == find(dst):
        print(c)
        break