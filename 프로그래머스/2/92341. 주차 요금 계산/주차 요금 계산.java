import java.util.*;
class Solution {
    static class Car implements Comparable<Car>{
        
        int carNumber;
        long time;
        public Car(int carNumber,long time){
            this.carNumber=carNumber;
            this.time=time;
        }
        @Override
        public int compareTo(Car o){
            return this.carNumber-o.carNumber;
        }
    }
    static String maxTime="23:59";
    static HashMap<Integer,Integer> map=new HashMap<>(); //map[carnumber]=idx;
    static HashMap<Integer,Integer> map2=new HashMap<>(); //map[carnumber]=idx;
    static Stack<String>[] stack;
    static int[] times;
    static int n; //차 갯수
    public long[] solution(int[] fees, String[] records) {
        long[] answer;
        for(int i=0;i<records.length;i++){
            String[] str=records[i].split(" ");
            int carNumber=Integer.parseInt(str[1]);
            if(!map.containsKey(carNumber)){
                map.put(carNumber,n);
                map2.put(n,carNumber);
                n++;
            }
        }
        stack=new Stack[n];
        times=new int[n];
        answer=new long[n];
        PriorityQueue<Car> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            stack[i]=new Stack<>();
        }
        for(int i=0;i<records.length;i++){
            String[] str=records[i].split(" ");
            String time=str[0];
            int carIdx=map.get(Integer.parseInt(str[1]));
            String flag=str[2];
            if(flag.equals("IN")){
                stack[carIdx].add(time);
            }
            else{
                String inTime=stack[carIdx].pop();
                times[carIdx]+=calTime(inTime,time);
            }
        }
        for(int i=0;i<n;i++){
            if(!stack[i].isEmpty()){
                String inTime=stack[i].pop();
                times[i]+=calTime(inTime,maxTime);
            }
        }
        for(int i=0;i<n;i++){
            int time=times[i];
            long ans=fees[1];
            if(time>fees[0]){
                int fare=(time-fees[0])/fees[2];
                if((time-fees[0])%fees[2]!=0){
                    fare+=1;
                }
                ans+=(fare*fees[3]);
            }
            int carNumber=map2.get(i);
            pq.add(new Car(carNumber,ans));
            
        }
        int k=0;
        while(!pq.isEmpty()){
            answer[k]=pq.poll().time;
            k++;
        }
        
        return answer;
    }
    public static int calTime(String in,String out){
        int inTime=Integer.parseInt(in.substring(0,2))*60+Integer.parseInt(in.substring(3,5));
        int outTime=Integer.parseInt(out.substring(0,2))*60+Integer.parseInt(out.substring(3,5));
        return outTime-inTime;
    }
    
}