import java.util.*;
import java.io.*;

public class Main {
    static class Station{
        int x;
        int y;
        public Station(int x,int y){
            this.x=x;
            this.y=y;
        }
        @Override
        public String toString(){
            return x+", "+y;
        }
    }
    static class Distance implements Comparable<Distance>{
        int n;
        double dist;
        public Distance(int n,double dist){
            this.n=n;
            this.dist=dist;
        }
        @Override
        public int compareTo(Distance o){
            return (int)(this.dist-o.dist);
        }
    }
    static Station[] stations;
    static double[] dist;
    static ArrayList<Integer>[] stationList;
    static int N,W;
    static double M;
    static int[] res=new int[2];
    static int[][] tmp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        stations=new Station[N+1];
        dist=new double[N+1];
        tmp=new int[N+1][N+1];
        stationList=new ArrayList[N+1];
        M=Double.parseDouble(bf.readLine());
        for(int i=1;i<N+1;i++){
            dist[i]=9999999999.0;
        }
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            stations[i]=new Station(x,y);
            stationList[i]=new ArrayList<>();
        }
        for(int i=0;i<W;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            stationList[n1].add(n2);
            stationList[n2].add(n1);
            tmp[n1][n2]=1;
            tmp[n2][n1]=1;
        }
        combination(0,1);
        djkstra();
        System.out.println((int)(dist[N]*1000));

    }
    public static void djkstra(){

        PriorityQueue<Distance> pq=new PriorityQueue<>();
        dist[1]=0;
        pq.add(new Distance(1,dist[1]));
        while(!pq.isEmpty()){
            Distance now=pq.poll();
            int nowNode=now.n;
            for(int i=0;i<stationList[nowNode].size();i++){
                int next=stationList[nowNode].get(i);
                double nextD=getDistance(stations[nowNode],stations[next]);
                if(tmp[nowNode][next]==1 || tmp[next][nowNode]==1){
                    nextD=0.0;
                }
                if(dist[next]>dist[nowNode]+nextD){
                    dist[next]=dist[nowNode]+nextD;
                    pq.add(new Distance(next,dist[next]));
                }
            }
        }
    }
    public static void combination(int cnt,int start){
        if(cnt==2){
            Station s1=stations[res[0]];
            Station s2=stations[res[1]];
            double distance=getDistance(s1,s2);
            if(distance<=M && !(stationList[res[0]].contains(res[1]))){
                stationList[res[0]].add(res[1]);
                stationList[res[1]].add(res[0]);
            }
            return ;
        }
        for(int i=start;i<N+1;i++){
            res[cnt]=i;
            combination(cnt+1,i+1);
        }
    }


    public static double getDistance(Station s1,Station s2){
        double X=Math.pow(s1.x-s2.x,2);
        double Y=Math.pow(s1.y-s2.y,2);
        return Math.sqrt(X+Y);
    }
}