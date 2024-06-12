import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[] d;
    static class Node implements Comparable<Node>{
        int n1;
        int n2;
        int d;
        public Node(int n1,int n2,int d){
            this.n1=n1;
            this.n2=n2;
            this.d=d;
        }
        @Override
        public int compareTo(Node o){
            return this.d-o.d;
        }
    }
    static class Edge implements Comparable<Edge>{
        int n;
        int d;
        public Edge(int n,int d){
            this.n=n;
            this.d=d;
        }
        @Override
        public int compareTo(Edge o){
            return this.d-o.d;
        }
    }
    static int[] ch;
    static ArrayList<Edge>[] arr;
    static ArrayList<Edge> ans=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        d=new int[N+1];
        ch=new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
            d[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            arr[n1].add(new Edge(n2,d));
            arr[n2].add(new Edge(n1,d));
        }
        djkstra(1);
        bfs(1);
        answer.append(ans.size()+"\n");
        for(int i=0;i<ans.size();i++){
            answer.append(ans.get(i).n+" "+ans.get(i).d+"\n");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();

    }

    public static void djkstra(int start){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(start,0));
        d[start]=0;
        while(!pq.isEmpty()){
            Edge now=pq.poll();
            int nowNode=now.n;
            int nowD=now.d;
            for(int i=0;i<arr[nowNode].size();i++){
                Edge next=arr[nowNode].get(i);
                int nextNode=next.n;
                int nextD=next.d+nowD;
                if(d[nextNode]>nextD){
                    d[nextNode]=nextD;
                    pq.add(new Edge(nextNode,nextD));
                }
            }
        }
    }
    public static void bfs(int start){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        pq.add(new Edge(start,0));
        ch[start]=1;
        while(!pq.isEmpty()){
            Edge now=pq.poll();
            int nowNode=now.n;
            int nowD=now.d;
            for(int i=0;i<arr[nowNode].size();i++){
                Edge next=arr[nowNode].get(i);
                int nextNode=next.n;
                int nextD=next.d+now.d;
                if(ch[nextNode]==0 && nextD<=d[nextNode]){
                    ch[nextNode]=1;
                    ans.add(new Edge(nowNode,nextNode));
                    pq.add(new Edge(nextNode,nextD));
                }
            }
        }
    }


}
/*
6 10
1 2 10
1 4 1
2 4 5
3 4 5
1 3 2
4 5 1
3 5 3
1 6 5
5 6 4
2 5 6
* */