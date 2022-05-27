for i in range(1, 11) :
    answer = 0
    k = int(input())
    arr = list(map(int, input().split()))
    for _ in range(k) :
        arr[arr.index(max(arr))] = max(arr) - 1
        arr[arr.index(min(arr))] = min(arr) + 1
    answer = max(arr) - min(arr)

    print('#'+str(i), answer)