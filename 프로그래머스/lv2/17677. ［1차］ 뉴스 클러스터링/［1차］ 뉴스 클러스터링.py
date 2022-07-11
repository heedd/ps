def solution(str1, str2):
    answer = 0
    # 두글자씩 끊어서 다중집합
    str1 = [str1[i:i+2].upper() for i in range(0, len(str1)-1) if str1[i:i+2].isalpha()]
    str2 = [str2[i:i+2].upper() for i in range(0, len(str2)-1) if str2[i:i+2].isalpha()]
    
    # 교집합
    inter, union = [], []
    for i in str1:
        if i in str2:
            if i not in inter:
                for _ in range(min(str1.count(i), str2.count(i))):
                    inter.append(i)
    # 합집합
    union = str1 + str2
    for i in inter:
        if i in union:
            union.remove(i)
    
    # 자카드 계산
    if inter == [] and union == []:
        answer = 1
    else:
        answer = len(inter)/len(union)
    
    return int(answer*65536)