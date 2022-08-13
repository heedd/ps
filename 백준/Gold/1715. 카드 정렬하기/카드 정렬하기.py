# 파이썬의 heapq는 최소힙!
# 시간초과날것같은 정렬문제들 -> heapq 생각해보자
# import heapq
# heapq.heappush(넣을힙, 넣을원소)
# heapq.heappop(heap) : heap에서 최솟값 pop


import heapq

n = int(input())


# 카드들의 최소heap 구현

heap = [int(input()) for _ in range(n)]
heapq.heapify(heap)

sum = 0
while len(heap) != 1:
    min1 = heapq.heappop(heap)  # 최솟값 pop == 최소힙에서 루트노드 pop
    min2 = heapq.heappop(heap)
    sum += min1 + min2
    heapq.heappush(heap, min1 + min2)  # 최소힙 성질 유지하도록 원소 추가

print(sum)