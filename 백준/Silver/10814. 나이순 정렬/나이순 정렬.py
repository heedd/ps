import sys
input = sys.stdin.readline

n = int(input())
arr = [list(input().split()) for _ in range(n)]

arr.sort(key=lambda x: int(x[0]))
for item in arr :
    print(int(item[0]), item[1])