def func(n, m, a) :
    a = a*n
    m -= 1
    if m == 0 :
        return a
    return func(n, m, a)

for test_case in range(1, 11) :
    t = int(input())
    n, m = map(int, input().split())
    answer = 1
    print('#'+str(test_case), func(n, m, answer))