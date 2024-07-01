import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[] m;
    static int[] c;
    static int answer=Integer.MAX_VALUE;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        m=new int[N];
        c=new int[N];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            m[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine());
        int sum=0;
        for(int i=0;i<N;i++){
            c[i]=Integer.parseInt(st.nextToken());
            if(m[i]>=M){
                answer=Math.min(answer,c[i]);
            }
            sum+=c[i];
        }
        dp=new int[N][sum+1];
        dp[0][c[0]]=m[0];
        for(int i=1;i<N;i++){
            for(int j=0;j<sum+1;j++){
                if(j<c[i]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
                    continue;
                }
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-c[i]]+m[i]);
                if(dp[i][j]>=M){
                    answer=Math.min(answer,j);
                }
            }
        }
        System.out.println(answer);
    }
}
/*
3 10
20 30 20
1 20 10
* */