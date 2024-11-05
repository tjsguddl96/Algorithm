import java.util.*;
class Solution {
    static int n;
    static class Node implements Comparable<Node>{
        int idx;
        int s1;
        int s2;
        public Node(int idx,int s1,int s2){
            this.idx=idx;
            this.s1=s1;
            this.s2=s2;
        }
        @Override
        public int compareTo(Node o){
            int x=o.s1-this.s1;
            if(x==0){
                x=o.s2-this.s2;
            }
            return x;
        }
    }
    static class Sum implements Comparable<Sum>{
        int idx;
        int sum;
        public Sum(int idx,int sum){
            this.idx=idx;
            this.sum=sum;
        }
        @Override
        public int compareTo(Sum o){
            return o.sum-this.sum;
        }
    }
    static PriorityQueue<Sum> pq=new PriorityQueue<>();
    static PriorityQueue<Node> q=new PriorityQueue<>();
    public int solution(int[][] scores) {
        int answer = -1;
        n=scores.length;
        
        for(int i=n-1;i>=0;i--){
            int s1=scores[i][0];
            int s2=scores[i][1];
            q.add(new Node(i,s1,s2));
        }
        
        //순위 매길수 있는 애들은 pq.add(new Sum)으로 삽입
        int max=0;
        while(!q.isEmpty()){
            Node now=q.poll();
            int idx=now.idx;
            int s1=now.s1;
            int s2=now.s2;
            if(max<=s2){
                pq.add(new Sum(idx,s1+s2));
            }
            while(!q.isEmpty() && q.peek().s1==s1){
                Node next=q.poll();
                if(next.s2>=max){
                    pq.add(new Sum(next.idx,next.s1+next.s2));
                }
            }
            if(max<=s2){
                max=s2;
            }
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        int prize=1;
        while(!pq.isEmpty()){
            int cnt=1;
            Sum now=pq.poll();
            // System.out.println(prize);
            // System.out.println(now.idx+" "+now.sum);

            if(now.idx==0){
                answer=prize;
            }
            int sum=now.sum;
            while(!pq.isEmpty() && pq.peek().sum==sum){
                // System.out.println(pq.peek().idx+" "+pq.peek().sum);
                if(pq.peek().idx==0){
                    answer=prize;
                }
                pq.poll();
                cnt++;
            }
            prize+=cnt;
            // System.out.println("----------");
        }
        return answer;
    }
}