##################################
#      이진탐색 - 재귀로 구현
##################################

import sys
input = sys.stdin.readline


n, m = map(int, input().rstrip().split())
heights = list(map(int, input().rstrip().split()))


def tree_sum(heights, h):
    sum = 0
    for i in heights:
        if(i>h):
            sum+=i-h
    return sum

def bisect_height(array, start, end):
    if(start>end):     #종료조건
        return end

    h = (start + end)//2
    result = tree_sum(array, h)

    if result >= m:
        return bisect_height(array, h+1, end)
    else:
        return bisect_height(array, start, h-1)

mx = max(heights)
print(bisect_height(heights, 0, mx))