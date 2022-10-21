"""
- 문제 : 접두사
- 링크 : https://www.acmicpc.net/problem/1141
- 아이디어 : 정렬
"""

n = int(input())
words = [input() for _ in range(n)]
words.sort()
noPrefix = set()

prev = words[0]
noPrefix.add(prev)
for i in range(1, n):
    next = words[i]
    if prev == next[:len(prev)]:
        noPrefix.remove(prev)  #동가홍상
        noPrefix.add(next)
        prev = next
        continue
    noPrefix.add(next)
    prev = next

print(len(noPrefix))