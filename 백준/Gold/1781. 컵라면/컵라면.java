import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static class Node implements Comparable<Node>{
        int deadLine;
        long cup;
        public Node(int deadLine,long cup){
            this.deadLine=deadLine;
            this.cup=cup;
        }
        @Override
        public int compareTo(Node o){
            int x=o.deadLine-this.deadLine;
            if(x==0){
                if(this.cup<o.cup){
                    x=1;
                }
                else if(this.cup==o.cup){
                    x=0;
                }
                else{
                    x=-1;
                }
            }
            return x;
        }
        @Override
        public String toString(){
            return this.deadLine+" "+this.cup;
        }
    }
    static long answer;
    static PriorityQueue<Node> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            int deadLine=Integer.parseInt(st.nextToken());
            long cup=Long.parseLong(st.nextToken());
            pq.add(new Node(deadLine,cup));
        }
        PriorityQueue<Long> tmp=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=N;i>=1;i--){
            while(!pq.isEmpty() && pq.peek().deadLine==i){
                tmp.add(pq.peek().cup);
                pq.poll();
            }
            if(!tmp.isEmpty()){
                answer+=tmp.poll();
            }
        }
        System.out.println(answer);
    }
}
/*
7
1 6
1 7
3 2
3 1
2 4
2 5
6 1
6 10
4 8
5 8

* */