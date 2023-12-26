import java.io.*;
import java.util.*;

public class Main {
    static int n,m,r; //n:place갯수, m:예은이수색범위, r:길의갯수
    static class Place implements Comparable<Place>{
        int n;
        int dist;
        public Place(int n,int dist){
            this.n=n;
            this.dist=dist;
        }
        @Override
        public int compareTo(Place o){
            int x=this.dist-o.dist;
            if(x==0){
                x=this.n-o.n;
            }
            return x;
        }
    }
    static int[] dist;
    static int answer;
    static int answerStart;
    static int[] placesItem;
    static ArrayList<Place>[] places;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        placesItem=new int[n+1];
        dist=new int[n+1];
        places=new ArrayList[n+1];
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<n+1;i++){
            places[i]=new ArrayList<>();
            placesItem[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<r;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            places[n1].add(new Place(n2,d));
            places[n2].add(new Place(n1,d));
        }
        for(int i=1;i<n+1;i++){
            djkstra(i);
        }

        System.out.println(answer);

    }
    public static void djkstra(int start){
        for(int i=1;i<n+1;i++){
            dist[i]=999999999;
        }
        PriorityQueue<Place> pq=new PriorityQueue<>();
        dist[start]=0;
        pq.add(new Place(start,0));
        int itemSum=0;
        while(!pq.isEmpty()){
            Place nowPlace=pq.poll();
            int now=nowPlace.n;
            for(int i=0;i<places[now].size();i++){
                int next=places[now].get(i).n;
                int nextDist=places[now].get(i).dist;
                if(dist[next]>=dist[now]+nextDist){
                    dist[next]=dist[now]+nextDist;
                    pq.add(new Place(next,dist[next]));
                }
            }
        }
        for(int i=1;i<n+1;i++){
            if(dist[i]<=m){
                itemSum+=placesItem[i];
            }
        }

        if(answer<itemSum){
            answer=itemSum;
        }
    }

}
/*
7 7 7
1 2 3 4 5 6 7
1 2 1
1 4 3
2 3 4
3 5 1
5 6 1
5 7 1
6 7 1

5 5 6
5 7 8 2 3
1 4 5
5 2 4
3 2 3
1 2 3
2 4 1
5 4 1

5 5 4
5 7 8 2 3
1 4 5
3 2 3
1 2 3
5 4 1

4 3 4
1 2 3 4
1 2 2
1 3 3
4 1 4
2 4 1
* */