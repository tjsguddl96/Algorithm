import java.io.*;
import java.util.*;

public class Main {
    static int N,E;
    static class Edge{
        int n;
        int d;
        public Edge(int n,int d){
            this.n=n;
            this.d=d;
        }
    }
    static ArrayList<Edge>[] edges;
    static int INF=Integer.MAX_VALUE;
    static int v1,v2;
    static int[][] dist; //0 : 1이 시작, 1:v1이 시작, 2:v2이 시작
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        edges=new ArrayList[N+1];
        dist=new int[3][N+1];
        for(int i=1;i<N+1;i++){
            edges[i]=new ArrayList<>();
            for(int j=0;j<3;j++){
                dist[j][i]=INF;
            }
        }
        for(int i=0;i<E;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            edges[n1].add(new Edge(n2,d));
            edges[n2].add(new Edge(n1,d));
        }
        st=new StringTokenizer(bf.readLine());
        v1=Integer.parseInt(st.nextToken());
        v2=Integer.parseInt(st.nextToken());
        dist[0][1]=0;
        dist[1][v1]=0;
        dist[2][v2]=0;
        djkstra(0);
        djkstra(v1);
        djkstra(v2);
      
        int answer=Math.min(dist[0][v1]+dist[1][v2]+dist[2][N],dist[0][v2]+dist[2][v1]+dist[1][N]);
        if(answer==INF || dist[0][N]==INF|| dist[0][v1]==INF || dist[1][v2]==INF || dist[2][N]==INF || dist[0][v2]==INF || dist[2][v1]==INF || dist[1][N]==INF){
            answer=-1;
        }
        System.out.println(answer);

    }
    public static void djkstra(int start){
        ArrayDeque<Edge> q=new ArrayDeque<>();
        int idx=0;
        if(start==0){
            idx=0;
            q.add(new Edge(1,0));
        }
        else if(start==v1){
            idx=1;
            q.add(new Edge(start,0));
        }
        else if(start==v2){
            idx=2;
            q.add(new Edge(start,0));
        }
        while(!q.isEmpty()){
            Edge now=q.poll();
            int nowNode=now.n;
            int nowD=now.d;
            for(int i=0;i<edges[nowNode].size();i++){
                Edge next=edges[nowNode].get(i);
                int nextNode=next.n;
                int nextD=next.d;
                if(dist[idx][nextNode]>nowD+nextD){
                    dist[idx][nextNode]=nowD+nextD;
                    q.add(new Edge(nextNode,dist[idx][nextNode]));
                }
            }
        }
    }
}
/*
4 3
1 2 3
2 3 3
1 3 5
2 3
* */