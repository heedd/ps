n = int(input())

for i in range(1, n+1) :
    arr = str(i)
    cnt = 0
    for j in arr :
        if int(j)%3 == 0 :
            cnt += 1
    if cnt == 0 :
        print(str(i), end=' ')
    else :
        print('-'*cnt, end= ' ')