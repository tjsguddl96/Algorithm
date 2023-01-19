import heapq

n=int(input())

arr=[]

for i in range(n):
    num,st,end=map(int,input().split())
    arr.append((num,st,end)) #방번호, 시작시간, 끝시간
arr.sort(key=lambda x:x[1]) #시작 시간 순으로 정렬

taken=[]

ans=1

heapq.heappush(taken,(arr[0][2],arr[0][1],arr[0][0])) #끝나는 시간, 시작 시간

for i in range(1,len(arr)):

    firstEnd,firstSt,num=heapq.heappop(taken)
    heapq.heappush(taken,(firstEnd,firstSt,num))

    if arr[i][1]>=firstEnd: #다음 시작 시간과 taken의 끝나느 시간 비교
        heapq.heappop(taken)
    else:
        ans+=1

    heapq.heappush(taken, (arr[i][2], arr[i][1], arr[i][0]))
print(ans)