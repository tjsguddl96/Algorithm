import java.util.*;
import java.io.*;
public class Main {
    static int V,E;
    static class Node implements Comparable<Node>{
        int n1;
        int n2;
        int c;
        public Node(int n1,int n2,int c){
            this.n1=n1;
            this.n2=n2;
            this.c=c;
        }
        @Override
        public int compareTo(Node o){
            return this.c-o.c;
        }
    }
    static int[] parent;
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        V=Integer.parseInt(st.nextToken());
        parent=new int[V+1];
        for(int i=1;i<V+1;i++){
            parent[i]=i;
        }
        E=Integer.parseInt(st.nextToken());
        for(int i=0;i<E;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, c));
        }
        long answer=0L;
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int n1=now.n1;
            int n2=now.n2;
            int c=now.c;
            boolean flag=union(n1,n2);
            if(flag){
                answer+=c;
            }
        }
        System.out.println(answer);

    }
    public static boolean union(int a,int b){
        int parentA=findParent(a);
        int parentB=findParent(b);
        if(parentA==parentB){
            return false;
        }
        else if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
        return true;
    }
    public static int findParent(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=findParent(parent[x]);
    }

}