
class Solution {
    static int[][] dp;
    static int N;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        N=numbers.length;
        dp=new int[N+1][3000];
        for(int i=0;i<N+1;i++){
            for(int j=0;j<3000;j++){
                dp[i][j]=-1;
            }
        }
        answer=solve(0,0,0,target,numbers);
        System.out.println(dp[1][1001]);
        return answer;
    }
    public static int solve(int cnt,int idx,int now,int target,int[] numbers){
        if(cnt==N){
            if(now==target){
                dp[cnt][idx]=1;
                return 1;
            }
            dp[cnt][idx]=0;
            return 0;
        }
        if(dp[cnt][idx]!=-1){
            return dp[cnt][idx];
        }
        int next1=now+numbers[cnt];
        int nextIdx1=next1;
        if(next1<0){
            nextIdx1=next1*(-1)+1000;
        }
        int next2=now-numbers[cnt];
        int nextIdx2=next2;
        if(next2<0){
            nextIdx2=next2*(-1)+1000;
        }
        int tmp=solve(cnt+1,nextIdx1,next1,target,numbers)+solve(cnt+1,nextIdx2,next2,target,numbers);
        dp[cnt][idx]=tmp;
        return dp[cnt][idx];
        
    }
}