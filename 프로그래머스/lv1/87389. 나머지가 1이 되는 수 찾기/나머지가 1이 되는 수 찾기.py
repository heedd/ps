def solution(n):
    divisor = 1
    
    while True:
        if n%divisor == 1:
            break
        divisor += 1
    
    return divisor