import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] dp;
    static int MOD=10007;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        dp=new int[N+1][10];
        for(int i=0;i<N+1;i++){
            for(int j=0;j<10;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(solve(0,0));
    }
    public static int solve(int depth,int now){
        if(depth==N){
            dp[depth][now]=1;
            return dp[depth][now];
        }
        if(dp[depth][now]!=-1){
            return dp[depth][now];
        }
        int tmp=0;
        for(int i=now;i<10;i++){
            tmp+=solve(depth+1,i)%MOD;
        }
        dp[depth][now]=tmp%MOD;
        return dp[depth][now];
    }
}