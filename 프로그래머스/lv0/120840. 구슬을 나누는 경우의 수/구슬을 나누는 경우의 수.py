answer = 1
def cal(num):
    global answer
    if num==1:
        return answer
    answer=num*cal(num-1)
    return answer
def solution(balls, share):
    global answer
    ans=1
    if balls==share:
        return ans
    n1=cal(balls)
    answer=1
    n2=cal(balls-share)
    answer = 1
    n3=cal(share)
    answer = 1
    ans=n1//(n2*n3)
    return ans