import java.util.*;

class Solution {
    static class Info implements Comparable<Info>{
        int start;
        int duration;
        int type;
        int idx;
        public Info(int start,int duration, int type,int idx){
            this.start=start;
            this.duration=duration;
            this.type=type;
            this.idx=idx;
        }
        @Override
        public int compareTo(Info o){
            int x=this.start-o.start;
            if(x==0){
                x=this.idx-o.idx;
            }
            return x;
        }
    }
    static int[] mentor;
    static PriorityQueue<Integer> pq[];
    static PriorityQueue<Info> q=new PriorityQueue<>();
    static int answer=999999999;
    //k=유형 수, n=멘토 수
    public int solution(int k, int n, int[][] reqs) {
        
        mentor=new int[k+1];
        pq=new PriorityQueue[k+1];
        
        permutation(1,k,n,reqs);
        return answer;
    }
    public void permutation(int cnt,int k,int n,int[][] reqs){
        if(cnt>=(k+1)){
            if(calSum()==n){
                q=new PriorityQueue<>();
                for(int i=0;i<reqs.length;i++){
                    q.add(new Info(reqs[i][0],reqs[i][1],reqs[i][2],i));
                }
                for(int i=1;i<k+1;i++){
                    pq[i]=new PriorityQueue<>();
                }
                int tmpAnswer=0;
                while(!q.isEmpty()){
                    if(tmpAnswer>answer){
                        break;
                    }
                    Info now=q.poll();
                    int start=now.start;
                    int duration=now.duration;
                    int type=now.type;
                    int endTime=start+duration;
                    int nowIdx=now.idx;
                    while(!pq[type].isEmpty() && pq[type].peek()<=start){
                        pq[type].poll();
                    }
                    if(pq[type].size()<mentor[type]){
                        pq[type].add(endTime);
                    }else{
                        tmpAnswer+=(pq[type].peek()-start);
                        q.add(new Info(pq[type].peek(),duration,type,nowIdx));
                    }
                }
                if(tmpAnswer<answer){
                    answer=tmpAnswer;
                }
            }
            return ;
        }
        for(int i=1;i<=(n-k)+1;i++){
            mentor[cnt]=i;
            permutation(cnt+1,k,n,reqs);
        }
    }
    public int calSum(){
        int sum=0;
        for(int i=0;i<mentor.length;i++){
            sum+=mentor[i];
        }
        return sum;
    }
}