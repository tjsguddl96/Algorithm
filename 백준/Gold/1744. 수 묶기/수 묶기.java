import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static PriorityQueue<Integer> pq1=new PriorityQueue<>(Collections.reverseOrder());
    static int zeroCnt,oneCnt;
    static long answer;
    static PriorityQueue<Integer> pq2=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        for(int i=0;i<N;i++){
            int now=Integer.parseInt(bf.readLine());
            if(now>1){
                pq1.add(now);
            }
            else if(now<0){
                pq2.add(now);
            }
            else if(now==1){
                oneCnt++;
            }
            else{
                zeroCnt++;
            }
        }
        while(!pq1.isEmpty()){
            int now1=pq1.poll();
            int now2=1;
            if(!pq1.isEmpty()){
                now2=pq1.poll();
            }
            answer+=(now1*now2);
//            System.out.println(answer+"!");
        }
        int tmp=0;
        while(!pq2.isEmpty()){
            int now1=pq2.poll();
            int now2=0;
            if(!pq2.isEmpty()){
                now2=pq2.poll();
            }
            if(now2!=0) {
//                System.out.println(now1+" "+now2);
                answer += (now1 * now2);
//                System.out.println(answer+"@");
            }
            else{
                tmp=now1;
            }
        }
        if(zeroCnt>=1){
            tmp=0;
        }
        answer+=(tmp+oneCnt);
        System.out.println(answer);

    }
}

/*
3
-4
-4
-6
=> 20

3
-4
-4
6
=> 22

4
-3
-2
0
2
=> 8

5
-5
-3
-2
0
2
=> 17
* */