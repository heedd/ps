"""
- 문제 : 회전초밥
- 링크 : https://www.acmicpc.net/problem/15961
- 아이디어 : 슬라이딩 윈도우?
- 그 옛날에 카카오 문제(시설점검?)랑 비슷하게 풀면되겠음 배열*2해줘서 회전효과주기
  아 근데 범위가 좀 크네 고민된다
- 시간복잡도 : 와 시간초과~~~~
  list -> set : 이 연산의 시간복잡도 궁금하다
"""

import sys
input = sys.stdin.readline

def solution():
    """
    n: 벨트 위 접시 개수
    d: 초밥의 메뉴 개수
    k: 연속해서 먹은 개수
    c: 쿠폰으로 먹을 수 있는 초밥 번호

    2 ≤ N ≤ 3,000,000, 2 ≤ d ≤ 3,000, 2 ≤ k ≤ 3,000 (k ≤ N)
    """
    n, d, k, c = map(int, input().rstrip().split())

    table = []
    for i in range(n):
        table.append(int(input().rstrip()))
    table += table

    #그냥 딕셔너리 씁시다~~!
    menu = dict([])
    for i in range(k):
        new = table[i]
        if menu.get(new) == None:
            menu[new] = 1
        else:
            menu[new] += 1

    if menu.get(c) == None:
        menu[c] = 1
    else:
        menu[c] += 1

    maxMenu = len(menu)
    # print(k, c)
    # print(table)
    # print(menu)
    for start in range(1,n):
        # prev 지우기
        prev = table[start-1]
        # print('before: ',menu, prev)
        if menu[prev] == 1:
            menu.pop(prev)
        else:
            menu[prev] -= 1

        # new 포함시키기
        new = table[start-1+k]
        if menu.get(new) == None:
            menu[new] = 1
        else:
            menu[new] += 1

        maxMenu = max(maxMenu, len(menu))
        # print('after: ',menu, new)
        # print()

    return maxMenu


print(solution())