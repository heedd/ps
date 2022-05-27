T = int(input())

for test_case in range(1, T + 1):
    arr = [list(map(int, input().split())) for _ in range(9)]
    result = 1

    # 가로 세로 체크
    for i in range(9) :
        h, v = [], []
        for j in range(9) :
            h.append(arr[i][j])
            v.append(arr[j][i])
        if len(set(h)) != len(h) or len(set(v)) != len(v) :
            result = 0
            break

    # 3x3 체크
    breaker = False
    for i in range(0,7,3):
        for j in range(0,7,3):
            s = []
            for k in range(0,3) :
                for n in range(0,3) :
                    s.append(arr[i+k][j+n])
            if len(set(s)) != len(s) :
                result = 0
                breaker = True
                break
        if breaker == True :
            break

    print('#'+str(test_case), result)