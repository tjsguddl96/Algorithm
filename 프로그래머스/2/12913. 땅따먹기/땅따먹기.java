class Solution {
    static int N;
    static int[][] dp;
    int solution(int[][] land) {
        int answer = 0;
        N=land.length;
        dp=new int[N][4];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<4;j++){
                dp[i][j]=-1;
            }
        }
        answer=Math.max(answer,solve(0,0,land));
        answer=Math.max(answer,solve(0,1,land));
        answer=Math.max(answer,solve(0,2,land));
        answer=Math.max(answer,solve(0,3,land));
        return answer;
    }
    
    public static int solve(int cnt,int idx,int land[][]){
        if(cnt==N-1){
            dp[cnt][idx]=land[cnt][idx];
            return dp[cnt][idx];
        }
        if(dp[cnt][idx]!=-1){
            return dp[cnt][idx];
        }
        for(int i=0;i<4;i++){
            if(i!=idx){
                
                dp[cnt][idx]=Math.max(dp[cnt][idx],land[cnt][idx]+solve(cnt+1,i,land));
            }
        }
        return dp[cnt][idx];
    }
}