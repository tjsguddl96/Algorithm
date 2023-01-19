from collections import deque
import sys
input = sys.stdin.readline
MAX = sys.maxsize
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]


def bfs():
    q = deque()
    q.append((0, 0))
    visit[0][0] = arr[0][0]
    while q:
        x, y = q.popleft()
        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < N and 0 <= ny < N:
                if visit[nx][ny] > visit[x][y] + arr[nx][ny]:
                    visit[nx][ny] = visit[x][y] + arr[nx][ny]
                    q.append((nx, ny))


case = 1
while True:
    N = int(input())
    if N == 0:
        break
    arr = []
    for _ in range(N):
        arr.append(list(map(int, input().split())))
    visit = [[MAX] * N for _ in range(N)]
    bfs()
    print('Problem', case, end='')
    print(":", visit[N-1][N-1])
    case += 1
 