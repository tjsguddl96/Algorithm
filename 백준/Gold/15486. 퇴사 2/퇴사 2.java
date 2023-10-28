import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] d;
    static long[] dp;
    static long max=0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        d=new int[N+2][2];
        dp=new long[N+2];
        for(int i=1;i<N+1;i++){
            StringTokenizer st=new StringTokenizer(bf.readLine());
            int t=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            d[i][0]=t;
            d[i][1]=p;
        }
        for(int i=1;i<N+1;i++){
            int next=i+d[i][0];
            dp[i]=Math.max(dp[i],dp[i-1]);
            if(next<N+2) {
                dp[next] = Math.max(dp[next], dp[i] + d[i][1]);
            }

        }
        max=Math.max(dp[N+1],dp[N]);
        System.out.println(max);
    }
}