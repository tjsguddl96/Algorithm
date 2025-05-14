import java.io.*;
import java.util.*;
public class Main {
    static int INF=Integer.MAX_VALUE;
    static int N,M,K,X; //도시갯수, 도로갯수, 거리정보,출발도시
    //최단거리가 K인 도시를 오름차순
    static int[] dist;
    static class Road implements Comparable<Road>{
        int n;
        int d;
        public Road(int n,int d){
            this.n=n;
            this.d=d;
        }
        @Override
        public int compareTo(Road o){
            return this.d-o.d;
        }
    }
    static ArrayList<Integer>[] roads;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        dist=new int[N+1];
        roads=new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            roads[i]=new ArrayList<>();
            dist[i]=INF;
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            roads[n1].add(n2);
        }
        djkstra(X);
        PriorityQueue<Integer> ans=new PriorityQueue<>();
        for(int i=0;i<N+1;i++){
            if(dist[i]==K){
                ans.add(i);
            }
        }
        if(ans.isEmpty()){
            answer.append("-1");
        }
        else {
            while (!ans.isEmpty()) {
                answer.append(ans.poll() + "\n");
            }
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
    public static void djkstra(int start){
        PriorityQueue<Road> pq=new PriorityQueue<>();
        pq.add(new Road(start,0));
        dist[start]=0;
        while(!pq.isEmpty()){
            Road now=pq.poll();
            int nowNode=now.n;
            int nowDist=now.d;
            if(dist[nowNode]<nowDist){
                continue;
            }
            for(int i=0;i<roads[nowNode].size();i++){
                int next=roads[nowNode].get(i);
                if(dist[next]>nowDist+1){
                    dist[next]=nowDist+1;
                    pq.add(new Road(next,nowDist+1));
                }
            }

        }
    }


}

/*

* */
