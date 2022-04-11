import sys
input = sys.stdin.readline
from itertools import permutations

n, m = map(int, input().split())
arr = [i for i in range(1, n+1)]

for e in list(permutations(arr, m)) :
    print(" ".join(map(str, e)))