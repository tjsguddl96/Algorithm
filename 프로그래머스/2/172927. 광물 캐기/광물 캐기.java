import java.util.*;
class Solution {
    static class Node implements Comparable<Node>{
        int idx;
        int dia;
        int iron;
        int stone;
        public Node(int dia,int iron,int stone,int idx){
            this.idx=idx;
            this.dia=dia;
            this.iron=iron;
            this.stone=stone;
        }
        @Override
        public int compareTo(Node o){
            int x=o.dia-this.dia;
            if(x==0){
                x=o.iron-this.iron;
            }
            if(x==0){
                x=o.stone-this.stone;
            }
            return x;
        }
        
    }
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int dia=0;
        int iron=0;
        int stone=0;
        int idx=0;
        for(int i=0;i<minerals.length;i++){
            String mineral=minerals[i];
            if(mineral.equals("diamond")){
                dia++;
            }
            else if(mineral.equals("iron")){
                iron++;
            }
            else{
                stone++;
            }
            if(i%5==4){
                pq.add(new Node(dia,iron,stone,idx));
                dia=0;
                iron=0;
                stone=0;
                idx++;
            }
            else if(i==minerals.length-1){
                pq.add(new Node(dia,iron,stone,idx));
                idx++;
                dia=0;
                iron=0;
                stone=0;
            }
        }
        int pick=0;
        for(int i=0;i<3;i++){
            if(picks[i]!=0){
                pick=i;
                break;
            }
        }
        int sum=picks[0]+picks[1]+picks[2];
        while(!pq.isEmpty() && pick<3){
    
            Node now=pq.poll();
            if(now.idx>=sum){
                continue;   
            }
            int nowD=now.dia;
            int nowI=now.iron;
            int nowS=now.stone;
            // System.out.println(nowD+" "+nowI+" "+nowS+" "+pick);
            if(pick==0){
                answer+=(nowD+nowI+nowS);
            }
            else if(pick==1){
                answer+=(nowD*5+nowI+nowS);
            }
            else{
                answer+=(nowD*25+nowI*5+nowS);
            }
            picks[pick]--;
            while(pick<3 && picks[pick]==0){
                pick++;
            }
        }
        return answer;
    }
}