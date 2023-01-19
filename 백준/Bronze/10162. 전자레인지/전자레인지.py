T=int(input())
if T%10!=0:
    print(-1)
else:
    answer=[]
    micro=[3000,60,10]
    tmp=T%3000
    for i in range(3):
        answer.append(T//micro[i])
        T%=micro[i]
    print(answer[0],answer[1],answer[2],end=' ')