n = int(input())
s, g, p, d = list(map(int, input().split()))
tier = input()
sum = 0
prev = 0

for i in range(n):
    if tier[i] == 'B':
        sum += s - 1 - prev
        prev = s - 1 - prev
    elif tier[i] == 'S':
        sum += g - 1 - prev
        prev = g - 1 - prev
    elif tier[i] == 'G':
        sum += p - 1 - prev
        prev = p - 1 - prev
    elif tier[i] == 'P':
        sum += d - 1 - prev
        prev = d - 1 - prev
    elif tier[i] == 'D':
        sum += d
        prev = d
print(sum)