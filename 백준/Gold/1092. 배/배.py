from sys import stdin
n=int(stdin.readline())

crain=sorted(list(map(int,stdin.readline().split())),reverse=True)

m=int(stdin.readline())
box=sorted(list(map(int,stdin.readline().split())),reverse=True)

answer=0

if(crain[0]<box[0]):
    print(-1)
else:
    i=0
    while(len(box)!=0):
        for i in range(len(crain)):
            for j in range(len(box)):
                if(crain[i]>=box[j]):
                    box.pop(j) #j번째 인덱스 삭제
                    break
        answer+=1
    print(answer)