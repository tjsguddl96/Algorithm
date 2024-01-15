import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int[][] sum;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n=Integer.parseInt(bf.readLine());
        arr=new int[n][n];
        sum=new int[n+1][n+1];
        int ans=-999999999;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                ans=Math.max(arr[i][j],ans);
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+arr[i-1][j-1];
            }
        }

        for(int K=2;K<=n+1;K++){
            for(int i=1;i<=n-K;i++){
                for(int j=1;j<=n-K;j++){
                    ans=Math.max(ans,sum[i+K][j+K]-sum[i+K][j-1]-sum[i-1][j+K]+sum[i-1][j-1]);
                }
            }
        }
        System.out.println(ans);

    }
}