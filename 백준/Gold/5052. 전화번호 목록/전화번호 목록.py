import sys
input = sys.stdin.readline

def check(n, phone):
    # phone[i]가 phone[i-1]의 prefix이면 NO
    for i in range(n-1):
        if phone[i] == phone[i+1][:len(phone[i])]:
            print("NO")
            return

    print("YES")

t = int(input())
for tc in range(t):
    answer = "YES"
    n = int(input())
    phone = [input().rstrip() for _ in range(n)]
    phone.sort()  # 911 - 91125426 - 97625999

    check(n, phone)