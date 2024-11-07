import java.util.*;
class Solution {
    static int[] dist;
    static int INF=Integer.MAX_VALUE;
    static class Node implements Comparable<Node>{
        int n;
        int w;
        public Node(int n,int w){
            this.n=n;
            this.w=w;
        }
        @Override
        public int compareTo(Node o){
            return this.w-o.w;
        }
    }
    public static ArrayList<Node>[] arr;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        dist=new int[N+1];
        arr=new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            dist[i]=INF;
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<road.length;i++){
            int n1=road[i][0];
            int n2=road[i][1];
            int w=road[i][2];
            arr[n1].add(new Node(n2,w));
            arr[n2].add(new Node(n1,w));
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        djkstra();
        
        for(int i=1;i<N+1;i++){

            if(dist[i]<=K){
                answer++;
            }
        }
        return answer;
    }
    public static void djkstra(){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        pq.add(new Node(1,0));
        dist[1]=0;
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowNode=now.n;
            int nowW=now.w;
            if(dist[nowNode]<nowW){
                continue;
            }
            for(int i=0;i<arr[nowNode].size();i++){
                Node next=arr[nowNode].get(i);
                int nextNode=next.n;
                int nextW=next.w;
                if(dist[nextNode]>nextW+nowW){
                    dist[nextNode]=nextW+nowW;
                    pq.add(new Node(nextNode,dist[nextNode]));
                }
            }
            
        }
    }
    
}