import java.util.*;
import java.io.*;
public class Main {
    static int F,S,G,U,D;
    static int[] dp;
    static class Node implements Comparable<Node>{
        int n;
        int d;
        public Node(int n,int d){
            this.n=n;
            this.d=d;
        }
        @Override
        public int compareTo(Node o){
            return this.d-o.d;
        }
    }
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        F=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());
        G=Integer.parseInt(st.nextToken());
        U=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());
        dp=new int[F+1];
        for(int i=0;i<F+1;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        dp[S]=0;
        pq.add(new Node(S,0));
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowF=now.n;
            int nowD=now.d;
            if(dp[nowF]<nowD){
                continue;
            }
            if(nowF+U<=F && dp[nowF+U]>nowD+1){
                dp[nowF+U]=nowD+1;
                pq.add(new Node(nowF+U,nowD+1));
            }
            if(nowF-D>=1 && dp[nowF-D]>nowD+1){
                dp[nowF-D]=nowD+1;
                pq.add(new Node(nowF-D,nowD+1));
            }

        }
        if(dp[G]==Integer.MAX_VALUE){
            System.out.println("use the stairs");
        }
        else {
            System.out.println(dp[G]);
        }

    }
}