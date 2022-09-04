################################################################
# 문제 : 게리맨더링2 17779
# 링크 : https://www.acmicpc.net/problem/17779

# 아이디어 : 구현
# 주의점 :
#   - d1, d2 ≥ 1,
#     1 ≤ x < x+d1+d2 ≤ N
#     1 ≤ y-d1 < y < y+d2 ≤ N
#     이 조건이 region5 박스가 전체 map을 안 넘는다는 얘기였음...
#     굳이 넘는 경우까지 세줘서 python3로 시간초과 떴었음..
################################################################
import sys
input = sys.stdin.readline


def findRegion5(x, y, d1, d2):
    for r in range(d1+1):
        region5[x+r][y-r] = True
        region5[x+d2+r][y+d2-r] = True

    for c in range(d2+1):
        region5[x+c][y+c] = True
        region5[x+d1+c][y-d1+c] = True


def divideRegion(x, y, d1, d2):
    sum1, sum2, sum3, sum4, sum5 = 0,0,0,0, totSum

    for r in range(1,n+1):
        for c in range(1,n+1):
            # 구역1 인구수 count
            if 1<=r<x+d1 and 1<=c<=y:
                if region5[r][c]: break
                else:
                    sum1+=map[r][c]
            # 구역3 인구수 count
            if x+d1<=r<=n and 1<=c<y-d1+d2:
                if region5[r][c]: break
                else:
                    sum3+=map[r][c]
    for r in range(n,0,-1):
        for c in range(n,0,-1):
            # 구역2 인구수 count
            if 1<=r<=x+d2 and y<c<=n:
                if region5[r][c]: break
                else:
                    sum2+=map[r][c]
            # 구역4 인구수 count
            if x+d2<r<=n and y-d1+d2<=c<=n:
                if region5[r][c]: break
                else:
                    sum4+=map[r][c]

    # 구역5 인구수 count
    sum5 -= (sum1+sum2+sum3+sum4)

    # 선거구가 5개로 나눠지지 않았다면 return
    if sum1==0 or sum2==0 or sum3==0 or sum4==0 or sum5==0: return

    tmpDiff = max(sum1,sum2,sum3,sum4,sum5) - min(sum1,sum2,sum3,sum4,sum5)
    # minDiff = minDiff>tmpDiff? tmpDiff: minDiff

    global minDiff
    minDiff = tmpDiff if minDiff>tmpDiff else minDiff


# 입력
n = int(input())
map = [list(map(int, input().split())) for _ in range(n)]
totSum= 0
for r in range(n):
    map[r].insert(0,0)
    totSum += sum(map[r])
map.insert(0, [0]*(n+1))

# 선거구 완탐 with divdeRegion
# d1, d2 ≥ 1,               => d:1~ 5구역나눠지도록
# 1 ≤ x < x+d1+d2 ≤ N,      => 1 ≤ x ≤ n-d1-d2
# 1 ≤ y-d1 < y < y+d2 ≤ N   => 1+d1 ≤ y ≤n-d2
minDiff = sys.maxsize
cnt = 0
for d1 in range(1,n):
    for d2 in range(1,n):
        for x in range(1,n-d1-d2+1):
            for y in range(1+d1,n-d2+1):
                region5 = [[False]*(n+1) for _ in range(n+1)]
                findRegion5(x, y, d1, d2)
                divideRegion(x, y, d1, d2)


# 완탐 후 최소 인구차 출력
print(minDiff)