import sys
input = sys.stdin.readline

n = int(input())
k = int(input())
num = [input().rstrip() for _ in range(n)]

from itertools import permutations

answer = set()
for item in permutations(num, k):
     answer.add(''.join(item))
print(len(answer))