import java.util.*;
import java.io.*;


public class Main{

    static int N,S,M;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] Args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N+1];
        dp=new int[N+1][M+1];
        for(int i=0;i<N+1;i++){
            for(int j=0;j<M+1;j++){
                dp[i][j]=-1;
            }
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dp[0][S]=S;
        for(int i=1;i<N+1;i++){
            for(int j=0;j<M+1;j++){
                if(j+arr[i]>=0 && j+arr[i]<M+1 && dp[i-1][j+arr[i]]!=-1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j+arr[i]]-arr[i]);
                }
                if(j-arr[i]>=0 && j-arr[i]<M+1 && dp[i-1][j-arr[i]]!=-1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j-arr[i]]+arr[i]);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<M+1;i++){
            max=Math.max(max,dp[N][i]);
        }
        System.out.println(max);


    }

}

/*
4 8 20
15 2 9 10
-> -1

14 40 243
74 39 127 95 63 140 99 96 154 18 137 162 14 88
-> 238

* */