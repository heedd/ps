def solution(record):
    answer = []
    act = []      # act = [[행동, 유저아이디], [행동, 유저아이디], [행동, 유저아이디]...]
    uid_dict = {} # uid_dict[유저아이디] = 닉네임
    
    for i in record:
        arr = i.split()
        if arr[0] == 'Enter':
            uid_dict[arr[1]] = arr[2]
            act.append([arr[0], arr[1]])
        elif arr[0] == 'Leave':
            act.append([arr[0], arr[1]])
        else:
            uid_dict[arr[1]] = arr[2]
    
    for a in act:
        if a[0] == 'Enter':
            answer.append(f"{uid_dict[a[1]]}님이 들어왔습니다.")
        else:
            answer.append(f"{uid_dict[a[1]]}님이 나갔습니다.")
        
    return answer