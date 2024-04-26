import java.util.*;
class Solution {
    static int[] dp;
    static class Answer implements Comparable<Answer>{
        int idx;
        int s;
        public Answer(int idx,int s){
            this.idx=idx;
            this.s=s;
        }
        @Override
        public int compareTo(Answer o){
            return this.s-o.s;
        }
    }
    static class Node implements Comparable<Node>{
        int num;
        int cnt;
        public Node(int num,int cnt){
            this.num=num;
            this.cnt=cnt;
        }
        @Override
        public int compareTo(Node o){
            int x=o.cnt-this.cnt;
            if(x==0){
                x=this.num-o.num;
            }
            return x;
        }
        
    }
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    static PriorityQueue<Answer> ans=new PriorityQueue<>();
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        for(int i=0;i<starts.length;i++){
            ans.add(new Answer(i,starts[i]));
        }
        dp=new int[e+1];
        for(int i=1;i<e+1;i++){
            dp[i]=1;
        }
        for(int i=2;i<e+1;i++){
            for(int j=1;j<(e/i)+1;j++){
                dp[i*j]+=1;
            }
        }
        for(int i=1;i<e+1;i++){
            pq.add(new Node(i,dp[i]));
        }
        while(!ans.isEmpty()){
            Answer now=ans.poll();
            int idx=now.idx;
            int s=now.s;
            if(pq.isEmpty()){
                break;
            }
            int n=pq.peek().num;
            while(n<s ){ //s<=n.num 일 때까지 빼야돼
                pq.poll();
                n=pq.peek().num;
            }
            answer[idx]=n;
        }
        
        
        return answer;
    }
}