import java.io.*;
import java.util.*;

public class Main {
    static int N,M; //n:강의장 수, m:공사구간 수, k:돌 수
    static long K;
    static int[] parent;
    static HashMap<Integer,Integer> ban=new HashMap<>();
    static PriorityQueue<Bridge> pq=new PriorityQueue<>();
    static class Bridge implements Comparable<Bridge>{
        int n1;
        int n2;
        int w;
        public Bridge(int n1,int n2,int w){
            this.n1=n1;
            this.n2=n2;
            this.w=w;
        }
        @Override
        public int compareTo(Bridge o){
            return this.w-o.w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Long.parseLong(st.nextToken());
        parent=new int[N+1];
        for(int i=0;i<N+1;i++){
            parent[i]=i;
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            int stone=Integer.parseInt(st.nextToken());
            pq.add(new Bridge(0,i,stone));
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int now=Math.min(n1,n2);
            int next=Math.max(n1,n2);
            if(now==1 && next==N){
                now=N;
                next=1;
            }
            ban.put(now,next);
        }
        for(int i=1;i<N+1;i++){
            //now = i, next=i+1; 만약 i==N 이면 next=1
            int now=i;
            int next;
            if(now==N){
                next=1;
            }
            else{
                next=i+1;
            }
            if(ban.get(now)==null || ban.get(now)!=next){
                union(now,next);
            }
        }
        long totalStone=0L;
        boolean flag=true;
        for(int i=1;i<N+1;i++){
            if(findParent(i)!=1){
                flag=false;
                break;
            }
        }
        if(flag==false) {
            while (!pq.isEmpty()) {
                Bridge now = pq.poll();
                int nowN1 = now.n1;
                int nowN2 = now.n2;
                int nowW = now.w;
                if (findParent(nowN1) != findParent(nowN2)) {
                    union(nowN1, nowN2);
                    totalStone += nowW;
                }
            }
        }
        String answer="NO";
        if(totalStone<=K){
            answer="YES";
        }
        System.out.println(answer);

    }
    public static int findParent(int x){
        if(x==parent[x]){
            return x;
        }
        return findParent(parent[x]);
    }
    public static void union(int a,int b){
        int parentA=findParent(a);
        int parentB=findParent(b);
        if(parentA<parentB){
            parent[parentB]=parentA;
        }
        else{
            parent[parentA]=parentB;
        }

    }
}
/*
5 1 9
2 1 3 2 5
2 3

3 1 0
1 2 3
1 3
->YES

3 0 0
1 2 3
* */