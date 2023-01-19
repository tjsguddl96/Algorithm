t=int(input())
case=[]
for i in range(t):
    case.append(int(input()))
maxx=max(case)
mem0=[0]*(maxx+1)
mem1=[0]*(maxx+1)
mem0=[1,0]
mem1=[0,1]
def dynamic(N):
    if N==0:
        return mem0[N],mem1[N]
    elif N==1:
        return mem0[N],mem1[N]
    else:
        for i in range(2,N+1):
            mem0.append(mem0[i - 2] + mem0[i - 1])
            mem1.append(mem1[i - 2] + mem1[i - 1])
dynamic(maxx)

for j in range(len(case)):
    print(mem0[case[j]],mem1[case[j]],sep=' ')
