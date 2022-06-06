n = int(input())
a = list(map(int, input().split()))
b, c = map(int, input().split())

cnt = n

for i in a :
    tmp = i - b    # 총감독
    if tmp > 0 :    # 부감독
        if tmp % c == 0 :
            cnt += tmp//c
        else :
            cnt += 1 + tmp//c

print(cnt)