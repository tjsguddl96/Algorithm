import java.util.*;
import java.io.*;

public class Main {
    static int n,m; //n: 도시 수, m : 노선 수
    static class Edge{
        int st;
        int dest;
        int w;
        public Edge(int st,int dest,int w){
            this.st=st;
            this.dest=dest;
            this.w=w;
        }
    }
    static long dist[];
    static Edge[] edges;
    static boolean isCycle; //true = 마이너스 사이클 발생
    static long INF=Long.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        dist=new long[n+1];
        edges=new Edge[m];
        for(int i=1;i<n+1;i++){
            dist[i]=INF;
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int start=Integer.parseInt(st.nextToken());
            int dest=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            edges[i]=new Edge(start,dest,w);
        }
        bellman(1);
        if(isCycle){
            System.out.println(-1);
        }else{
            for(int i=2;i<n+1;i++){
                if(dist[i]==INF){
                    System.out.println(-1);
                }else {
                    System.out.println(dist[i]);
                }
            }
        }
    }
    public static void bellman(int startNode){
        dist[startNode]=0;
        for(int i=0;i<n;i++){ //마지막 loop는 마이너스 사이클 발생하는지
            for(int j=0;j<m;j++){
                Edge now=edges[j];
                int nowSt=now.st;
                int nowDest=now.dest;
                int nowW=now.w;
                if(dist[nowSt]!=INF && dist[nowDest]>dist[nowSt]+nowW){
                    dist[nowDest]=dist[nowSt]+nowW;
                    if(i==n-1){//마지막 loop는 마이너스 사이클을 발생하는지 판별
                        isCycle=true;
                    }
                }
            }
        }
    }
}