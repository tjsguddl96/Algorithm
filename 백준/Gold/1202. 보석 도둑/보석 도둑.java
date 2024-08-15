import java.util.*;
import java.io.*;
public class Main {
    static int N,K;
    static class Jewel implements Comparable<Jewel>{
        int m; //무게
        int v; //가격
        public Jewel(int m,int v){
            this.m=m;
            this.v=v;
        }
        @Override
        public int compareTo(Jewel o){
            return this.m-o.m;
        }
    }
    static int[] bags;
    static long answer;
    static PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Jewel> jewels=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        bags=new int[K];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            int m=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(m,v));
        }
        for(int i=0;i<K;i++){
            bags[i]=Integer.parseInt(bf.readLine());
        }
        Arrays.sort(bags);
        for(int i=0;i<K;i++){
            while(!jewels.isEmpty() && jewels.peek().m<=bags[i]){
                pq.add(jewels.peek().v);
                jewels.poll();
            }
            if(!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }
}