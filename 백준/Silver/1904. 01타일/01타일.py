n=int(input())
mem=[0]*(n+1)
mem[0]=0
mem[1]=1
if n>1:
    mem[2]=2
def Dynamic(N):
    if N==0:
        return mem[0]%15746
    elif N==1:
        return mem[1]%15746
    elif N==2:
        return mem[2]%15746
    else:
        for i in range(3,N+1):
            mem[i]=(mem[i-2]+mem[i-1])%15746

Dynamic(n)
print(mem[n]%15746)