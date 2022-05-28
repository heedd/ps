T = int(input())

for _ in range(1, T+1) :
    tc, size = input().split()
    size = int(size)

    arr = input().split()

    nums = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]

    answer = ''
    for i in nums :
        answer += (i+' ')*arr.count(i)

    print(tc)
    print(answer)