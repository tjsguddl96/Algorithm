import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[] weight;
    static int[] marble;
    static int[][] dp;
    static int max=30*500+1;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        N=Integer.parseInt(bf.readLine());
        weight=new int[N+1];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        dp=new int[N+1][max];
        for(int i=1;i<N+1;i++){
            weight[i]=Integer.parseInt(st.nextToken());
            dp[i][weight[i]]=1;
        }

        M=Integer.parseInt(bf.readLine());
        marble=new int[M+1];
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<M+1;i++){
            marble[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N+1;i++) {
            for (int j = 1; j < max; j++) {
                if (j < weight[i]) {
                    dp[i][j]=Math.max(dp[i-1][weight[i]-j],dp[i-1][j]);
                }
                else if(j>weight[i]) {
                    dp[i][j] = dp[i - 1][j - weight[i]];
                    dp[i][j - weight[i]] = Math.max(dp[i - 1][j],dp[i][j-weight[i]]);
                }
            }
        }


        for(int i=1;i<M+1;i++){
            if(marble[i]>=max){
                answer.append("N ");
            }
            else if(dp[N][marble[i]]==1){
                answer.append("Y ");
            }
            else{
                answer.append("N ");
            }
        }
        System.out.println(answer);
    }
}
/*
4
2 3 3 8
3
1 4 7

3
20 35 50
2
5 15

4
5 5 5 5
4
1 20 4 10

* */