import sys
input = sys.stdin.readline

n, c = map(int, input().rstrip().split())
house = [int(input().rstrip()) for _ in range(n)]
house.sort()             #이진탐색을 위해 정렬 - O(nlogn)
mn = 1                   #최소 간격
mx = house[-1]-house[0]  #최대 간격


# 이진 탐색 수행(반복적)
result = 0
while(mn <= mx):
    mid = (mx + mn) // 2

    #사이 거리가 mid 이상인 공유기들 개수 count
    cnt = 1
    prev_house = house[0]
    for i in range(1, n):
        if house[i] - prev_house >= mid:  #덜이전 거리가 mid 이상이면 cnt
            cnt+=1
            prev_house = house[i]
    #print(mn, mx, mid, cnt)

    if cnt < c:     # mid 이상 떨어진 공유기들 c보다 적음 => mid 좁혀야 됨
        mx = mid-1
    else:           # mid 이상 떨어진 공유기들 c보다 많음 => mid 넓혀도 됨
        mn = mid+1
        result = mid  #잠재적 mid 정답

# 정답 출력
print(result)