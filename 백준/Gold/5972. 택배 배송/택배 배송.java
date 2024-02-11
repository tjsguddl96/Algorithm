import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static ArrayList<Route>[] route;
    static PriorityQueue<Route> pq=new PriorityQueue<>();
    static int[] dist;
    static class Route implements Comparable<Route>{
        int n;
        int w;
        public Route(int n,int w){
            this.n=n;
            this.w=w;
        }
        @Override
        public int compareTo(Route o){
            return this.w-o.w;
        }
    }
    static int INF=999999999;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        route=new ArrayList[n+1];
        dist=new int[n+1];
        for(int i=1;i<n+1;i++){
            route[i]=new ArrayList<>();
            dist[i]=INF;
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            route[n1].add(new Route(n2,w));
            route[n2].add(new Route(n1,w));
        }
        dist[1]=0;
        pq.add(new Route(1,0));
        while(!pq.isEmpty()){
            Route now=pq.poll();
            int nowN=now.n;
            int nowW=now.w;
            for(int i=0;i<route[nowN].size();i++){
                Route next=route[nowN].get(i);
                int nextN=next.n;
                int nextW=next.w;
                if(dist[nextN]>nowW+nextW){
                    dist[nextN]=nowW+nextW;
                    pq.add(new Route(nextN,dist[nextN]));
                }
            }
        }
        System.out.println(dist[n]);
    }
}