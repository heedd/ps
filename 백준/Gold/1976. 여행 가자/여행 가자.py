###############################################################
# 문제 : 여행 계획
# 링크 : https://www.acmicpc.net/problem/1976
# 아이디어 : 유니온파인드
#   - 여행지 방문시 왔던 길 되돌아가도 됨 & 계획에 없는 여행지 거쳐가도됨
#     여행지들이 같은 집합이면 됨 => 유니온파인드
###############################################################

import sys
input = sys.stdin.readline

# n, m = map(int, input().split())
n = int(input())
m = int(input())

parents = [ i for i in range(n+1)]  # 인덱스 1부터 시작

def find(parents, a):
    if parents[a] == a: return a
    parents[a] = find(parents, parents[a])
    return parents[a]

def union(parents, a, b):
    pa = find(parents, a)
    pb = find(parents, b)
    if pa != pb: parents[pb] = pa


connect = [list(map(int, input().split())) for _ in range(n)]
plans = list(map(int, input().split()))
for i in range(n):
    for j in range(n):
        if connect[i][j] == 1:
            union(parents, i+1, j+1)


# 여행지들의 루트가 같은지 확인하기
flag = True
root = find(parents, plans[0])
for i in  range(len(plans)):
    if find(parents, plans[i]) != root:
        flag = False
        break
if flag == False:
    print("NO")
else:
    print("YES")