from sys import stdin

max=0
ans=0
for i in range(9):
    n=int(stdin.readline())
    if max<n:
        ans=i
        max=n
print(max)
print(ans+1)