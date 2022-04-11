import sys
input = sys.stdin.readline

arr = [str(sum(map(int, input().split()))) for _ in range(int(input()))]

print('\n'.join(arr))