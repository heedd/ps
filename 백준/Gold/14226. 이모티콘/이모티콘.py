"""
- 문제 : 이모티콘
- 링크 : https://www.acmicpc.net/problem/1141
- 아이디어 : 레벨단위 BFS
"""

"""
1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
3. 화면에 있는 이모티콘 중 하나를 삭제한다.
"""
s = int(input())

from collections import deque
# emoticons[num] = sec => 화면에 num개 있도록 만드는 최소 시간 sec
INF = int(1e9)
emoticons = [INF]*(1001)
emoticons[1] = 0
emoticons[2] = 2
visited = [[0]*1001 for _ in range(1001)]

def bfs():
    q = deque()
    # 화면에 몇개? 클립보드엔 몇개?
    q.append([2, 1])
    emoticons[2] = 2

    time = 2
    while q:
        time+=1
        sz = len(q)
        for i in range(sz):
            cur = q.popleft()
            # 종료조건
            # 붙여넣기 or 1빼기 연산으로 s가 된다면 출력하고 끝.

            # q 전단계에서 나를 복사했던 거라면
            # 이제는 복사말고 붙여넣을 차례
            if cur[0] != cur[1]:                        #1.복사
                q.append([cur[0], cur[0]])
            if cur[0]+cur[1]<=1000:
                if visited[cur[0]+cur[1]][cur[1]]: continue    #2.붙여넣기
                q.append([cur[0]+cur[1], cur[1]])
                emoticons[cur[0]+cur[1]] = min(emoticons[cur[0]+cur[1]], time)
            if cur[0]-1>=2:
                if visited[cur[0]-1][cur[1]]: continue         #3.-1 삭제
                q.append([cur[0]-1, cur[1]])
                emoticons[cur[0]-1] = min(emoticons[cur[0]-1], time)
                visited[cur[0]-1][cur[1]] = True
bfs()
print(emoticons[s])