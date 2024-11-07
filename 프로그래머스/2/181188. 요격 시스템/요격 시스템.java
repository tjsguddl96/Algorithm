import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int st;
        int end;
        public Node(int st,int end){
            this.st=st;
            this.end=end;
        }
        @Override
        public int compareTo(Node o){
            int x=this.end-o.end;
            if(x==0){
                x=this.st-o.st;
            }
            return x;
        }
    }
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    public int solution(int[][] targets) {
        int answer = 0;
        for(int i=0;i<targets.length;i++){
            int st=targets[i][0];
            int end=targets[i][1];
            pq.add(new Node(st,end));
        }
        while(!pq.isEmpty()){
            Node now=pq.poll();
            int nowEnd=now.end;
            answer++;
            while(!pq.isEmpty() && pq.peek().st<nowEnd){
                pq.poll();
            }
        }
        return answer;
    }
}