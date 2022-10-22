from collections import deque

t = int(input())
for _ in range(t):
    k, m, p = map(int, input().split())
    strahler = 0
    
    inDegree = [0]*(m+1)                # inDegree[v] : v노드의 진입 차수                  /인덱스 1부터 시작
    adjList = [[] for _ in range(m+1)]  # adjList[v]  : : v노드에서 갈 수 있는 노드리스트    /인덱스 1부터 시작

    # 1. 인접간선 정보와 진입차수 입력받기
    for edge in range(p):
        fm, to = map(int, input().split())
        adjList[fm].append(to)
        inDegree[to] += 1
    
    # 2. 위상정렬 수행
    q = deque()
    
    orders = [-1]*(m+1)            # 노드들의 순서를 담은 리스트
    sameInCheck = [False]*(m+1)    #

    # 진입차수가 0인 노드들 큐에 넣기
    for v in range(1,m+1):
        if inDegree[v] == 0:
            q.append(v)
            orders[v] = 1

    while q:
        # print(q)
        sz = len(q)
        for _ in range(sz):
            cur = q.popleft()

            for v in adjList[cur]:      # cur와 연결된 노드들 탐색
                inDegree[v] -= 1        # cur를 없앨거니까 노드들의 진입차수를 -1빼주고

                if orders[v] == orders[cur] and sameInCheck[v]==False: 
                    # v의 순서가 cur의 순서와 같고, 아직 +1효과를 안줬다면
                    # v노드에 cur순서가 2개 이상 진입한다는 의미이므로 v의 순서를 +1해준다 (조건2-2)
                    orders[v] += 1
                    sameInCheck[v] = True
                elif orders[cur] > orders[v]: orders[v] = orders[cur]                  # cur의 순서가 v의 순서보다 크다면, v의 순서를 cur순서로 바꿔준다 (조건2-1)

                if inDegree[v] == 0:    # 진입차수가 새롭게 0이 된 노드들은 q에 넣어주기
                    q.append(v)
        # print([i for i in range(1,m+1)])
        # print(orders[1:])
    # print(sameInCheck)
    print(k, max(orders))