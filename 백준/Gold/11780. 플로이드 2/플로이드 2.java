import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static class Node{
        int n;
        int w;
        public Node(int n,int w){
            this.n=n;
            this.w=w;
        }
    }
    static long[][] dist;
    static ArrayList<Integer>[][] route;
    static class Route implements Comparable<Route>{
        int n;
        long d;
        ArrayList<Integer> r;
        public Route(int n,long d,ArrayList<Integer> r){
            this.n=n;
            this.d=d;
            this.r=r;
        }
        @Override
        public int compareTo(Route o){
            long x=this.d-o.d;
            if(x>0){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
    static ArrayList<Node>[] routes;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        n=Integer.parseInt(bf.readLine());
        m=Integer.parseInt(bf.readLine());
        routes=new ArrayList[n+1];
        route=new ArrayList[n+1][n+1];
        dist=new long[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                dist[i][j]=Long.MAX_VALUE;
                route[i][j]=new ArrayList<>();
            }
        }
        for(int i=1;i<n+1;i++){
            routes[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            routes[n1].add(new Node(n2,w));
        }
        for(int i=1;i<n+1;i++){
            djkstra(i);
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(dist[i][j]==Long.MAX_VALUE){
                    dist[i][j]=0;
                }
                answer.append(dist[i][j]+" ");
            }
            answer.append("\n");
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                answer.append(route[i][j].size()+" ");
                for(int k=0;k<route[i][j].size();k++){
                    answer.append(route[i][j].get(k)+" ");
                }
                answer.append("\n");
            }
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
    public static void djkstra(int start){
        PriorityQueue<Route> pq=new PriorityQueue<>();
        ArrayList<Integer> rou=new ArrayList<>();
        rou.add(start);
        pq.add(new Route(start,0L,rou));
        dist[start][start]=0L;
        while(!pq.isEmpty()){
            Route now=pq.poll();
            int nowNode=now.n;
            long nowDist=now.d;
            ArrayList<Integer> nowR=new ArrayList<>();
            for(int i=0;i<now.r.size();i++){
                nowR.add(now.r.get(i));
            }
            for(int i=0;i<routes[nowNode].size();i++){
                Node next=routes[nowNode].get(i);
                int nextNode=next.n;
                long nextDist=nowDist+next.w;
                if(dist[start][nextNode]>nextDist){
                    dist[start][nextNode]=nextDist;
                    ArrayList<Integer> nextR=new ArrayList<>();
                    for(int j=0;j<nowR.size();j++){
                        nextR.add(nowR.get(j));
                    }
                    nextR.add(nextNode);
                    route[start][nextNode]=nextR;
                    pq.add(new Route(nextNode,nextDist,nextR));
                }
            }
        }
    }
}