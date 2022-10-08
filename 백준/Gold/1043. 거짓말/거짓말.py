"""
- 문제 : 거짓말
- 링크 : https://www.acmicpc.net/problem/1043
- 아이디어 : 유니온 파인드
- 게리맨더링(17471)이랑 비슷하게 풀었음
"""


### 유니온 파인드
def find(a):
    global roots
    if roots[a]==a: return a
    roots[a] = find(roots[a])
    return roots[a]

def union(a, b):
    global roots
    pa = find(a)
    pb = find(b)
    if pa!=pb :
        roots[pa] = pb

### 1. 입력
# 사람, 파티
n, m = map(int, input().split())
knowNum, *knowList = map(int, input().split())
knowList = set(knowList)

# 인덱스 1부터 시작, 사람번호 1부터 시작
# knowPPL들은 다 루트노드가 0이 되도록 union해줄 것임
roots = [i for i in range(n+1)]

parties = []
for _ in range(m):
    flag = False
    partyNum, *party = map(int, input().split())
    party = set(party)
    parties.append(party)


### 2. knowPPL 구하기
# knowPPL이 있는 파티에 참가한 사람들도 knowPPL 취급. => union해주기
for _ in range(m):
    # for i in range(n+1):
    #     print(roots[i],end=' ')
    # print()
    for partyList in parties:
        # 파티에 knowPpl이 있다면, 거짓말 못함
        # knowList와 partyList 교집합이 있다면, 합집합을 모두 union
        if knowList & partyList :
            for partyPpl in partyList:
                knowList = knowList | partyList
                union(partyPpl, 0)


### 3. 거짓말 가능한 party 개수 구하기
lieCnt = 0
for partyList in parties:
    flag = False
    for partyPpl in partyList:
        if find(partyPpl) == 0:
            flag = True
            break
    if flag: continue
    lieCnt+=1

print(lieCnt)