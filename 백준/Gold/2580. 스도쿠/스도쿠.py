################################################################
# 문제 : 스도쿠 2580
# 링크 : https://www.acmicpc.net/problem/2580

# 아이디어 : dfs + 백트래킹
# 주의점 : 시간초과 주의..
################################################################

import sys

def isValid(r,c,num):
    # row에 같은 숫자 있으면 False
    if num in grid[r]: return False
    # col에 같은 숫자 있으면 False
    for i in range(9):
        if num == grid[i][c]: return False
    # box에 같은 숫자 있으면 False
    sr, sc = r-r%3, c-c%3
    for i in range(3):
        for j in range(3):
            if num == grid[sr+i][sc+j]: return False
    return True


def dfs():
    cnt = 0
    for blank in blanks:
        if grid[blank[0]][blank[1]] == 0:
            cr, cc = blank[0], blank[1]
            break
        cnt+=1

    # dfs 종료조건
    if cnt == len(blanks):
        for i in range(9):
            print(*grid[i])
        # 제일 먼저 찾은 해만 print하고 dfs 완전탈출
        sys.exit()

    for num in range(1,10):
        if isValid(cr,cc,num):
            grid[cr][cc] = num
            dfs()
            grid[cr][cc] = 0


grid = []
blanks = []
for i in range(9):
    grid.append(list(map(int, input().split())))
    for j in range(9):
        if grid[i][j] == 0:
            blanks.append((i,j))
dfs()

for i in range(9):
    print(*grid[i])