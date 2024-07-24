import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static HashMap<Integer,Integer> map=new HashMap<>();
    static class Ball implements Comparable<Ball>{
        int idx;
        int c; //색
        int s; //크기
        public Ball(int idx,int c,int s){
            this.idx=idx;
            this.c=c;
            this.s=s;
        }
        @Override
        public int compareTo(Ball o){
            return this.s-o.s;
        }
    }
    static PriorityQueue<Ball> pq=new PriorityQueue<>();
    static int[] ans;
    static int max=400000001;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        ans=new int[N];
        map.put(max,0);
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            int c=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            pq.add(new Ball(i,c,s));
            map.put(c,0);
        }
        while(!pq.isEmpty()){
            Ball now=pq.poll();
            int nowIdx=now.idx;
            int nowC=now.c;
            int nowS=now.s;
            int sumS=now.s;
            HashMap<Integer,Integer> tmp=new HashMap<>();
            ans[nowIdx]=map.get(max)-map.get(nowC);
            tmp.put(nowC,nowS);
//            map.put(nowC,map.get(nowC)+nowS);
//
//            map.put(max,map.get(max)+nowS);

            while(!pq.isEmpty() && pq.peek().s==nowS){
                Ball next=pq.poll();
                int nextIdx=next.idx;
                int nextC=next.c;
                if(tmp.containsKey(nextC)){
                    tmp.put(nextC,tmp.get(nextC)+now.s);
                }
                else{
                    tmp.put(nextC,now.s);
                }
                sumS+=now.s;
                ans[nextIdx]=map.get(max)-map.get(nextC);
            }
            map.put(max,map.get(max)+sumS);
            for(int key:tmp.keySet()){
                map.put(key,map.get(key)+tmp.get(key));
            }

        }

        for(int i=0;i<N;i++){
            answer.append(ans[i]+"\n");
        }
        System.out.println(answer.toString());
    }
}
/*
7
1 3
4 8
4 8
5 8
1 10
5 10
3 15

3
1 1
1 1
1 1
*/