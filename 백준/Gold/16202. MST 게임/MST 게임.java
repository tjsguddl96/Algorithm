import java.util.*;
import java.io.*;

public class Main {
    static int N,M,K;
    static class Node implements Comparable<Node>{
        int n1;
        int n2;
        int w;
        public Node(int n1,int n2,int w){
            this.n1=n1;
            this.n2=n2;
            this.w=w;
        }
        @Override
        public int compareTo(Node o){
            return this.w-o.w;
        }

    }
    static PriorityQueue<Node>[] pq=new PriorityQueue[2];
    static ArrayDeque<Node> q=new ArrayDeque<>();
    static int[] points;
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        points=new int[K];
        parent=new int[N+1];
        for(int i=0;i<2;i++){
            pq[i]=new PriorityQueue<>();
        }
        for(int i=1;i<N+1;i++){
            parent[i]=i;
        }
        for(int i=1;i<M+1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            pq[0].add(new Node(n1,n2,i));
        }
        int p=0;
        while(!pq[0].isEmpty()){
            Node now=pq[0].poll();
            int n1=now.n1;
            int n2=now.n2;
            int w=now.w;
            if(findParent(n1)!=findParent(n2)){
                union(n1,n2);
                p+=w;
                pq[1].add(new Node(n1,n2,w)); //used
            }else{
                q.add(new Node(n1,n2,w)); //not used
            }
        }
        points[0]=p;
        for(int i=1;i<N+1;i++){
            if(findParent(i)!=1){
                points[0]=0;
                break;
            }
        }

        for(int k=1;k<K;k++){
            p=0;
            if(points[k-1]==0){
                break;
            }
            for(int i=1;i<N+1;i++){
                parent[i]=i;
            }
            pq[k%2].poll();
            while(!pq[k%2].isEmpty()){
                Node now=pq[k%2].poll();
                int n1=now.n1;
                int n2=now.n2;
                int w=now.w;
                if(findParent(n1)!=findParent(n2)){
                    union(n1,n2);
                    p+=w;
                    pq[(k%2+1)%2].add(new Node(n1,n2,w));
                }
            }
            int qSize=q.size();
            for(int i=0;i<qSize;i++){
                Node now=q.poll();
                int n1=now.n1;
                int n2=now.n2;
                int w=now.w;
                if(findParent(n1)!=findParent(n2)){
                    union(n1,n2);
                    p+=w;
                    pq[(k%2+1)%2].add(new Node(n1,n2,w));
                }
                else{
                    q.add(new Node(n1,n2,w));
                }
            }
            for(int i=1;i<N+1;i++){
                if(findParent(i)!=1){
                    p=0;
                    break;
                }
            }
            points[k]=p;
        }

        for(int i=0;i<K;i++){
            answer.append(points[i]+" ");
        }
        bw.flush();
        bw.write(answer.toString());
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