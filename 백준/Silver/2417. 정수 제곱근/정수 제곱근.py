from sys import stdin
import math
n=int(stdin.readline())

sq=int(math.sqrt(n))
if n==0:
    print(0)
else:
    if (pow(sq-1,2)>=n):
        print(sq-1)
    elif(pow(sq,2)>=n):
        print(sq)
    else:
    
        print(sq+1)