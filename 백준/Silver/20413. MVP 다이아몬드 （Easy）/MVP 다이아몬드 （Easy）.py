n = int(input())
s, g, p, d = list(map(int, input().split()))
tier = list(input())
sum = 0
prev = 0

for t in tier:
    if t == 'B':
        sum += (s - 1) - prev
        prev = (s - 1) - prev
    elif t == 'S':
        sum += (g - 1) - prev
        prev = (g - 1) - prev
    elif t == 'G':
        sum += (p - 1) - prev
        prev = (p - 1) - prev
    elif t == 'P':
        sum += (d - 1) - prev
        prev = (d - 1) - prev
    elif t == 'D':
        sum += d
        prev = d

print(sum)