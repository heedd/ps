def solution(lottos, win_nums):
    answer = []
    
    # 1.일치/ 2.0개수/ 3.로또랑 윈넘
    same, zero, fail = 0,0,0
    for i in range(len(lottos)):
        if lottos[i] in win_nums:
            same += 1
        elif lottos[i] == 0:
            zero += 1
        
    answer = [7-(same+zero), 7-same]
    if answer[0] > 6:
        answer[0] = 6
    if answer[1] > 6:
        answer[1] = 6
    
    return answer