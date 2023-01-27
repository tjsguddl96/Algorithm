from collections import Counter

def check(now,next):
    if len(now)>=len(next):
        return False
    tmp=Counter(next)-Counter(now)
    idx=-1
    if len(tmp)==1:
        for i in range(len(next)-1):
            if now[i]!=next[i]:
                if now[i:]==next[i+1:]:
                    return True
                else:
                    return False
        return True
    return False

def DFS(now,word,ch):
    global ans

    if (len(now)>len(ans)):
        ans=now

    for i in range(len(word)):
        if (ch[i]==0 and (len(word[i])==len(now)+1) and check(now,word[i])==True):
            ch[i]=1
            DFS(word[i],word,ch)

d,principal=map(str,input().split())

d=int(d)
ans=""
word=[""]*d
ch=[0]*d
for i in range(d):
    w=input()
    word[i]=w

DFS(principal,word,ch)
print(ans)