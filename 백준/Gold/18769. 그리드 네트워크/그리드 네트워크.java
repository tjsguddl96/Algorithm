import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static int R,C;
    static int N;
    static int[] parent;
    static class Edge implements Comparable<Edge>{
        int n1;
        int n2;
        int d;
        public Edge(int n1,int n2,int d){
            this.n1=n1;
            this.n2=n2;
            this.d=d;
        }
        @Override
        public int compareTo(Edge o){
            return this.d-o.d;
        }
    }
    static PriorityQueue<Edge> pq;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        T=Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int t=0;t<T;t++){
            st=new StringTokenizer(bf.readLine());
            pq=new PriorityQueue<>();
            R=Integer.parseInt(st.nextToken());
            C=Integer.parseInt(st.nextToken());
            N=R*C;
            parent=new int[N+1];
            for(int i=1;i<N+1;i++){
                parent[i]=i;
            }
            for(int i=1;i<R+1;i++){
                st=new StringTokenizer(bf.readLine());
                for(int j=1;j<C;j++){
                    int n1=(i-1)*C+j;
                    int n2=n1+1;
                    int d=Integer.parseInt(st.nextToken());
                    pq.add(new Edge(n1,n2,d));
                }
            }
            for(int i=1;i<R;i++){
                st=new StringTokenizer(bf.readLine());
                for(int j=1;j<C+1;j++){
                    int n1=(i-1)*C+j;
                    int n2=n1+C;
                    int d=Integer.parseInt(st.nextToken());
                    pq.add(new Edge(n1,n2,d));
                }
            }
            int ans=0;
            while(!pq.isEmpty()){
                Edge now=pq.poll();
                int n1=now.n1;
                int n2=now.n2;
                int d=now.d;
                if(findParent(n1)!=findParent(n2)){
                    union(n1,n2);
                    ans+=d;
                }
            }
            answer.append(ans+"\n");
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();
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
        else if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }
}