T = int(input())
for _ in range(T):
    # 입력
    N = int(input())
    tree = [0]*(N+2)
    for i in range(N - 1):
        parents, child = map(int, input().split())
        tree[child] = parents
    A, B = map(int, input().split())

    # A,B 조상찾기
    A_par, B_par = [A], [B]
    A_tmp, B_tmp = A, B
    while True :
        if tree[A_tmp] == 0 :
            break
        A_par.append(tree[A_tmp])
        A_tmp = tree[A_tmp]

    while True :
        if tree[B_tmp] == 0 :
            break
        B_par.append(tree[B_tmp])
        B_tmp = tree[B_tmp]

    #A,B 최소 공통 조상찾기
    for i in A_par:
        if i in B_par:
            print(i)
            break

