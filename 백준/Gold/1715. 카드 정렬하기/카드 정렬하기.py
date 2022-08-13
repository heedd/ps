# 시간초과날 것같은 정렬문제들 -> heapq 생각해보자
# 파이썬의 heapq는 최소힙!!! 최대힙을 구현하려면 '-'부호 활용
# 최대힙이 필요하면 heappush, heappop 전후로 "-"로 부호를 변경하자!

# import heapq
# heapq.heapify(리스트) : 리스트를 힙정렬해서 힙이되게 한다.
# heapq.heappush(넣을힙, 넣을원소) : 힙의 성질을 어기지 않도록 새 원소를 삽입
# heapq.heappop(heap) : 힙에서 최솟값 pop


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
