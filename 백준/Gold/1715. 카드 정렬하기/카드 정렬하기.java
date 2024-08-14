import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static long answer;
    static PriorityQueue<Long> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        for(int i=0;i<N;i++){
            pq.add(Long.parseLong(bf.readLine()));
        }
        while(!pq.isEmpty()){
            long a=pq.poll();
            if(!pq.isEmpty()){

                long b = pq.poll();
                long sum = a + b;
                pq.add(sum);
                answer += sum;
            }
        }
        System.out.println(answer);
    }
}