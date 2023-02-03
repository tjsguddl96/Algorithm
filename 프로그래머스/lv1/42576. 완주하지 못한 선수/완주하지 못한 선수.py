from collections import Counter
def solution(participant, completion):
    answer = ''
    tmp=list(Counter(participant)-Counter(completion))
    return tmp[0]