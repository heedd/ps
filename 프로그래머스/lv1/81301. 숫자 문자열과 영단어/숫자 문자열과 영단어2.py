def solution(s):
    arr = ['zero', 'one', 'two', 'three', 'four',
           'five', 'six', 'seven', 'eight', 'nine']
    for i in arr :
        s = s.replace(i, str(arr.index(i)))

    return int(s)
