import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[] arr;
    static int[] sum;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        arr=new int[N+1];
        sum=new int[N+1];
        dp=new int[4][N+1];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            sum[i]=sum[i-1]+arr[i];
        }
        M=Integer.parseInt(bf.readLine());
        for(int i=1;i<4;i++){
            for(int j=1;j<N+1;j++){
                if(j-M>=0){
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j-M]+sum[j]-sum[j-M]);
                }
            }
        }
        System.out.println(dp[3][N]);

    }
}