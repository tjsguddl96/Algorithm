import java.io.*;
import java.util.*;

public class Main {
    static int T,N,M,K,S,G,H;
    static class Node implements Comparable<Node>{
        int n;
        int d;
        public Node(int n,int d){
            this.n=n;
            this.d=d;
        }
        @Override
        public int compareTo(Node o){
            return this.d-o.d;
        }
    }
    static ArrayList<Integer> candidate;
    static ArrayList<Node>[] arr;
    static int[][] dist;
    static ArrayList<Integer> answer;
    static int distanceGH;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans=new StringBuilder();
        StringTokenizer st;
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            answer=new ArrayList<>();
            st=new StringTokenizer(bf.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(bf.readLine());
            S=Integer.parseInt(st.nextToken());
            G=Integer.parseInt(st.nextToken());
            H=Integer.parseInt(st.nextToken());
            arr=new ArrayList[N+1];
            dist=new int[N+1][N+1];
            for(int i=1;i<N+1;i++){
                arr[i]=new ArrayList<>();
                for(int j=1;j<N+1;j++){
                    dist[i][j]=Integer.MAX_VALUE;
                }
            }
            for(int i=0;i<M;i++){
                st=new StringTokenizer(bf.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                int d=Integer.parseInt(st.nextToken());
                arr[a].add(new Node(b,d));
                arr[b].add(new Node(a,d));
                if(a==G && b==H){
                    distanceGH=d;
                }
                else if(a==H && b==G){
                    distanceGH=d;
                }
            }
            candidate=new ArrayList<>();
            for(int i=0;i<K;i++){
                candidate.add(Integer.parseInt(bf.readLine()));
            }
            djkstra(S);
            djkstra(G);
            djkstra(H);
            for(int i=0;i<K;i++) {
                int nowC=candidate.get(i);
                if (dist[S][G] + distanceGH + dist[H][nowC]==dist[S][nowC] || dist[S][H]+distanceGH+dist[G][nowC]==dist[S][nowC]){
                    answer.add(nowC);
                }
            }
            Collections.sort(answer);
            for(int i=0;i<answer.size();i++){
                ans.append(answer.get(i)+" ");
            }
            ans.append("\n");

        }
        bw.flush();
        bw.write(ans.toString());
        bw.close();
    }
    public static void djkstra(int start){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        dist[start][start]=0;
        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowN=now.n;
            int nowD=now.d;
            if(dist[start][nowN]<nowD){
                continue;
            }
            for(int i=0;i<arr[nowN].size();i++){
                Node next=arr[nowN].get(i);
                int nextN=next.n;
                int nextD=next.d+nowD;
                if(dist[start][nextN]>nextD){
                    dist[start][nextN]=nextD;
                    pq.add(new Node(nextN,nextD));
                }
            }
        }



    }

}