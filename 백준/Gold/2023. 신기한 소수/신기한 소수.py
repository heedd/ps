from collections import deque

def isPrime(num):
    for div in range(2, int(num**0.5)+1):
        if num % div == 0 : return False
    return True

def bfs():
    q = deque([2, 3, 5, 7])
    while q:
        cur = q.popleft()
        if 10**(n-1)<cur<10**n:
            # n자릿수의 신기한 소수 뽑았으니 출력
            print(cur)
        else:
            # 짝수면 절대 소수가 될 수는 없으니까 홀수를 일단 붙여보고
            # isPrime으로 소수면 다음 자릿수 고르기 위해 cur||next을 q에 넣기
            for next in range(1, 10, 2):
                if isPrime(cur*10+next):
                    q.append(cur*10+next)
n = int(input())
bfs()