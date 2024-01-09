import java.util.*;
import java.io.*;

public class Main {
    //플로이드와샬? ->O(10^9) 시간복잡도 갖음 => 안될듯
    //다익스트라?
    static int N,M,X;
    static int INF=999999999;
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
    static ArrayList<Node>[] arr;
//    static int[] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            arr[n1].add(new Node(n2,d));
        }
        int answer=0;
        int[] fromTwo=new int[N+1];
        for(int i=1;i<N+1;i++){
            fromTwo[i]=INF;
        }
        djkstra(X,fromTwo);
        for(int i=1;i<N+1;i++){
            if(i==X){
                continue;
            }
            int[] fromEvery=new int[N+1];
            for(int j=0;j<N+1;j++){
                fromEvery[j]=INF;
            }
            djkstra(i,fromEvery);
            answer=Math.max(answer,fromTwo[i]+fromEvery[X]);
        }
        System.out.println(answer);
    }
    public static void djkstra(int start,int[] dist){
         PriorityQueue<Node> pq=new PriorityQueue<>();
         pq.add(new Node(start,0));
         dist[start]=0;
         while(!pq.isEmpty()){
             Node now=pq.poll();
             int nowNode=now.n;
             for(int i=0;i<arr[nowNode].size();i++){
                 Node next=arr[nowNode].get(i);
                 int nextNode=next.n;
                 int nextD=next.d;
                 if(dist[nextNode]>dist[nowNode]+nextD){
                     dist[nextNode]=dist[nowNode]+nextD;
                     pq.add(new Node(nextNode,dist[nextNode]));
                 }
             }
         }
    }

}