import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int time;
        int idx;
        public Node(int time,int idx){
            this.time=time;
            this.idx=idx;
        }
        @Override
        public int compareTo(Node o){
            return this.time-o.time;
        }
    }
    static PriorityQueue<Node> in=new PriorityQueue<>();
    static PriorityQueue<Node> out=new PriorityQueue<>();
    static int[] ch;
    public int solution(int[][] routes) {
        int answer = 0;
        ch=new int[routes.length];
        for(int i=0;i<routes.length;i++){
            int inTime=routes[i][0];
            int outTime=routes[i][1];
            in.add(new Node(inTime,i));
            out.add(new Node(outTime,i));
        }
        
        while(!out.isEmpty()){
            Node now=out.poll();
            int outTime=now.time;
            int nowIdx=now.idx;
            if(ch[nowIdx]==1){
                continue;
            }
            while(!in.isEmpty() && outTime>=in.peek().time){
                Node next=in.poll();
                int nextIdx=next.idx;
                ch[nextIdx]=1;
            }
            answer++;
        }
        
    
        
        return answer;
    }
}