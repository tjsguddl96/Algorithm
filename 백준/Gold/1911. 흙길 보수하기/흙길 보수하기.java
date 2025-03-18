import java.util.*;
import java.io.*;
public class Main {
    static int N,L;
    static class Hole implements Comparable<Hole>{
        int start;
        int end;
        public Hole(int start,int end){
            this.start=start;
            this.end=end;
        }
        @Override
        public int compareTo(Hole o){
            return this.start-o.start;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        PriorityQueue<Hole> pq=new PriorityQueue<>();
        long answer=0;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            pq.add(new Hole(start,end-1));
        }

        while(!pq.isEmpty()){
            Hole now=pq.poll();
            int start=now.start;
            int end=now.end;
            int length=end-start+1;
            int cnt=0;
            if(length%L==0){
                cnt=length/L;
            }
            else{
                cnt=length/L+1;
            }
            int last=start+(cnt-1)*L;
            int lastOne=0;
            while(!pq.isEmpty() && pq.peek().start<=(last+L-1)){
                Hole next=pq.poll();
                if(next.end>=last+L) {
                    pq.add(new Hole(last + L, next.end));
                }
            }


            answer+=cnt;

        }

        System.out.println(answer);
    }
}

/**
6 10
0 1
1 2
2 3
3 4
4 5
5 6

 */
