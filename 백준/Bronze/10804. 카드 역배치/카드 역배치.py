def func(x,y,l):
    tmp=l[x-1:y]
    temp=[]
    for i in range(len(tmp)-1,-1,-1):
        temp.append(tmp[i])
    j=0
    for i in range(x-1,y):
        l[i]=temp[j]
        j+=1

n=[0]*20
for i in range(20):
    n[i]=i+1

for x in range(10):
    i,j=map(int,input().split())
    func(i,j,n)


for x in n:
    print(x,end=' ')

