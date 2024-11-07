import java.util.*;

class Solution {
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
    static int[] parent;
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<costs.length;i++){
            int n1=costs[i][0];
            int n2=costs[i][1];
            int w=costs[i][2];
            pq.add(new Node(n1,n2,w));
        }
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int n1=now.n1;
            int n2=now.n2;
            int w=now.w;
            if(getParent(n1)!=getParent(n2)){
                union(n1,n2);
                answer+=w;
            }
        }
        return answer;
    }
    public static int getParent(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x]=getParent(parent[x]);
    }
    public static void union(int a,int b){
        int parentA=getParent(a);
        int parentB=getParent(b);
        if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }
    }
}