import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        dp=new int[N+1][3][4]; //[day][지각수][결석수]
        for(int i=0;i<N+1;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<4;k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        System.out.println(solve(1,0,0,0));
    }
    public static int solve(int day,int o,int l,int a){
        if(day==N+1){
            if(l>=2){
                return 0;
            }
            if(a>=3){
                return 0;
            }

            return 1;
        }
        if(dp[day][l][a]!=-1){
            return dp[day][l][a]%1000000;
        }
        else {
            int tmp=0;
            tmp=solve(day+1,o+1,l,0);
            if(l<1){
                tmp+=solve(day+1,o,l+1,0);
            }
            if(a<2){
                tmp+=solve(day+1,o,l,a+1);
            }

            dp[day][l][a] = tmp;
        }

        return dp[day][l][a]%1000000;
    }
}