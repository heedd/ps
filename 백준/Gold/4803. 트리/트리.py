# 사이클을 찾는 bfs
def dfs(prev, node):
    visited[node] = True
    for n in graph[node]:
        # 다음 노드가 이전 노드와 같다면 DFS 수행 x (무시)
        if n == prev:
            continue
        # 다음 노드 != 이전 노드, 이미 방문했다면 사이클 발생(트리 아님!)
        if visited[n]:
            return False
        # 다음 노드 != 이전 노드, 다음 노드 첫 방문 -> DFS 수행
        # DFS 수행 도중 사이클이 생긴 경우에는 False 반환
        if not dfs(node, n):
            return False
    return True


# main
tc=0
T = 0
while True:
    # 1. 입력
    tc+=1
    n, m = map(int, input().split())    # n:정점, m:간선
    if n == 0 and m == 0: break         # loop 종료조건
    graph = [[] for _ in range(n+1)]
    visited = [False] * (n+1)

    for _ in range(m):
        v1, v2 = map(int, input().split())
        graph[v1].append(v2)
        graph[v2].append(v1)

    # 2. 트리 찾는 dfs
    T = 0  # 트리의 개수
    for v in range(1, n+1):
        if not visited[v]:  # 방문하지 않은 경우만 DFS 수행
            if dfs(0, v):
                T += 1  # 사이클이 없는 경우 트리 개수 증가

    # 3. 답 출력
    if T == 0:
        print("Case {}: No trees.".format(tc))
    elif T == 1:
        print("Case {}: There is one tree.".format(tc))
    else:
        print("Case {}: A forest of {} trees.".format(tc, T))