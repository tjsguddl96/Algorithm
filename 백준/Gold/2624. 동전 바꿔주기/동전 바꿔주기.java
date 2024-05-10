import java.io.*;
import java.util.*;

public class Main {
    static int T,k;
    static class Coin implements Comparable<Coin>{
        int p;
        int n;
        public Coin(int p,int n){
            this.p=p;
            this.n=n;
        }
        @Override
        public int compareTo(Coin o){
            return this.p-o.p;
        }
    }
    static int[][] dp;
    static Coin[] coins;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T=Integer.parseInt(bf.readLine());
        k=Integer.parseInt(bf.readLine());
        dp=new int[k+1][T+1];
        coins=new Coin[k+1];
        coins[0]=new Coin(0,0);
        for(int i=1;i<k+1;i++){
            st=new StringTokenizer(bf.readLine());
            coins[i]=new Coin(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(coins);
//        for(int i=1;i<T+1;i++){
//            dp[0][i]=1;
//        }
        dp[0][0]=1;
        for(int i=1;i<k+1;i++){
            int coin=coins[i].p;
            int n=coins[i].n;
            dp[i-1][0]=1;
            for(int cnt=1;cnt<=n;cnt++) {
                for (int j = coin*cnt; j < T+1; j++) {
                    dp[i][j]+=dp[i-1][j-(coin*cnt)];
                }
            }
            for(int j=1;j<T+1;j++){
                dp[i][j]+=dp[i-1][j];
            }
        }
        System.out.println(dp[k][T]);
    }
}