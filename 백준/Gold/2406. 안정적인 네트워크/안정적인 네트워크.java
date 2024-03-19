import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static class Edge implements Comparable<Edge>{
        int n1;
        int n2;
        int w;
        public Edge(int n1,int n2,int w){
            this.n1=n1;
            this.n2=n2;
            this.w=w;
        }
        @Override
        public int compareTo(Edge o){
            return this.w-o.w;
        }
    }
    static int[][] w;
    static int INF=Integer.MAX_VALUE;
    static int[] parent;
    static PriorityQueue<Edge> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        w=new int[n+1][n+1];
        parent=new int[n+1];
        for(int i=1;i<n+1;i++){
            parent[i]=i;
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            union(n1,n2);
            w[n1][n2]=INF;
        }
        for(int i=1;i<n+1;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=1;j<n+1;j++){
                int nowW=Integer.parseInt(st.nextToken());
                if(w[i][j]==INF){
                    continue;
                }
                if(i!=1 && j>=i+1){
                    pq.add(new Edge(i,j,nowW));
                }
            }
        }
        int answerX=0;
        ArrayList<Edge> answer=new ArrayList<>();
        while(!pq.isEmpty()){
            Edge now=pq.poll();
            int n1=now.n1;
            int n2=now.n2;
            int nowW=now.w;
            if(findParent(n1)!=findParent(n2)){
                union(n1,n2);
                answerX+=nowW;
                answer.add(new Edge(n1,n2,0));
            }
        }
        System.out.println(answerX+" "+answer.size());
        for(int i=0;i<answer.size();i++){
            System.out.println(answer.get(i).n1+" "+answer.get(i).n2);
        }
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
        if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }
}