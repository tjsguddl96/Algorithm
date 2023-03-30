from collections import deque
import sys
input=sys.stdin.readline
dx=[1,-1,0,0]
dy=[0,0,1,-1]
MAX = sys.maxsize
def bfs():
    q = deque()
    dp[0][0]=arr[0][0]
    q.append((0, 0))
    while (q):
        y, x = q.popleft()
        for i in range(4):
            nexty = y + dy[i]
            nextx = x + dx[i]
            if 0 <= nexty < N and 0 <= nextx < N:
                if dp[y][x] + arr[nexty][nextx]<dp[nexty][nextx]:
                    dp[nexty][nextx] = dp[y][x] + arr[nexty][nextx]
                    q.append((nexty, nextx))

case = 1
while True:
    N = int(input())
    if N == 0:
        break
    arr = []
    for _ in range(N):
        arr.append(list(map(int, input().split())))
    dp = [[MAX] * N for _ in range(N)]
    bfs()
    print('Problem', case, end='')
    print(":", dp[N-1][N-1])
    case +=1