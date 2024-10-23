import java.util.*;
class Solution {
    static class Subject implements Comparable<Subject>{
        String name;
        int start;
        public Subject(String name,int start){
            this.name=name;
            this.start=start;
        }
        @Override
        public int compareTo(Subject o){
            return this.start-o.start;
        }
    }
    static HashMap<String,Integer> remainTime=new HashMap<>();
    static Stack<String> wait=new Stack<>();
    static PriorityQueue<Subject> pq=new PriorityQueue<>();
    static int N;
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        ArrayList<String> ans=new ArrayList<>();
        N=plans.length;
        for(int i=0;i<N;i++){
            String name=plans[i][0];
            int startTime=calTime(plans[i][1]);
            int time=Integer.parseInt(plans[i][2]);
            remainTime.put(name,time);
            pq.add(new Subject(name,startTime));
        }

        while(!pq.isEmpty() || !wait.isEmpty()){
            if(!pq.isEmpty()){
                Subject now=pq.poll();
                String nowName=now.name;
                int nowTime=now.start;
                int rTime=remainTime.get(nowName);
                int nowEndTime=nowTime+rTime;
                if(!pq.isEmpty()){
                    Subject next=pq.peek();
                    if(nowEndTime==next.start){
                        remainTime.put(nowName,0);
                        ans.add(nowName);
                    }
                    else if(nowEndTime<next.start){
                        ans.add(nowName);
                        while(!wait.isEmpty() && nowEndTime+remainTime.get(wait.peek())<=next.start){
                            nowEndTime+=remainTime.get(wait.peek());
                            String waitName=wait.pop();
                            remainTime.put(waitName,0);
                            ans.add(waitName);
                        }
                        if(!wait.isEmpty()) {
                            remainTime.put(wait.peek(), remainTime.get(wait.peek())-(next.start - nowEndTime));
                        }

                    }
                    else{
                        wait.add(nowName);
                        remainTime.put(nowName,rTime-(next.start-nowTime));
                    }
                }
                else{
                    ans.add(nowName);
                }

            }
            if(pq.isEmpty() && !wait.isEmpty()){
                while(!wait.isEmpty()){
                    ans.add(wait.pop());
                }
            }

        }
        for(int i=0;i<ans.size();i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }
    public static int calTime(String time){
        String[] tmp=time.split(":");
        int h=Integer.parseInt(tmp[0])*60;
        int m=Integer.parseInt(tmp[1]);
        return h+m;
    }
}