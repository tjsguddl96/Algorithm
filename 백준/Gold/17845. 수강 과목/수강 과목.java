import java.util.*;
import java.io.*;
public class Main {
    static int N,K;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[K+1][2]; //[0]:중요도 [1]:공부시간
        dp=new int[K+1][N+1]; //dp[idx][시간]=중요도
        for(int i=1;i<K+1;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[i][0]=a;
            arr[i][1]=b;
        }
        for(int i=1;i<K+1;i++){
            for(int j=0;j<N+1;j++){
                if(j>=arr[i][1]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-arr[i][1]]+arr[i][0]);
                }
                dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
            }
        }
        System.out.println(dp[K][N]);
    }
}