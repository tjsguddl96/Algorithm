import java.util.*;
class Solution {
    static int[] dist;
    static class Node implements Comparable<Node>{
        int n;
        int d;
        public Node(int n,int d){
            this.n=n;
            this.d=d;
        }
        @Override
        public int compareTo(Node o){
            return this.d-o.d;
        }
    }
    static int INF=Integer.MAX_VALUE;
    static ArrayList<Integer>[] arr;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        dist=new int[n+1];
        arr=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            dist[i]=INF;
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<roads.length;i++){
            int n1=roads[i][0];
            int n2=roads[i][1];
            arr[n1].add(n2);
            arr[n2].add(n1);
        }
        djkstra(destination);
        for(int i=0;i<sources.length;i++){
            answer[i]=dist[sources[i]];
            if(answer[i]==INF){
                answer[i]=-1;
            }
        }
        return answer;
    }
    public static void djkstra(int destination){
        dist[destination]=0;
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(destination,0));
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowNode=now.n;
            int nowD=now.d;
            if(dist[nowNode]<nowD){
                continue;
            }
            for(int i=0;i<arr[nowNode].size();i++){
                int nextNode=arr[nowNode].get(i);
                if(dist[nextNode]>nowD+1){
                    
                    dist[nextNode]=nowD+1;
                    pq.add(new Node(nextNode,dist[nextNode]));
                }
            }
        }
    }
    
    
}