import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static ArrayList<Integer>[] children;
    static int[] parent;
    static int[] dp;
    static class Node implements Comparable<Node>{
        int n;
        int t;
        public Node(int n,int t){
            this.n=n;
            this.t=t;
        }
        @Override
        public int compareTo(Node o){
            return o.t-this.t;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());
        parent=new int[N]; //parent[i]=i의 직속 선배
        children=new ArrayList[N]; //children[i]=i의 직속 후배
        for(int i=0;i<N;i++){
            children[i]=new ArrayList<>();
        }
        dp=new int[N];
        for(int i=0;i<N;i++){
            int p=Integer.parseInt(st.nextToken());
            parent[i]=p;
            if(p==-1){
                continue;
            }
            children[p].add(i);
        }
        System.out.println(solve(0));





    }
    public static int solve(int now){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        int maxTime=0;
        int cnt=0;
        for(int i=0;i<children[now].size();i++){
            int next=children[now].get(i);
            dp[next]=solve(next);
            pq.add(new Node(next,dp[next]));
        }
        while(!pq.isEmpty()){
            Node next=pq.poll();
            int nextNode=next.n;
            int nextTime=next.t;
            cnt++;
            maxTime=Math.max(maxTime,nextTime+cnt);
        }
        return maxTime;
    }

}
/*
5
-1 0 1 2 3

5
-1 0 0 0 0

18
-1 0 0 0 1 1 1 1 1 1 1 2 2 11 11 12 13 16
->8

15
-1 0 0 0 0 2 2 3 3 6 7 7 4 12 13
->5
* */