T = int(input())

for test_case in range(1, T+1):
    N,M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    answer = []

    # 긴쪽 찾기
    if N>M:
        max_arr = A
        min_arr = B
    else:
        max_arr = B
        min_arr = A

    # 긴쪽의 시작점을 옮길때마다 곱셈의합 구하기
    for i in range(len(max_arr)-len(min_arr)+1):
        tmp = 0
        for j in range(len(min_arr)):
            tmp += min_arr[j]*max_arr[i+j]
        answer.append(tmp)

    print('#'+str(test_case), max(answer))