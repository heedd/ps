n = int(input())

synergy = [list(map(int, input().split())) for _ in range(n)]
player = set(i for i in range(n))

from itertools import combinations

minimum = 100

for team1 in list(combinations(player, n//2)) :
    t1 = 0
    t2 = 0

    team2 = player - set(team1)

    for i in team1 :
        for j in team1:
            t1 += synergy[j][i]

    for i in team2 :
        for j in team2:
            t2 += synergy[j][i]

    minimum = min(minimum, abs(t1-t2))

print(minimum)