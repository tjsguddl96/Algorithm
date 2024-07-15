import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    static int max;
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
            dp[arr[i]]=dp[arr[i]-1]+1;
            max=Math.max(dp[arr[i]],max);
        }
        System.out.println(N-max);
    }
}
/*
7
4 1 3 5 2 6 7
* */