import java.util.*;

class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> q1=new Stack<>();
        Stack<Integer> q2=new Stack<>();
        
        for(int i=0;i<n;i++){
            if(deliveries[i]!=0){
                q1.add(i+1);
            }
            if(pickups[i]!=0){
                q2.add(i+1);
            }
        }
        while(!q2.isEmpty() || !q1.isEmpty()){
            int n1=0;
            int n2=0;
            if(!q1.isEmpty()){
                n1=q1.peek();
            }
            if(!q2.isEmpty()){
                n2=q2.peek();
            }
            answer+=Math.max(n1,n2);
            int cap1=cap;
            int cap2=cap;
            while(!q1.isEmpty() && cap1>0){
                int tmp=deliveries[q1.peek()-1];
                if(tmp<=cap1){
                    q1.pop();
                }
                else{
                    deliveries[q1.peek()-1]=tmp-cap1;
                }
                cap1-=tmp;
            }
            while(!q2.isEmpty() && cap2>0){
                int tmp=pickups[q2.peek()-1];
                if(tmp<=cap2){
                    q2.pop();
                }
                else{
                    pickups[q2.peek()-1]=tmp-cap2;
                }
                cap2-=tmp;
            }
            
        }
        

        
        return answer*2;
    }
}