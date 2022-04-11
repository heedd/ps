import sys
input = sys.stdin.readline
from collections import Counter

arr = [ int(input()) for _ in range(10)]

print(sum(arr)//10)
print(Counter(arr).most_common()[0][0])