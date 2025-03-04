import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] dp;
    static class Elec implements Comparable<Elec>{
        int a;
        int b;
        public Elec(int a,int b){
            this.a=a;
            this.b=b;
        }
        @Override
        public int compareTo(Elec o){
            return this.a-o.a;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Elec> pq=new PriorityQueue<>();
        N=Integer.parseInt(bf.readLine());
        dp=new int[501][501];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            pq.add(new Elec(a,b));
        }
        int max=0;
        while(!pq.isEmpty()){
            Elec now=pq.poll();
            int nowA=now.a;
            int nowB=now.b;
            int tmp=0;
            for(int i=nowA-1;i>0;i--){
                for(int j=nowB-1;j>0;j--){
                    tmp=Math.max(tmp,dp[i][j]);
                }
            }
            dp[nowA][nowB]=tmp+1;
            max=Math.max(max,dp[nowA][nowB]);
        }
        System.out.println(N-max);





    }
}