from sys import stdin
answer=[]
p=int(stdin.readline())
tc=0
while(p!=0):
    party=[]
    ch=[0]*p
    for i in range(p):
        s,e=map(int,stdin.readline().split())
        st=s
        en=e
        while(s<e):
            if (s+0.5)<e:
                party.append((s,s+0.5,i,en-st))
                s+=0.5
            else:
                break
        party.append((s,e,i,en-st))

    party.sort(key=lambda x:(x[1],x[3]))
    
    endtime=0
    ans=0
    for start,end,idx,gap in party:
        if endtime<=start and ch[idx]==0 and (end-endtime)>=0.5:
            ans+=1
            ch[idx]=1
            endtime=end
    print("On day ",tc+1," Emma can attend as many as ",ans," parties.",sep="")
    tc+=1
    p = int(stdin.readline())

