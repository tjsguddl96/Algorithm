import sys
sys.setrecursionlimit(10**5)
m,n=map(int,sys.stdin.readline().split()) #m이 세로,n이 가로
arr=[list(map(int,sys.stdin.readline().split())) for _ in range(m)]

dx=[1,-1,0,0]
dy=[0,0,1,-1]
mem=[[-1]*n for _ in range(m)]
answer=0

def DFS(x,y):
    
    if x==n-1 and y==m-1:
        return 1
    if mem[y][x]!=-1:
        return mem[y][x]
    else:
        mem[y][x] = 0
        for i in range(4):
            nexty=y+dy[i]
            nextx=x+dx[i]
            if 0<=nexty<m and 0<=nextx<n and arr[nexty][nextx]<arr[y][x]:
                mem[y][x]+=DFS(nextx,nexty)
        return mem[y][x]
print(DFS(0,0))
'''
4 4

16 9 8 1

15 10 7 2

14 11 6 3

13 12 5 4
'''