# idea
# 최대한 많은 회의를 진행한다 == 최대한 많은 end를 한다 -> 그리디
# 시간 순으로 진행하면서 빠른 end 부터 회의진행
# prev끝나고 시작하는 next들 중 가장 먼저 끝나는 회의를 진행

n = int(input())
meetings = [list(map(int, input().split())) for _ in range(n)]
meetings.sort(key=lambda x: (x[1], x[0]))  # 종료시각 오름차순, 시작시각 오름차순 (같이 끝나면 빨리 시작한 회의 하는게 이득)

prev = meetings[0]
cnt = 1
for i in range(1, n):
    next = meetings[i]
    if prev[1] <= next[0]:
        prev = next
        cnt+=1

print(cnt)