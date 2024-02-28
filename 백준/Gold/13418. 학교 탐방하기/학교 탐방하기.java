import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static class Minimum implements Comparable<Minimum>{
        int n1;
        int n2;
        int d;
        public Minimum(int n1,int n2,int d){
            this.n1=n1;
            this.n2=n2;
            this.d=d;
        }

        @Override
        public int compareTo(Minimum o){
            return this.d-o.d;
        }
    }
    static class Maximum implements Comparable<Maximum>{
        int n1;
        int n2;
        int d;
        public Maximum(int n1,int n2,int d){
            this.n1=n1;
            this.n2=n2;
            this.d=d;
        }

        @Override
        public int compareTo(Maximum o){
            return o.d-this.d;
        }
    }
    static PriorityQueue<Minimum> minPq=new PriorityQueue<>();
    static PriorityQueue<Maximum> maxPq=new PriorityQueue<>();
    static int max;
    static int min;
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        parent=new int[N+1];
        for(int i=0;i<N+1;i++){
            parent[i]=i;
        }
        for(int i=0;i<M+1;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            minPq.add(new Minimum(n1,n2,d));
            maxPq.add(new Maximum(n1,n2,d));
        }
        while(!maxPq.isEmpty()){ //최소
            Maximum now=maxPq.poll();
            int n1=now.n1;
            int n2=now.n2;
            int d=now.d;
            if(findParent(n1)!=findParent(n2)){
                union(n1,n2);
                if(d==0){
                    min++;
                }
            }
        }
        for(int i=0;i<N+1;i++){
            parent[i]=i;
        }
        while(!minPq.isEmpty()){ //최대
            Minimum now=minPq.poll();
            int n1=now.n1;
            int n2=now.n2;
            int d=now.d;
            if(findParent(n1)!=findParent(n2)){
                union(n1,n2);
                if(d==0){
                    max++;
                }
            }
        }

        System.out.println((int)(Math.pow(max,2)-Math.pow(min,2)));
    }
    public static int findParent(int x){
        if(x==parent[x]){
            return x;
        }
        return findParent(parent[x]);
    }
    public static void union(int a, int b){
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