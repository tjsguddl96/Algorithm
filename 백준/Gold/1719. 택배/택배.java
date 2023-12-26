import java.util.*;
import java.io.*;
//다익스트라로... 가보자

public class Main {
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
    static int n,m;
    static int[][] answer;
    static int[] dist;
    static ArrayList<Node>[] nodes;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        answer=new int[n+1][n+1];
        dist=new int[n+1];
        nodes=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            nodes[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            nodes[n1].add(new Node(n2,d));
            nodes[n2].add(new Node(n1,d));
        }

        for(int i=1;i<n+1;i++){
            djkstra(i);
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(answer[i][j]==0){
                    System.out.print("- ");
                }
                else {
                    System.out.print(answer[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    static public void djkstra(int start){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int i=1;i<n+1;i++){
            dist[i]=999999999;
        }
        dist[start]=0;
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowNode=now.n;
            for(int i=0;i<nodes[nowNode].size();i++){
                int next=nodes[nowNode].get(i).n;
                int nextD=nodes[nowNode].get(i).d;
                if(dist[next]>dist[nowNode]+nextD){
                    dist[next]=dist[nowNode]+nextD;
                    if(nowNode==start){
                        answer[start][next]=next;
                    }else{
                        answer[start][next]=find(next,nowNode,start);
                    }
                    pq.add(new Node(next,dist[next]));
                }
            }
        }

    }
    static public int find(int now,int prev,int start){
        if(answer[start][prev]!=0){
            return answer[start][prev];
        }
        return find(now,answer[start][prev],start);
    }
}