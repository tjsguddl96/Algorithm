n=int(input())
mem=[0]*(n+1)
mem[0]=0
mem[1]=1
if n>=2:
    mem[2]=2
def dynamic(j):
    if mem[j]>0:
        return mem[j]
    if j==0:
        return mem[0]
    elif j==1:
        return mem[1]
    elif j==2:
        return mem[2]
    else:
        mem[j]=dynamic(j-2)+dynamic(j-1)
        return mem[j]

print(dynamic(n)%10007)
