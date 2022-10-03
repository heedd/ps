################################################################
# 문제 : 종이 조각 14391
# 링크 : https://www.acmicpc.net/problem/14391
# 아이디어 : 완전탐색 DFS
################################################################

import sys

# visited: True면 잘려나간 부분
# tmpSum: 현재까지의 종이조각들의 합
maxSum = 0
def dfs(visited, tmpSum):
    ### starts 찾기
    starts = []
    # 왼->오
    for c in range(m):
        for r in range(n):
            if visited[r][c] == False and paper[r][c]!='0':
                starts.append((r, c, 'ver'))
                break
    # 위->아래
    for r in range(n):
        for c in range(m):
            if visited[r][c] == False and paper[r][c]!='0':
                starts.append((r, c, 'hor'))
                break
    # print(starts)
    ### 종료 조건
    if(len(starts)==0):
        global maxSum
        maxSum = max(maxSum, tmpSum)
        return

    ### 찾은 starts로 DFS
    for pos in starts:
        tmp='0'
        flag = False

        if pos[2]=='ver':
            lastRow = -1
            for r in range(pos[0], n):
                if flag == True and visited[r][pos[1]] == True: break
                if visited[r][pos[1]] == False :
                    flag = True
                    tmp += paper[r][pos[1]]
                    # do visited
                    visited[r][pos[1]] = True
                    lastRow = r
            # DFS 호출
            dfs(visited, tmpSum+int(tmp))
            # undo visited
            for r in range(pos[0], lastRow+1):
                visited[r][pos[1]] = False

        elif pos[2]=='hor':
            lastCol = -1
            for c in range(pos[1], m):
                if flag == True and visited[pos[0]][c] == True: break
                if visited[pos[0]][c] == False:
                    flag=True
                    tmp += paper[pos[0]][c]
                    # do visited
                    visited[pos[0]][c] = True
                    lastCol = c
            # DFS 호출
            dfs(visited, tmpSum+int(tmp))
            # undo visited
            for c in range(pos[1], lastCol+1):
                visited[pos[0]][c] = False


n, m = map(int, input().split())
paper = [list(input()) for _ in range(n)]   # 자료형 str
visited = [[False]*m for _ in range(n)]

dfs(visited, 0)
print(maxSum)