import sys
input = sys.stdin.readline

n, m = map(int, input().split())
map = [list(input().strip()) for _ in range(n)] # 0:이동, 1:벽
# visited[r][c][0] : 벽 파괴안함
# visited[r][c][1] : 벽 파괴함
visited = [[[0]*2 for _ in range(m)] for _ in range(n)]
drdc = [[0,1], [1,0], [-1,0], [0,-1]]


from collections import deque
def bfs():
    q = deque()
    q.append((0,0,0)) # (r,c,w) => w:부순 벽 개수
    visited[0][0][0] = 0

    while(q):
        size = len(q)
        for _ in range(size):
            cr, cc, cw = q.popleft()
            # (n,m) 도착했으면 return dist
            if cr==n-1 and cc==m-1: return visited[cr][cc][cw]+1
            for d in range(4):
                nr, nc = cr+drdc[d][0], cc+drdc[d][1]
                # 경계밖이면 continue
                if nr<0 or nc<0 or nr>=n or nc>=m: continue
                # 벽이고, 기회남아서 => 벽파괴하는 경우
                if map[nr][nc]=="1" and cw==0:
                        q.append((nr, nc, 1))
                        # 여태까지 파괴 안해왔기 때문에
                        # (nr,nc)에 벽부수고 도달 == (cr,cc)에 벽안부수고 도달+1
                        visited[nr][nc][1] = visited[cr][cc][0]+1
                # 일반 길이고, 아직 방문안한 곳이면 => 일반길인 경우
                elif map[nr][nc]=="0" and visited[nr][nc][cw]==False:
                    q.append((nr,nc,cw))
                    # 전에 벽 파괴 했음O) visited[nr][nc][1] = visited[nr][nc][1]+1
                    # 아직 벽 파괴 안함X) visited[nr][nc][0] = visited[nr][nc][0]+1
                    # 일반화하면 => visited[nr][nc][cw] = visited[cr][cc][cw]+1
                    visited[nr][nc][cw] = visited[cr][cc][cw]+1
    return -1

print(bfs())