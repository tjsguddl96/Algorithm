import java.util.*;

class Solution {
    static int[] next;
    static long[] fac;
    static int[] answer;
    public int[] solution(int n, long k) {
        answer = new int[n];
        next=new int[n+1];
        fac=new long[n+1];
        fac[0]=1;
        fac[1]=1;
        for(int i=0;i<n+1;i++){
            next[i]=i+1;
        }
        k-=1;
        factorial(n,2);
        for(int i=0;i<n;i++){
            long mok=k/fac[n-i-1];
            k=k%fac[n-i-1];
            recurse(mok,0,next[0],0,i);
        }
        return answer;
    }
    public static void factorial(int n,int cnt){
        if(cnt==n+1){
            return ;
        }
        fac[cnt]=fac[cnt-1]*cnt;
        factorial(n,cnt+1);
    }
    
    
    
    //recurse(targetCnt,0,next[0],0);
    public static void recurse(long targetCnt,long cnt,int now,int prev,int idx){
        if(targetCnt==cnt){
            answer[idx]=now;
            next[prev]=next[now];
            return ;
        }
        recurse(targetCnt,cnt+1,next[now],now,idx);
        
    }
}