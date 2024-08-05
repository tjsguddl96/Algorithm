import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node>{
        int n;
        int w;
        public Node(int n, int w){
            this.n=n;
            this.w=w;
        }
        @Override
        public int compareTo(Node o){
            return this.w-o.w;
        }
    }
    static int N,K,M;
    static ArrayList<Integer>[] arr;
    static int[] dist;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1+M];
        dist=new int[N+1+M];
        for(int i=1;i<N+1+M;i++){
            arr[i]=new ArrayList<>();
            dist[i]=Integer.MAX_VALUE;
        }
        for(int i=N+1;i<N+1+M;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<K;j++){
                int tmp=Integer.parseInt(st.nextToken());
                arr[i].add(tmp);
                arr[tmp].add(i);
            }
        }
        djkstra();
        if(dist[N]==Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else {
            System.out.println(dist[N]/2+1);
        }
    }
    public static void djkstra(){
        dist[1]=1;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(1,1));
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowN=now.n;
            int nowW=now.w;
            if(dist[nowN]<nowW){
                continue;
            }
            for(int next:arr[nowN]){
                if(dist[next]>nowW+1){
                    pq.add(new Node(next,nowW+1));
                    dist[next]=nowW+1;
                }
            }
        }
    }
}


/*
6 3 2
1 2 3
3 4 5
->-1

1 1 1
1
-> 1

9 3 3
1 6 7
2 3 6
2 3 9
->4

5 3 2
1 2 4
3 4 5
->3


* */