import java.util.*;
import java.io.*;
public class Main {
    static int N,M,A,B,C;
    static int[] d;
    static class Node2{
        int n;
        int w;
        public Node2(int n,int w){
            this.n=n;
            this.w=w;
        }
    }
    static class Node implements Comparable<Node>{
        int n;
        int w;
        int m;
        public Node(int n,int w,int m){
            this.n=n;
            this.w=w;
            this.m=m;
        }
        @Override
        public int compareTo(Node o){
            int x=this.m-o.m;
            if(x==0){
                x=this.w-o.w;
            }
            return x;
        }
    }
    static ArrayList<Node2>[] arr;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        A=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        d=new int[N+1];
        arr=new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            arr[i]=new ArrayList<>();
            d[i]=Integer.MAX_VALUE;
        }
        d[A]=0;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            arr[a].add(new Node2(b,c));
            arr[b].add(new Node2(a,c));
        }
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(A,0,0));
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowNode=now.n;
            int nowD=now.w;
            int nowMin=now.m;
            if(C<nowD){
                continue;
            }
            if(nowNode==B){
                answer=Math.min(answer,nowMin);
            }
            for(int i=0;i<arr[nowNode].size();i++){
                Node2 next=arr[nowNode].get(i);
                int nextNode=next.n;
                int nextW=next.w;
                if(nextW+nowD<=C && d[nextNode]>Math.max(nextW,nowMin)){
                    d[nextNode]=Math.max(nextW,nowMin);
                    pq.add(new Node(nextNode,nextW+nowD,d[nextNode]));
                }
            }
        }
        if(answer==Integer.MAX_VALUE){
            answer=-1;
        }
        System.out.println(answer);
    }
}
/*
3 1 1 3 1
1 3 2
* */