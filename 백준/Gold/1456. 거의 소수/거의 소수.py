from sys import stdin
import math
def isPrime(num):
    global prime;
    for i in range(2,int(math.sqrt(num))+1):
        if prime[i]==True:
            j=2
            while(i*j<len(prime)):
                prime[i*j]=False
                j+=1

a,b=map(int,stdin.readline().split())
prime=[True]*(int(math.sqrt(b))+1)
prime[1]=False
isPrime(b)
ans=0
for i in range(2,int(math.sqrt(b))+1):

    if prime[i]==True:
        j=2
        while(pow(i,j)<=b):
            if a<=pow(i,j)<=b:
                ans+=1
            j+=1

print(ans)
