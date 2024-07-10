import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] wine;
    static int[][] dp;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        wine=new int[N+1];
        dp=new int[N+1][3];
        for(int i=1;i<N+1;i++){
            wine[i]=Integer.parseInt(bf.readLine());
        }
        dp[1][0]=wine[1];
        dp[1][1]=wine[1];
        dp[1][2]=wine[1];
        answer=wine[1];
        for(int i=2;i<N+1;i++){
            int now=wine[i];
            dp[i][0]=Math.max(dp[i-2][0]+now,dp[i-2][1]+now);
            dp[i][0]=Math.max(dp[i][0],dp[i-2][2]+now);

            dp[i][1]=Math.max(dp[i-1][0]+now,dp[i][1]);

            dp[i][2]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][2]=Math.max(dp[i][2],dp[i-1][2]);


            answer=Math.max(answer,dp[i][0]);
            answer=Math.max(answer,dp[i][1]);
            answer=Math.max(answer,dp[i][2]);
        }

        System.out.println(answer);


    }
}
/*
6
6
10
13
9
8
30
* */