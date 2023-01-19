musthave=[1,1,2,2,2,8]
find=list(map(int,input().split()))
ans=[]
for i in range(len(musthave)):
    ans.append(musthave[i]-find[i])
for a in ans:
    print(a,end=' ')