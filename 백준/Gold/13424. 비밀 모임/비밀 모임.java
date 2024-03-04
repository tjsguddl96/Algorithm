import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static int N,M;
    static ArrayList<Route>[] route;
    static int dist[][];
    static int k[];
    static int INF=Integer.MAX_VALUE;
    static int K;
    static class Route implements Comparable<Route>{
        int n;
        int d;
        public Route(int n,int d){
            this.n=n;
            this.d=d;
        }
        @Override
        public int compareTo(Route o){
            return this.d-o.d;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st=new StringTokenizer(bf.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            route=new ArrayList[N+1];
            dist=new int[N+1][N+1];
            for(int i=1;i<N+1;i++){
                route[i]=new ArrayList<>();
                for(int j=1;j<N+1;j++){
                    dist[i][j]=INF;
                }
            }
            for(int i=0;i<M;i++){
                st=new StringTokenizer(bf.readLine());
                int n1=Integer.parseInt(st.nextToken());
                int n2=Integer.parseInt(st.nextToken());
                int d=Integer.parseInt(st.nextToken());
                route[n1].add(new Route(n2,d));
                route[n2].add(new Route(n1,d));
            }
            K=Integer.parseInt(bf.readLine());
            k=new int[K];
            st=new StringTokenizer(bf.readLine());
            for(int i=0;i<K;i++){
                k[i]=Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<K;i++){
                djkstra(k[i]);
            }
            int min=INF;
            int ans=-1;
            for(int i=1;i<N+1;i++){
                int tmp=0;
                for(int j=1;j<N+1;j++){
                    if(dist[j][i]!=INF){
                        tmp+=dist[j][i];
                    }
                }
                if(min>tmp){
                    min=tmp;
                    ans=i;
                }
            }
            answer.append(ans+"\n");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
    public static void djkstra(int start){
        PriorityQueue<Route> pq=new PriorityQueue<>();
        pq.add(new Route(start,0));
        dist[start][start]=0;
        while(!pq.isEmpty()){
            Route now=pq.poll();
            int nowNode=now.n;
            int nowDist=now.d;
            for(int i=0;i<route[nowNode].size();i++){
                Route next=route[nowNode].get(i);
                int nextNode=next.n;
                int nextDist=next.d;
                if(dist[start][nextNode]>nowDist+nextDist){
                    dist[start][nextNode]=nowDist+nextDist;
                    pq.add(new Route(nextNode,dist[start][nextNode]));
                }
            }
        }
    }
}
/*
1
6 7
1 2 4
1 3 1
1 5 2
2 3 2
3 4 3
4 5 2
6 5 1
2
3 5
* */