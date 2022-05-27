for _ in range(10) :
    result = []

    tc = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]
    brr = list(map(list, zip(*arr[::-1])))

    j = 0
    c1, c2 = 0, 0
    for i in range(100) :
        result.append(sum(arr[i]))
        result.append(sum(brr[i]))
        c1 += arr[i][j]
        c2 += arr[i][99-j]
        j += 1

    result.extend([c1, c2])

    print('#'+str(tc), max(result))