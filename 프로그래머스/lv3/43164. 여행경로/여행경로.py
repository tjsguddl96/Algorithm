A=[]
flag=0
def DFS(start, end, L, tickets, check,answer):
    global flag
    if L == len(tickets)-1:
        answer[L+1]=end
        A=answer
        if len(A)!=0:
            flag=1
            return

    for i in range(len(tickets)):
        if check[i] == 0 and end == tickets[i][0]:
            answer[L+1]=end
            check[i] = 1
            DFS(tickets[i][0], tickets[i][1], L + 1, tickets, check,answer)
            if flag==1:
                continue
            check[i]=0


def solution(tickets):
    global flag
    tickets.sort()
    answer = [""]*(len(tickets)+1)
    ans=[]
    check = [0] * len(tickets)
    for i in range(len(tickets)):
        flag=0
        st, end = tickets[i]
        if st == "ICN" and check[i] == 0:
            check[i] = 1
            answer[0]=st
            DFS(st, end, 0, tickets, check,answer)
            if flag==1:
                break
            check[i]=0
    return answer

