import java.util.*;
import java.io.*;

public class Main {
    static int K;
    static int T;
    static long answer;
    static PriorityQueue<Long> pq;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++) {
            answer=0;
            K=Integer.parseInt(bf.readLine());
            pq=new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < K; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            while(!pq.isEmpty()){
                long n1=pq.poll();
                if (pq.isEmpty()) {
                    break;
                }
                long n2=pq.poll();
                answer+=(n1+n2);
                pq.add(n1+n2);
            }
            System.out.println(answer);
        }
    }
}