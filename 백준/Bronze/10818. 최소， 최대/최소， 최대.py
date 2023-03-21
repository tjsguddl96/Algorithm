from sys import stdin

n=int(stdin.readline())
arr=list(map(int,stdin.readline().split()))
print(min(arr),max(arr),sep=' ')