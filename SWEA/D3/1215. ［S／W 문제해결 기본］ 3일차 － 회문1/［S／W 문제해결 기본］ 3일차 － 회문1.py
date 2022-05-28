for test_case in range(1, 11) :
    size = int(input())
    grid = [input() for _ in range(8)]
    count = 0

    # 가로
    for i in range(8) : # y: 0~7
        for j in range(8-size+1) : # x: 0~3
            tmp = grid[i][j:j+size]
            if tmp == tmp[::-1] :
                count += 1

    # 세로
    for i in range(8) : # x: 0~7
        for j in range(8-size+1) :  # y: 0~3
            tmp = ''
            for k in range(size) :
                tmp += grid[j+k][i]
            if tmp == tmp[::-1] :
                count += 1

    print('#'+str(test_case), count)