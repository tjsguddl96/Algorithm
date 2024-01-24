import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static class Bus implements Comparable<Bus>{
        int dest;
        int price;
        public Bus(int dest,int price){
            this.dest=dest;
            this.price=price;
        }
        @Override
        public int compareTo(Bus o){
            return this.price-o.price;
        }
    }
    static ArrayList<Bus>[] buses;
    static int start,end;
    static int[] dist;
    static int INF=999999999;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        dist=new int[N+1];
        M=Integer.parseInt(bf.readLine());
        StringTokenizer st;
        buses=new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            buses[i]=new ArrayList<>();
            dist[i]=INF;
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int start=Integer.parseInt(st.nextToken());
            int dest=Integer.parseInt(st.nextToken());
            int price=Integer.parseInt(st.nextToken());
            buses[start].add(new Bus(dest,price));
        }
        st=new StringTokenizer(bf.readLine());
        start=Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());
        dist[start]=0;
        for(int i=0;i<buses[start].size();i++){
            int bus=buses[start].get(i).dest;
            if(bus==end){
                dist[end]=buses[start].get(i).price;
                break;
            }
        }
        djkstra(start);
        System.out.println(dist[end]);
    }
    public static void djkstra(int start){
        PriorityQueue<Bus> q=new PriorityQueue<>();
        q.add(new Bus(start,0));
        while(!q.isEmpty()){
            Bus nowBus=q.poll();
            int bus=nowBus.dest;
            int price=nowBus.price;
            if(price>dist[end]){
                continue;
            }
            for(int i=0;i<buses[bus].size();i++){
                Bus nextBus=buses[bus].get(i);
                int next=nextBus.dest;
                int nextPrice=nextBus.price;
                if(dist[next]>price+nextPrice){
                    dist[next]=price+nextPrice;
                    q.add(new Bus(next,dist[next]));
                }
            }
        }
    }

}