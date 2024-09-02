import java.util.*;
import java.io.*;
public class Main {
    static int N,M,K;
    static int[][] foods;
    static int[][] dp;
    static HashSet<Integer>[] arr;
    static int answer;
    static class Node implements Comparable<Node>{
        int n;
        int depth;
        public Node(int n,int depth){
            this.n=n;
            this.depth=depth;
        }
        @Override
        public int compareTo(Node o){
            return this.depth-o.depth;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        foods=new int[N+1][N+1];
        dp=new int[M+1][N+1];
        arr=new HashSet[N+1];
        for(int i=1;i<N+1;i++){
            arr[i]=new HashSet<>();
        }
        for(int i=0;i<K;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            if(a<b){
                foods[a][b]=Math.max(foods[a][b],c);
                arr[a].add(b);
            }
        }
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(1,1));
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowNode=now.n;
            int nowDepth=now.depth;
            if(nowDepth>=M){
                continue;
            }
            for(int next:arr[nowNode]){
                if(dp[nowDepth+1][next]<foods[nowNode][next]+dp[nowDepth][nowNode]){
                    dp[nowDepth+1][next]=Math.max(foods[nowNode][next]+dp[nowDepth][nowNode],dp[nowDepth+1][next]);
                    pq.add(new Node(next,nowDepth+1));
                }
            }
        }
        for(int i=0;i<M+1;i++){
            answer=Math.max(answer,dp[i][N]);
        }
        System.out.println(answer);
    }
}
/*
5 4 6
1 2 10
2 3 10
1 3 5
3 4 10000
4 5 100
3 5 1
->10105

5 3 5
1 2 1
1 3 10
2 4 2
1 4 1
4 5 10
->11

5 4 5
1 2 1
1 3 10
2 4 2
1 4 10
4 5 10
-> 20

5 4 6
1 2 1
1 3 10
2 4 2
1 4 10
4 5 10
3 4 30

3 3 2
1 2 3
1 3 1
->1

3 1 5
1 3 2
1 2 5
2 3 3
1 3 4
3 1 100


<1>
3 2 5
1 3 2
1 2 5
2 3 3
1 3 4
3 1 100
-> 4

<2>
4 2 6
1 4 2
2 4 3
3 4 1
3 2 5
2 3 4
3 4 2
-> 2

4 2 3
1 3 10
1 2 1
2 4 2
->0

3 3 5
1 3 10
1 2 15
2 3 3
1 3 4
3 1 100
->18


5 5 7
1 4 10
1 2 1
1 3 10
3 4 30
2 3 100
4 5 10
2 4 2
-> 141

6 5 8
5 6 1
1 4 10
1 2 1
1 3 10
3 4 30
2 3 100
4 5 10
2 4 2
-> 51

6 6 8
5 6 1
1 4 10
1 2 1
1 3 10
3 4 30
2 3 100
4 5 10
2 4 2
->142

6 4 9
1 6 1
5 6 1
1 4 10
1 2 1
1 3 10
3 4 30
2 3 100
4 5 10
2 4 200
* */