def recursive(s):
    if s == "":
        return s

    u, v = divide(s)
    if isRight(u):
        return u + recursive(v)
    else:
        tmp = "(" + recursive(v) + ")"
        return tmp + reverse(u)[1:-1]

def reverse(s):
    tmp = ""
    for i in range(len(s)):
        if s[i] == "(": tmp += ")"
        else: tmp += "("
    return tmp

def divide(s):
    left, right = 0, 0
    for i in range(len(s)):
        if s[i] == "(": left += 1
        elif s[i] == ")": right += 1
        if left == right: break
    return s[:i + 1], s[i+1:]


from collections import deque
def isRight(s):
    q = deque()
    for ch in s:
        if ch == "(":
            q.append(ch)
        else:
            if not q:
                return False
            q.popleft()
    return True


def solution(p):
    if isRight(p):
        return p
    answer = recursive(p)
    return answer