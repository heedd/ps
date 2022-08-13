import heapq

n = int(input())


# 카드들의 최소heap 구현
heap = []
for _ in range(n):
    card = int(input())
    heapq.heappush(heap, card)  # 원소를 추가할 heap, 추가할 원소

sum = 0
while len(heap) != 1:
    min1 = heapq.heappop(heap)  # 최솟값 pop == 최소힙에서 루트노드 pop
    min2 = heapq.heappop(heap)
    sum += min1 + min2
    heapq.heappush(heap, min1 + min2)  # 최소힙 성질 유지하도록 원소 추가

print(sum)