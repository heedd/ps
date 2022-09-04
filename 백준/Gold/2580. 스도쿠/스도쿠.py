################################################################
# 문제 : 스도쿠 2580
# 링크 : https://www.acmicpc.net/problem/2580

# 아이디어 : dfs + 백트래킹
# 주의점 : 시간초과 주의..
#   - sys.exit()
#   - dfs "전후"로 visited 처리 잊지말기!
################################################################
import sys

# grid[r][c]에 num 채워도 되는지 check
def isValid(r,c,num):
    # 1. row에 같은 숫자 있으면 False
    if num in grid[r]: return False
    # 2. col에 같은 숫자 있으면 False
    for i in range(9):
        if num == grid[i][c]: return False
    # 3. box에 같은 숫자 있으면 False
    sr, sc = r-r%3, c-c%3
    for i in range(3):
        for j in range(3):
            if num == grid[sr+i][sc+j]: return False
    return True

# 빈칸에 가능한 숫자들 넣어서 dfs 탐색
def dfs():
    cnt = 0 # 현재까지 채운 빈칸 수 
    for blank in blanks:
        if grid[blank[0]][blank[1]] == 0:
            cr, cc = blank[0], blank[1]
            break
        cnt+=1

    # dfs 종료조건 - 빈칸 다 채웠다면 종료
    if cnt == len(blanks):
        for i in range(9):
            print(*grid[i])
        # 답 하나라도 찾으면 dfs 완전탈출
        sys.exit()

    # (cr,cc)에 1~9까지 숫자 가능한지 isValid로 check
    # 가능하면 다음 blank채우러 dfs 호출
    for num in range(1,10):
        if isValid(cr,cc,num):
            ##############################
            grid[cr][cc] = num
            dfs()
            grid[cr][cc] = 0
            ##############################

# 입력
grid = []    # 스도쿠 판
blanks = []  # 빈칸들의 좌표
for i in range(9):
    grid.append(list(map(int, input().split())))
    for j in range(9):
        if grid[i][j] == 0:
            blanks.append((i,j))

# 스도쿠 채워보기
dfs()

# 출력
for i in range(9):
    print(*grid[i])
