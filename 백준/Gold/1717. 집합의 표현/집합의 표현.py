# 유니온파인드
import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)

#find : x의 루트노트를 찾자. (+ 찾으면서 루트노드로 parents배열 완성하기)
def find(parents, x):
    if parents[x] != x:                          #루트노드면 같을텐데 아니니까..
        parents[x] = find(parents, parents[x])   #x의 부모인 parents[x]의 부모에대해 재귀적으로 찾자..
    return parents[x]                            #parents[x]==x 루트노드네! 루트노드 리턴

#union
def union(parents, a, b):
    a = find(parents, a)
    b = find(parents, b)
    if  a < b:
        parents[b] = a
    else:
        parents[a] = b

n, m = map(int, input().split())
#인덱스노드의 루트노드가 담길 parent배열
parents = [i for i in range(n+1)]  #인덱스 0부터 시작



for _ in range(m):
    op, a, b = map(int, input().split())
    if op == 0:
        union(parents, a, b)
    else:
        pa = find(parents, a)
        pb = find(parents, b)

        if pa==pb:
            print("YES")
        else:
            print("NO")