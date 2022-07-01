T = int(input())

for test_case in range(1, T+1):
    N,K = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(N)] # 흰색:1, 검정:0
    answer = 0


    #가로
    for y in range(N):
        cnt = 0
        for x in range(N):
            if arr[y][x] == 0:
                if cnt == K:
                    answer += 1
                cnt = 0
            else:
                cnt += 1
        if cnt == K:
            answer += 1

    #세로
    for x in range(N):
        cnt = 0
        for y in range(N):
            if arr[y][x] == 0:
                if cnt == K:
                    answer +=1
                cnt = 0
            else:
                cnt += 1
        if cnt == K:
            answer += 1

    print('#'+str(test_case), answer)