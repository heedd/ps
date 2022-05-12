import sys
input = sys.stdin.readline

n = int(input())
k = int(input())
num = [input().rstrip() for _ in range(n)]

from itertools import combinations, permutations

comb = list(combinations(num, k))
select = []
for item in comb :
    tmp = sorted(item)
    if tmp not in select  :
        select.append(tmp)

answer = []
for item in select :
    tmp = list(set(list(permutations(item))))
    for i in tmp :
        answer.append(''.join(i))

print(len(set(answer)))