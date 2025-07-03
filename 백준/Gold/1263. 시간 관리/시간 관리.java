import java.util.*;
import java.io.*;

/*
* */
public class Main {
    static int N;
    static class Time implements Comparable<Time>{
        int t;
        int s;
        public Time(int t, int s){
            this.t=t;
            this.s=s;
        }
        @Override
        public int compareTo(Time o){
            return o.s-this.s;
        }
    }
    //무조건 시작해야 하는 시간 = s-t에는 무조건 시작해야함
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
//        StringBuilder answer=new StringBuilder();

        PriorityQueue<Time> pq=new PriorityQueue<>();
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(bf.readLine());
            int t=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            pq.add(new Time(t,s));
        }

        /*
        7
        3 5
        3 5
        3 5 --> 3 2

        nowS-nowT=tmp=2
        nowS=5

        endTime=20 -> 15 -> 14 -> 5
        startTime=15 -> 14 -> 6 -> 2
        * */
        Time first=pq.poll();
        int endTime=first.s;
        int startTime=endTime-first.t;
        while(!pq.isEmpty()){
            Time now=pq.poll();
            int nowT=now.t;
            int nowS=now.s;
            int tmp=nowS-nowT;
            if(nowS<=startTime || tmp>=endTime){
                endTime=nowS;
                startTime=endTime-now.t;
            }
            else{ //이전꺼랑 겹침 ->다시 넣어줘
                pq.add(new Time(nowT,startTime));
            }
        }
        if(startTime<0){
            startTime=-1;
        }
        System.out.println(startTime);


    }


}

/*
6
3 5
3 5
3 5
8 14
5 20
1 16
->0


7
3 5
3 5
3 5
3 5
8 14
5 20
1 16
->-1

2
10 100
5 100   // 5 90
->
90 100
95 100
* */