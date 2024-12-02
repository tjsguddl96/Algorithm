import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int answer;
    static PriorityQueue<Integer> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }
        int wait=0;
        while(!pq.isEmpty()){
            int now=pq.poll();
            answer+=now;
            answer+=(wait);
            wait+=now;
        }
        System.out.println(answer);


    }
}