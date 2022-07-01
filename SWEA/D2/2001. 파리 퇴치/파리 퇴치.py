T = int(input())

for test_case in range(1, T+1):
    N,M = map(int, input().split())
    arr = [list(map(int,input().split())) for _ in range(N)]

    result = []
    for i in range(N-M+1):	# 최대 파리채 영역 탐색
        for j in range(N-M+1):
            kill = 0
            for a in range(M):	# MxM 파리수 세기
                for b in range(M):
                    kill += arr[i+a][j+b]

            result.append(kill)

    print('#'+str(test_case), max(result))