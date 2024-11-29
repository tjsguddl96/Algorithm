import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        dp=new long[91];
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<N+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println(dp[N]);
    }
}