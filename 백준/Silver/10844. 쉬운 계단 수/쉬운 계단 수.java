import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int MOD=1000000000;
    static long[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(bf.readLine());
//        N=1;
        dp=new long[N+1][10];
        for(int i=0;i<N+1;i++){
            for(int j=0;j<10;j++){
                dp[i][j]=-1;
            }
        }
        long tmp=0;
        for(int i=1;i<10;i++){
            tmp+=(solve(1,i)%MOD);
        }
        System.out.println(tmp%MOD);
    }

    public static long solve(int idx,int num){
        if(idx==N){
            dp[idx][num]=1;
            return dp[idx][num];
        }
        if(dp[idx][num]!=-1){
            return dp[idx][num];
        }
        long tmp=0;
//        if(idx==0){
//            for(int i=1;i<10;i++) {
//                tmp += (solve(idx + 1, i) % MOD);
//            }
//        }
//        else {
            if (num > 0) {
                tmp += (solve(idx + 1, num - 1) % MOD);
            }
            if (num < 9) {
                tmp += (solve(idx + 1, num + 1) % MOD);
            }
//        }
        dp[idx][num]=tmp%MOD;
        return dp[idx][num]%MOD;
    }

}

/*




->



*/
