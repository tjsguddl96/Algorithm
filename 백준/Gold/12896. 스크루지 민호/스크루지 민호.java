import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] bridge;
    static int[] incoming;
    static int[] dist;
    static int INF=Integer.MAX_VALUE;
    static class Dist{
        int n;
        int d;
        public Dist(int n,int d){
            this.n=n;
            this.d=d;
        }
    }
    static ArrayDeque<Dist> q=new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        bridge=new ArrayList[N+1];
        incoming=new int[N+1];
        dist=new int[N+1];
        for(int i=1;i<N+1;i++){
            bridge[i]=new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            bridge[n1].add(n2);
            bridge[n2].add(n1);
            incoming[n1]++;
            incoming[n2]++;
        }
        for(int i=1;i<N+1;i++){
            if(incoming[i]==1){
                incoming[i]--;
                q.add(new Dist(i,0));
            }
        }
        int ans=0;
        while(!q.isEmpty()){
            Dist now=q.poll();
            int nowNode=now.n;
            int nowD=now.d;
            ans=nowNode;
            for(int i=0;i<bridge[nowNode].size();i++){
                int next=bridge[nowNode].get(i);
                incoming[next]--;
                dist[next]=Math.max(dist[next],nowD+1);
                if(incoming[next]==1){
                    q.add(new Dist(next,nowD+1));
                }
            }
        }
        System.out.println(dist[ans]);
    }
}
/*
11
3 5
5 1
1 9
5 4
2 4
6 4
6 7
7 8
10 8
9 11
->4

9
3 5
5 1
1 9
5 4
2 4
6 4
6 7
7 8
->3
* */