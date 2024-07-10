import java.util.*;
import java.io.*;
public class Main {
    static int N,P,K;
    static class Node implements Comparable<Node>{
        int n;
        int w;
        int cnt;
        public Node(int n,int w,int cnt){
            this.n=n;
            this.w=w;
            this.cnt=cnt;
        }
        @Override
        public int compareTo(Node o){
            int x=this.cnt-o.cnt;
            if(x==0){
                x=this.w-o.w;
            }
            return x;
        }
    }
    static class Edge implements Comparable<Edge>{
        int n;
        int w;
        public Edge(int n,int w){
            this.n=n;
            this.w=w;
        }
        @Override
        public int compareTo(Edge o){
            return o.w-this.w;
        }
    }
    static int answer=Integer.MAX_VALUE;
    static ArrayList<Edge>[] arr;
    static int[] ch;

    static int[] d;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        P=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        ch=new int[N+1];
        d=new int[P+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<P;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            arr[n1].add(new Edge(n2,w));
            arr[n2].add(new Edge(n1,w));
            d[i]=w;
        }
        d[P]=0;
        Arrays.sort(d);
        int left=0;
        int right=P;
        while(left<=right){
            int mid=(left+right)/2;
            int val=d[mid];
            ch=new int[N+1];
            for(int i=1;i<N+1;i++){
                ch[i]=Integer.MAX_VALUE;
            }
            int count=djkstra(1,val);
            if(count<=K){
                answer=val;
                right=mid-1;
            }
            else{
                left=mid+1;
            }

        }
        if(answer==Integer.MAX_VALUE){
            answer=-1;
        }

        System.out.println(answer);

    }
    public static int djkstra(int nowN,int val){
        int count=Integer.MAX_VALUE;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        ch[nowN]=0;
        pq.add(new Node(nowN,0,0));
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowNode=now.n;
            int nowW=now.w;
            int nowCnt=now.cnt;
            if(nowNode==N){
                count=Math.min(count,nowCnt);
                return count;
            }
            for(int i=0;i<arr[nowNode].size();i++){
                Edge next=arr[nowNode].get(i);
                int nextNode=next.n;
                int nextW=next.w;
                int nextCnt=nowCnt;
                if(nextW>val){
                    nextCnt++;
                }
                if(ch[nextNode]>nextCnt){
                    ch[nextNode]=nextCnt;
                    pq.add(new Node(nextNode,nextW,nextCnt));
                }
            }

        }
        return count;

    }
}