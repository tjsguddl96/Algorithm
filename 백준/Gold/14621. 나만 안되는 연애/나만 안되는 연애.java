import java.util.*;
import java.io.*;
public class Main {
    //크루스칼
    static int N,M;
    static char[] sex;
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
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        sex=new char[N+1];
        parent=new int[N+1];
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            sex[i]=st.nextToken().charAt(0);
            parent[i]=i;
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            pq.add(new Node(n1,n2,d));
        }

        int answer=0;
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int n1=now.n1;
            int n2=now.n2;
            if(findParent(n1)!=findParent(n2) && sex[n1]!=sex[n2]){
                union(n1,n2);
                answer+=now.d;
            }
        }
        if(answer==0){
            answer=-1;
        }
        int parent=findParent(1);
        for(int i=2;i<N+1;i++){
            if(parent!=findParent(i)){
                answer=-1;
                break;
            }
        }
        System.out.println(answer);
    }
    public static void union(int a,int b){
        int parentA=findParent(a);
        int parentB=findParent(b);
        if(parentA==parentB){
            return ;
        }
        else if(parentA<parentB){
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
5 7
W M W W W
1 2 12
1 3 10
4 2 5
5 2 5
2 5 10
3 4 3
5 4 7

* */