def solution(id_list, report, k):
    reported = { x:set() for x in id_list} # key:신고당한id, value:신고자id
    reporter = { x:0 for x in id_list} # key:신고자id, value:메일 수
    
    for id in report:
        id = id.split()
        reported[id[1]].add(id[0])
    
    for key in reported:
        if len(reported[key]) >= k:
            for id in reported[key]:
                reporter[id] += 1
                
    return list(reporter.values())