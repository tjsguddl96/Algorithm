from sys import stdin
answer=0
ans=0
def isPrime(n,k):
    global answer,ans
    prime=[0]*(n+1)  #0이면 소수가 X
    for i in range(2,n+1):
        if (prime[i]==0):
            j=1
            while(i*j<n+1):

                if prime[i*j]==0:
                    answer += 1
                    prime[i * j] = 1

                if (answer==k):

                    ans=i*j
                    break
                j+=1
        if ans!=0:
            break
n,k=map(int,stdin.readline().split())

isPrime(n,k)
print(ans)