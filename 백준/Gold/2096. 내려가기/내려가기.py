from sys import stdin

n=int(stdin.readline())
dpMax=[0]*3
inf=999999999
dpMin=[inf]*3
arr=list(map(int,stdin.readline().split()))
for j in range(3):
    dpMax[j]=arr[j]
    dpMin[j]=arr[j]

for k in range(1,n):

    arr = list(map(int, stdin.readline().split()))

    tmp1=max(dpMax[0]+arr[0],dpMax[1]+arr[0])
    tp1=min(dpMin[0]+arr[0],dpMin[1]+arr[0])
    tmp2=max(max(dpMax[0]+arr[1],dpMax[1]+arr[1]),dpMax[2]+arr[1])
    tp2 = min(min(dpMin[0] + arr[1], dpMin[1] + arr[1]), dpMin[2] + arr[1])

    tmp3=max(dpMax[2]+arr[2],dpMax[1]+arr[2])
    tp3 = min(dpMin[2] + arr[2], dpMin[1] + arr[2])
    dpMax[0]=tmp1
    dpMax[1]=tmp2
    dpMax[2]=tmp3
    dpMin[0]=tp1
    dpMin[1]=tp2
    dpMin[2]=tp3

print(max(dpMax),min(dpMin))
