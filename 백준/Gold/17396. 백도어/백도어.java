import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[] see; //see[i]==1 -> 상대방에게 보임
    static long[] dist;
    static class Node implements Comparable<Node>{
        int n;
        long t;
        public Node(int n,long t){
            this.n=n;
            this.t=t;
        }
        @Override
        public int compareTo(Node o){
            long x=this.t-o.t;
            if(x<0){
                return -1;
            }
            return 1;
        }
    }
    static ArrayList<Node>[] arr;
    static long answer=Long.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        see=new int[N];
        arr=new ArrayList[N];
        dist=new long[N];
        for(int i=0;i<N;i++){
            arr[i]=new ArrayList<>();
            dist[i]=Long.MAX_VALUE;
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            see[i]=Integer.parseInt(st.nextToken());
        }
        see[N-1]=0;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int t=Integer.parseInt(st.nextToken());
            if(see[n1]==1 || see[n2]==1){
                continue;
            }
            arr[n1].add(new Node(n2,t));
            arr[n2].add(new Node(n1,t));
        }
        if(arr[N-1].size()==0){
            System.out.println(-1);
        }
        else {
            dist[0] = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, 0));
            while (!pq.isEmpty()) {
                Node now = pq.poll();
                int nowN = now.n;
                long nowT = now.t;
                if (nowN == N - 1) {
                    answer = nowT;
                    break;
                }
                if(dist[nowN]<nowT){
                    continue;
                }
                for (int i = 0; i < arr[nowN].size(); i++) {
                    Node next = arr[nowN].get(i);
                    int nextN = next.n;
                    long nextT = next.t;
                    if (see[nextN] == 0 && dist[nextN] > nowT + nextT && nowT+nextT<answer) {
                        dist[nextN] = nowT + nextT;
                        pq.add(new Node(nextN, dist[nextN]));
                    }
                }
            }
            if(answer==Long.MAX_VALUE){
                answer=-1;
            }
            System.out.println(answer);
        }
    }
}