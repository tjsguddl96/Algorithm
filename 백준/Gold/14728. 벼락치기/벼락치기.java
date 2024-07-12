import java.util.*;
import java.io.*;

public class Main {
    static int N,T;
    static class Part implements Comparable<Part>{
        int k;
        int s;
        public Part(int k,int s){
            this.k=k;
            this.s=s;
        }
        @Override
        public int compareTo(Part o){
            return this.k-o.k;
        }
    }
    static Part[] part;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());
        part=new Part[N+1];
        part[0]=new Part(0,0);
        dp=new int[N+1][T+1];
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            int k=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            part[i]=new Part(k,s);
        }
        Arrays.sort(part);

        for(int i=1;i<N+1;i++){
            Part now=part[i];
            for(int j=1;j<T+1;j++){
                if(j>=now.k){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-now.k]+now.s);
                }
                dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
            }
        }
        System.out.println(dp[N][T]);

    }
}