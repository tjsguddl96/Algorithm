import java.io.*;
import java.util.*;

public class Main {
    static int N;
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
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    static int[] parent;
    //a:97~z:122, A:65~Z:90, 0 : 48
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        long sum=0L;
        N=Integer.parseInt(bf.readLine());
        parent=new int[N+1];
        for(int i=1;i<N+1;i++){
            parent[i]=i;
        }
        for(int i=1;i<N+1;i++){
            String input=bf.readLine();
            for(int j=1;j<N+1;j++){
                int length=(int)input.charAt(j-1);
                if(length==48){
                    continue;
                }
                else if(length<=90){ //A~Z -> 27-52
                    length-=38;
                }
                else{ //a~z -> 1-26
                    length-=96;
                }
                sum+=length;
                if(i!=j){
                    pq.add(new Node(i,j,length));
                }
            }
        }
        long used=0L;
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int n1=now.n1;
            int n2=now.n2;
            int w=now.w;
            if(findParent(n1)!=findParent(n2)){
                union(n1,n2);
                used+=w;
            }
        }
        long answer=sum-used;
        for(int i=1;i<N+1;i++){
            if(findParent(i)!=1){
                answer=-1;
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
        if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }
}