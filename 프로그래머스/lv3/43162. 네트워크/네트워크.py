# idea : bfs돌면서 네트워크 영역 count

# bfs 함수
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

def dfs(cur, n, computers, visited):
    visited[cur] = True #방문 처리

    for ad in range(n):
        # 방문하지 않은 노드이고, 연결이 있으면
        if visited[ad] == False and computers[cur][ad] == 1:
            visited[ad] = True #방문 처리
            dfs(ad, n, computers, visited)

# main
def solution(n, computers):
    answer = 0
    visited = [False]*n
    for cur in range(n):
        if visited[cur] == False and max(computers[cur])==1:
            dfs(cur, n, computers, visited)
            answer += 1

    return answer