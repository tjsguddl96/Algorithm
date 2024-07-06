import java.util.*;
import java.io.*;
public class Main {
    static int N,answer;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        arr=new int[N+1];
        dp=new int[N+1];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<N+1;i++){
            int now=arr[i];
            int max=0;
            int min=Integer.MAX_VALUE;
            for(int j=i;j>0;j--){
                max=Math.max(max,arr[j]);
                min=Math.min(min,arr[j]);
                int tmp=max-min;
                dp[i]=Math.max(dp[i],dp[j-1]+tmp);
            }
        }
        System.out.println(dp[N]);

    }
}