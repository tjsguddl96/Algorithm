import java.io.*;
import java.util.*;

public class Main {
    static int V,E,K;
    static int[] dist;
    static class Edge implements Comparable<Edge>{
        int end;
        int d;
        public Edge(int end,int d){
            this.end=end;
            this.d=d;
        }
        @Override
        public int compareTo(Edge o){
            return this.d-o.d;
        }
    }

    static int INF=Integer.MAX_VALUE;
    static ArrayList<Edge>[] edges;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(bf.readLine());
        edges=new ArrayList[V+1];
        for(int i=0;i<V+1;i++){
            edges[i]=new ArrayList<>();
        }
        for(int i=0;i<E;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            edges[a].add(new Edge(b,d));
        }
        dist=new int[V+1];
        for(int i=0;i<V+1;i++){
            if(i!=K) {
                dist[i] = INF;
            }
        }
        bfs();
        StringBuilder answer=new StringBuilder();
        for(int i=1;i<V+1;i++){
            if(dist[i]==INF){
                answer.append("INF\n");
            }
            else{
                answer.append(dist[i]+"\n");
            }
        }
        System.out.println(answer.toString());



    }
    public static void bfs(){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(K,0));
        while(!pq.isEmpty()){
            Edge now=pq.poll();
            int nowNode=now.end;
            int nowD=now.d;
            if(nowNode!=K && dist[nowNode]<nowD){
                continue;
            }
            for(int i=0;i<edges[nowNode].size();i++){
                Edge next=edges[nowNode].get(i);
                int nextNode=next.end;
                int nextD=next.d;
                if(dist[nextNode]>nextD+nowD){
                    dist[nextNode]=nextD+nowD;
                    pq.add(new Edge(nextNode,dist[nextNode]));
                }
            }

        }
    }
}