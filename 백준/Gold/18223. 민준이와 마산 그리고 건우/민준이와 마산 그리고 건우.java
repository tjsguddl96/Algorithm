import java.io.*;
import java.util.*;
public class Main {
    static int V,E,P;
    static ArrayList<Dist>[] edges;
    static int[] dist1;//1->V
    static int[] dist2;//P->1, P->V
    static int INF=Integer.MAX_VALUE;
    static class Dist{
        int n;
        int d;
        public Dist(int n,int d){
            this.n=n;
            this.d=d;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        P=Integer.parseInt(st.nextToken());
        edges=new ArrayList[V+1];
        dist1=new int[V+1];
        dist2=new int[V+1];
        for(int i=1;i<V+1;i++){
            edges[i]=new ArrayList<>();
            dist1[i]=INF;
            dist2[i]=INF;
        }
        for(int i=0;i<E;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            edges[n1].add(new Dist(n2,d));
            edges[n2].add(new Dist(n1,d));
        }
        djkstra(1,dist1);
        djkstra(P,dist2);
        String answer="GOOD BYE";
        if(dist1[V]>=dist2[1]+dist2[V]){
            answer="SAVE HIM";
        }
        System.out.println(answer);
    }
    public static void djkstra(int start,int[] dist){
        ArrayDeque<Dist> q=new ArrayDeque<>();
        dist[start]=0;
        q.add(new Dist(start,0));
        while(!q.isEmpty()){
            Dist now=q.poll();
            int nowNode=now.n;
            int nowD=now.d;
            for(int i=0;i<edges[nowNode].size();i++){
                Dist next=edges[nowNode].get(i);
                int nextNode=next.n;
                int nextD=next.d;
                if(dist[nextNode]>nowD+nextD){
                    q.add(new Dist(nextNode,nowD+nextD));
                    dist[nextNode]=nowD+nextD;
                }
            }
        }
    }
}