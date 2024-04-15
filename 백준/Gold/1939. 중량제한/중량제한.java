import java.io.*;
import java.util.*;
public class Main {
    static int N,M;
    static int c1,c2;
    static class Node implements Comparable<Node>{
        int n;
        int w;
        public Node(int n,int w){
            this.n=n;
            this.w=w;
        }
        @Override
        public int compareTo(Node o){
            return o.w-this.w;
        }
    }
    static ArrayList<Node>[] arr;
    static int INF=Integer.MAX_VALUE;
    static int[] ch;
    static int[] visited;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        ch=new int[N+1];
        visited=new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new ArrayList<>();
        }
        int right=0;
        int left=Integer.MAX_VALUE;
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            arr[n1].add(new Node(n2,w));
            arr[n2].add(new Node(n1,w));
            right=Math.max(right,w);
            left=Math.min(left,w);
        }
        st=new StringTokenizer(bf.readLine());
        c1=Integer.parseInt(st.nextToken());
        c2=Integer.parseInt(st.nextToken());
        int mid=0;
        while(left<=right){
            mid=(left+right)/2;
            if(bfs(mid,c1)){
                answer=mid;
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        System.out.println(answer);
    }
    public static boolean bfs(int mid,int start){
        visited=new int[N+1];
        ArrayDeque<Node> q=new ArrayDeque<>();
        q.add(new Node(start,0));
        while(!q.isEmpty()){
            Node now=q.poll();
            int nowNode=now.n;
            int nowW=now.w;
            if(nowNode==c2){
                return true;
            }
            visited[nowNode]=1;
            for(int i=0;i<arr[nowNode].size();i++){
                Node next=arr[nowNode].get(i);
                int nextNode=next.n;
                int nextW=next.w;
                if(visited[nextNode]==0 && nextW>=mid){
                    visited[nextNode]=1;
                    q.add(new Node(nextNode,mid));
                }
            }
        }
        return false;
    }
}
/*
7 9
1 6 4
1 2 5
1 3 1
6 2 10
2 4 7
6 5 2
6 7 10
5 4 4
7 4 10
3 5

9 9
1 4 11
1 5 2
4 5 4
4 3 10
4 2 7
5 2 10
5 6 13
3 2 9
2 6 8
1 6
-> 9

* */