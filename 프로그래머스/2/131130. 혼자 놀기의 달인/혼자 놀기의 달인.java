import java.util.*;
class Solution {
    static boolean[] ch;
    static int[] arr;
    static int N;
    static PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
    public int solution(int[] cards) {
        int answer = 0;
        N=cards.length;
        ch=new boolean[N+1];
        arr=new int[N+1];
        for(int i=0;i<N;i++){
            arr[i+1]=cards[i];
        }
        
        for(int i=1;i<N+1;i++){
            int start=arr[i];
            if(!ch[start]){
                pq.add(bfs(start));
            }
        }
        int n1=0;
        int n2=0;
        if(!pq.isEmpty()){
            n1=pq.poll();
        }
        if(!pq.isEmpty()){
            n2=pq.poll();
        }
        answer=n1*n2;
        
        return answer;
    }
    public static int bfs(int start){
        ArrayDeque<Integer> q=new ArrayDeque<>();
        int n=0;
        q.add(start);
        ch[start]=true;
        while(!q.isEmpty()){
            int now=q.poll();
            int next=arr[now];
            n++;
            if(!ch[next]){
                ch[next]=true;
                q.add(next);
            }
        }
        return n;
    }
}