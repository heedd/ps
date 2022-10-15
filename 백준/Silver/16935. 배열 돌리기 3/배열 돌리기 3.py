#상하
def op1():
    global arr
    arr = arr[::-1]

#좌우
def op2():
    global arr
    for i in range(len(arr)):
        arr[i] = arr[i][::-1]

#시계방향 90도
def op3():
    global arr
    arr = list(zip(*arr[::-1]))


#반시계방향 90도
def op4():
    global arr
    arr = list(zip(*arr))[::-1]

# 12 -> 41
# 43    32
def op5():
    global arr
    n = len(arr)
    m = len(arr[0])

    # 6 -> 012 345
    # (0,0)    (0, m/2)
    # (n/2,0)  (n/2, m/2)
    tmp = [[0]*m for _ in range(n)]
    for r in range(n//2):
        for c in range(m//2):
            tmp[r][c+m//2] = arr[r][c]
            tmp[r+n//2][c+m//2] = arr[r][c+m//2]
            tmp[r+n//2][c] = arr[r+n//2][c+m//2]
            tmp[r][c] = arr[r+n//2][c]
    arr = tmp

# 12 -> 23
# 43    14
def op6():
    global arr
    n = len(arr)
    m = len(arr[0])

    # 6 -> 012 345
    # (0,0)    (0, m/2)
    # (n/2,0)  (n/2, m/2)
    tmp = [[0]*m for _ in range(n)]
    for r in range(n//2):
        for c in range(m//2):
            tmp[r][c] = arr[r][c+m//2]
            tmp[r][c+m//2] = arr[r+n//2][c+m//2]
            tmp[r+n//2][c+m//2] = arr[r+n//2][c]
            tmp[r+n//2][c] = arr[r][c]
    arr = tmp


def print_arr():
    for i in range(len(arr)):
        print(*arr[i])


"""
main 시작
"""
n, m, r = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
ops = list(map(int, input().split()))

for op in ops:
    if op == 1: op1()
    elif op == 2: op2()
    elif op == 3: op3()
    elif op == 4: op4()
    elif op == 5: op5()
    else: op6()

print_arr()