n = int(input())
arr = list(map(int, input().split()))

# arr의 최소 최대 인덱스
mn = 0
mx = n-1

best_result, best_mn, best_mx = int(2e9), 0, 0

# arr의 인덱스를 반으로 줄여가며 이분탐색
while(True):
    # 종료조건
    if mn==mx:
        break

    result = arr[mn]+arr[mx]
    # 좁혀진 탐색범위에서 better case가 있으면  best변수들 갱신
    if abs(best_result) >= abs(result):
        best_result = result
        best_mn, best_mx = mn, mx

    # 혼합 결과가 음수면, mn을 키워야됨
    if result < 0:
        mn = mn+1
    # 혼합 결과가 양수면, mx를 줄여야됨
    elif result > 0:
        mx = mx-1
    # 혼합 결과가 0이면, 그대로 break
    elif result == 0:
        break


print(arr[best_mn], arr[best_mx])