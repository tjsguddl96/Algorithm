import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
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
    static int[] parent;
    static int N;
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        parent=new int[N+1];
        for(int i=1;i<N+1;i++){
            parent[i]=i;
        }
        StringTokenizer st;
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=1;j<N+1;j++){
                int n=Integer.parseInt(st.nextToken());
                if(j>i){
                    pq.add(new Node(i,j,n));
                }
            }
        }
        long answer=0L;
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int n1=now.n1;
            int n2=now.n2;
            if(findParent(n1)!=findParent(n2)){
                answer+=now.d;
                union(n1,n2);
            }
        }
        System.out.println(answer);
    }

    public static int findParent(int x){
        if(x==parent[x]){
            return x;
        }
        return findParent(parent[x]);
    }
    public static void union(int a,int b){
        int parentA=findParent(a);
        int parentB=findParent(b);
        if(parentA==parentB){
            return ;
        }
        if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }

}