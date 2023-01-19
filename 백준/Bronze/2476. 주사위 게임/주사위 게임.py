
def func(x):
    i=0
    tmp=set()
    for j in range(3):
        tmp.add(x[j])
    if len(tmp)==3:
        return x[2]*100
    elif len(tmp)==1:
        return 10000+x[0]*1000
    else :
        if x[i]==x[i+1]:
            return 1000+x[i]*100
        else:
            return 1000+x[i+1]*100


N=int(input())
ans=[0]*N
for i in range(N):
    a=[]
    a=list(map(int,input().split()))
    a.sort()
    ans[i]=func(a)
ans.sort()
print(ans[N-1])
