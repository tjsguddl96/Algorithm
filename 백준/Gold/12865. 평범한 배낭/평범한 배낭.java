import java.util.*;
import java.io.*;

public class Main {
    static int N,K;
    static class Item{
        int w;
        int v;
        public Item(int w,int v){
            this.w=w;
            this.v=v;
        }
    }
    static Item[] items;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        items=new Item[N+1];
        dp=new int[N+1][100001];
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            int w=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            items[i]=new Item(w,v);
        }

        for(int i=1;i<N+1;i++){
            Item now=items[i];
            int nowV=items[i].v;
            int nowW=items[i].w;
            dp[i][nowW]=Math.max(nowV,dp[i][nowV]);
            for(int j=0;j<=K;j++){
                if(nowW+j<=K){
                    dp[i][nowW+j]=Math.max(dp[i][nowW+j],dp[i-1][j]+nowV);
                }
                dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
            }
        }
        int max=0;
        for(int i=0;i<=K;i++){
            if(max<dp[N][i]){
                max=dp[N][i];
            }
        }
        System.out.println(max);
    }
}