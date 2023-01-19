from collections import deque

def dicemove(dice,direction):
    if direction==1 : #동
        tmp1=dice[3][1]
        tmp2=dice[1][0]
        for i in range(2):
            dice[1][i]=dice[1][i+1]
        dice[1][2]=tmp1
        dice[3][1]=tmp2
    elif direction==2: #서
        tmp1=dice[1][2]
        tmp2=dice[3][1]
        for i in range(2,0,-1):
            dice[1][i]=dice[1][i-1]
        dice[3][1]=tmp1
        dice[1][0]=tmp2
    elif direction==3: #북
        tmp=deque()
        for i in range(3):
            tmp.append(dice[i][1])
        tmp.appendleft(dice[3][1])
        for i in range(4):
            dice[i][1]=tmp.popleft()
    else:
        tmp = deque()
        for i in range(1,4):
            tmp.append(dice[i][1])
        tmp.append(dice[0][1])
        for i in range(4):
            dice[i][1] = tmp.popleft()

n,m,x,y,k=map(int,input().split())

board=[list(map(int,input().split())) for _ in range(n)]

d=[[0,0],[0,1],[0,-1],[-1,0],[1,0]]
dice=[[0]*3 for _ in range(4)]
#dice=[[0,2,0],[4,6,3],[0,5,0],[0,1,0]]  #밑면은 dice[1][1]이 밑면이다 윗면은 dice[3][1]이다.

dirQ=deque(list(map(int,input().split())))

nowX,nowY=x,y

if board[x][y]==0:
    tmp=dice[1][1]
    board[x][y]=tmp
else:
    tmp=board[x][y]
    board[x][y]=0
    dice[1][1]=tmp

while(dirQ):
    dir=dirQ.popleft()
    nowX+=d[dir][0]
    nowY+=d[dir][1]

    if 0<=nowX<n and 0<=nowY<m:

        dicemove(dice,dir)

        if board[nowX][nowY]==0:
            tmp=dice[1][1]
            board[nowX][nowY]=tmp

        else:
            tmp=board[nowX][nowY]
            board[nowX][nowY]=0
            dice[1][1]=tmp

        print(dice[3][1])
    else:
        nowX-=d[dir][0]
        nowY-=d[dir][1]

'''
4 2 0 0 3
0 2
3 4
5 6
7 8
4 4 4 

'''