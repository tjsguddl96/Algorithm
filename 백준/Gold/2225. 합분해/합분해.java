import java.util.*;
import java.io.*;
public class Main {
    static int N,K;
    static int MOD=1000000000;
    static long[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        dp=new long[K+1][N+1];
        for(int i=0;i<K+1;i++){
            for(int j=0;j<N+1;j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(solve(0,0)%MOD);
    }
    public static long solve(int idx,int sum){
        if(sum>N){
            return 0;
        }
        if(idx==K){
            if(sum==N){
                dp[idx][sum]=1;
                return 1;
            }
            dp[idx][sum]=0;
            return 0;
        }

        if(dp[idx][sum]!=-1){
            return dp[idx][sum]%=MOD;
        }
        long tmp=0;
        for(int i=0;i<N+1;i++){
            if(sum+i>N){
                continue;
            }
            tmp+=(solve(idx+1,sum+i)%MOD)%MOD;
        }
        dp[idx][sum]=tmp%MOD;

        return dp[idx][sum]%=MOD;
    }
}
/*
[input]
34 34

[answer]
620288370

[wrong]
-89263246

input: 200 200
output: 0
answer: 753387060
* */