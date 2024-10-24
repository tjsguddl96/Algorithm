import java.util.*;
class Solution {
    static PriorityQueue<Integer> pq=new PriorityQueue<>();
    static PriorityQueue<Integer>[] bus;
    public String solution(int n, int t, int m, String[] timetable) {
        String ans = "";
        int answer=0;
        int N=timetable.length;
        bus=new PriorityQueue[1500];
        for(int i=0;i<N;i++){
            pq.add(calTime(timetable[i]));
        }
        int busTime=9*60;
        for(int i=0;i<n;i++){
            bus[busTime]=new PriorityQueue<>(Collections.reverseOrder());
            while(bus[busTime].size()<m && !pq.isEmpty() && pq.peek()<=busTime){
                bus[busTime].add(pq.poll());
            }
            
            busTime+=t;
        }
        busTime-=t;
        
        if(bus[busTime].size()<m){
            answer=busTime;

        }
        else{
            answer=bus[busTime].peek()-1;
        }
            
            
        
        
        ans=format(answer);
        
        return ans;
    }
    public static String format(int time){
        int h=time/60;
        int m=time%60;
        String H=h+"";
        if(h<10){
            H="0"+h;
        }
        String M=m+"";
        if(m<10){
            M="0"+m;
        }
        return H+":"+M;
    }
    
    public static int calTime(String time){
        String[] tmp=time.split(":");
        int h=Integer.parseInt(tmp[0])*60;
        int m=Integer.parseInt(tmp[1]);
        return h+m;
    }
    
    
    
}