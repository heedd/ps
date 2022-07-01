T = int(input())


for test_case in range(1, T+1):
    N = int(input())
    arr = [list(input().split()) for _ in range(N)]

    rot90 = [''.join(row) for row in list(map(list, zip(*arr[::-1])))]
    rot180 = [''.join(row) for row in list(map(list,zip(*rot90[::-1])))]
    rot270 = [''.join(row) for row in list(map(list,zip(*rot180[::-1])))]

    # 정답 출력
    print('#' + str(test_case))
    for i in range(3):
        print(rot90[i], rot180[i], rot270[i])