n = int(input())
numbers = list(map(int, input().split()))   # n개
plus, minus, mul, div = map(int, input().split())
# ops = list(map(int, input().split())) # n-1개
maxSum = int(-1e9)
minSum = int(1e9)


def cal(cnt, tmpSum, plus, minus, mul, div):
    if(cnt == n):
        global maxSum, minSum
        maxSum = max(maxSum, tmpSum)
        minSum = min(minSum, tmpSum)
        return

    if (plus!=0):
        cal(cnt+1, tmpSum + numbers[cnt], plus-1, minus, mul, div)
    if (minus!=0):
        cal(cnt+1, tmpSum - numbers[cnt], plus, minus-1, mul, div)
    if (mul != 0):
        cal(cnt + 1, tmpSum * numbers[cnt], plus, minus, mul-1, div)
    if (div != 0):
        if(tmpSum<0) : tmpSum = -((-tmpSum)//numbers[cnt])
        else: tmpSum = tmpSum//numbers[cnt]
        cal(cnt + 1, tmpSum, plus, minus, mul, div-1)

cal(1, numbers[0], plus, minus, mul, div)

print(maxSum)
print(minSum)