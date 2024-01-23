import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] w;
    static int[][] p;
    static class Node implements Comparable<Node>{
        int n1;
        int n2;
        int p;
        public Node(int n1,int n2,int p){
            this.n1=n1;
            this.n2=n2;
            this.p=p;
        }
        @Override
        public int compareTo(Node o){
            return this.p-o.p;
        }
    }
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    static int[] ch;
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        w=new int[N+1];
        ch=new int[N+1];
        parent=new int[N+1];
        p=new int[N+1][N+1];
        for(int i=1;i<N+1;i++){
            w[i]=Integer.parseInt(bf.readLine());
            parent[i]=i;
        }
        StringTokenizer st;
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=1;j<N+1;j++){
                p[i][j]=Integer.parseInt(st.nextToken());
                if(j>i && p[i][j]!=0){
                    pq.add(new Node(i,j,p[i][j]));
                }
            }
        }
        long answer=0L;
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int n1=now.n1;
            int n2=now.n2;
            if(findParent(n1)!=findParent(n2) && (w[findParent(n2)]>now.p||w[findParent(n1)]>now.p)){
                union(n1,n2);
                answer+=now.p;
            }
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=1;i<N+1;i++){
            set.add(findParent(i));
        }
        for(int val:set){
            answer+=w[val];
        }
        System.out.println(answer);

    }
    public static void union(int a,int b){
        int parentA=findParent(a);
        int parentB=findParent(b);
        if(parentA==parentB){
            return ;
        }
        else if(w[parentA]<w[parentB]){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }
    public static int findParent(int x){
        if(x==parent[x]){
            return x;
        }
        return findParent(parent[x]);

    }
}
/*
6
6
4
5
3
100
8
0 20 2 2 0 0
20 0 30 30 2 0
2 20 0 3 0 10
2 20 3 0 0 0
0 2 0 0 0 0
0 0 10 0 0 0
-> 21

6
6
4
5
3
1
8
0 0 2 2 0 0
0 0 0 0 2 0
2 0 0 3 0 10
2 0 3 0 0 0
0 2 0 0 0 0
0 0 10 0 0 0
-> 18

6
6
4
5
3
1
8
0 1 2 2 0 0
1 0 1 1 2 0
2 1 0 3 0 10
2 1 3 0 0 0
0 2 0 0 0 0
0 0 10 0 0 0
-> 14

6
6
4
5
3
1
8
0 1 2 3 0 0
1 0 3 1 2 0
2 3 0 3 0 10
3 1 3 0 0 0
0 2 0 0 0 0
0 0 10 0 0 0
-> 15

6
6
4
5
3
100
8
0 1 2 3 0 0
1 0 3 1 2 0
2 3 0 3 0 10
3 1 3 0 0 0
0 2 0 0 0 0
0 0 10 0 0 0
->17


6
6
4
5
3
100
8
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
-> 126

8
6
4
5
3
100
8
1
1
0 1 2 3 0 0 0 0
1 0 3 1 2 0 0 0
2 3 0 3 0 10 0 0
3 1 3 0 0 0 0 0
0 2 0 0 0 0 0 0
0 0 10 0 0 0 0 0
0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0
-> 19


6
1
1
1
1
1
1
0 1 2 3 0 0
1 0 3 1 2 0
2 3 0 3 0 10
3 1 3 0 0 0
0 2 0 0 0 0
0 0 10 0 0 0

6
6
4
5
3
100
8
0 100 100 100 100 100
100 0 100 100 90 100
100 100 0 100 100 100
100 100 100 0 100 100
100 90 100 100 0 100
100 100 100 100 100 0
-> 116

6
6
4
5
3
100
8
0 100 100 100 100 100
100 0 100 100 90 100
100 100 0 100 100 100
100 100 100 0 99 100
100 90 100 99 0 100
100 100 100 100 100 0
* */