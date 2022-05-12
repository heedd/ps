import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)
n, m = map(int, input().split())

# union : 두 집합을 하나의 집합으로 합치는 연산 (== 루트노드를 하나로 합친다)
def union(x, y) :
    x = find(x) #x와 y의 루트노드를 찾아준다.
    y = find(y)
    if x == y: #루드가 같다면 합칠 필요가 없으니 종료
        return
    parent[x] = y #x의 부모를 y로 만들어 합쳐주기
    return

# union : 어떤 원소 x가 속한 집합을 반환 (== x의 루트노드를 반환)
def find(x) :
    if parent[x] == x : # x가 루트노드이면 자기 자신 반환
        return x
    parent[x] = find(parent[x]) # x가 루트가 아니라면 재귀를 이용해 루트노드를 찾는다.
    return parent[x]

parent = [0]*(n+1)
for i in range(n+1) :
    parent[i] = i


for i in range(m) :
    x, a, b = map(int, input().split())
    if x == 0 :
        union(a,b)
    else :
        pa = find(a)
        pb = find(b)
        if pa == pb:
            print('YES')
        else:
            print('NO')