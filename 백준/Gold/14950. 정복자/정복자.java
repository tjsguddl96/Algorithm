import java.io.*;
import java.util.*;

public class Main {
    static int N,M,t;
    static int[] ch;
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
    static ArrayList<Route>[] route;
    static PriorityQueue<Route> pq=new PriorityQueue<>();
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());              
        ch=new int[N+1];
        route=new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            route[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            route[n1].add(new Route(n2,d));
            route[n2].add(new Route(n1,d));
        }
        for(int i=0;i<route[1].size();i++){
            pq.add(route[1].get(i));
        }
        bfs();
        System.out.println(answer);
    }
    public static void bfs(){
        ch[1]=1;
        int cnt=0;
        while(!pq.isEmpty()){
            Route now=pq.poll();
            int nowNode=now.n;
            int nowDist=now.d;
            if(ch[nowNode]==1){
                continue;
            }
            answer+=(nowDist+cnt*t);
            cnt++;
            ch[nowNode]=1;
            for(int i=0;i<route[nowNode].size();i++){
                Route next=route[nowNode].get(i);
                int nextNode=next.n;
                int nextDist=next.d;
                if(ch[nextNode]==0){
                    pq.add(new Route(nextNode,nextDist));
                }
            }
        }
    }
    
}