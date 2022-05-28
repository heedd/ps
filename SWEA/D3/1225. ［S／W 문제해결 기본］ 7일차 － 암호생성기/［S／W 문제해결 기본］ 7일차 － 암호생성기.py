from collections import deque

for test_case in range(1, 9) :
    t = int(input())
    q = deque(list(map(int, input().split())))

    flag = True
    while flag :
        ct = 0
        for i in range(5) :
            ct += 1
            q[0] = q[0] - (i+1)
            q.rotate(-1)
            if q[-1] <= 0 :
                q.pop()
                q.append(0)
                flag = False
                break

    print('#'+str(test_case), *q)