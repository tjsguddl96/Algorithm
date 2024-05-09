import java.io.*;
import java.util.*;
public class Main {
    static int N,K;
    static class Item implements Comparable<Item>{
        int w;
        int v;
        public Item(int w,int v){
            this.w=w;
            this.v=v;
        }
        @Override
        public int compareTo(Item o){
            return this.w-o.w;
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
        dp=new int[N+1][K+1];
        items[0]=new Item(0,0);
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            int w=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            items[i]=new Item(w,v);
        }
        for(int i=1;i<N+1;i++){
            Item now=items[i];
            for(int j=1;j<K+1;j++){
                if(j-now.w>=0) {
                    dp[i][j] = Math.max(dp[i - 1][j], now.v + dp[i - 1][j - now.w]);
                }
                else{
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[N][K]);



    }
}