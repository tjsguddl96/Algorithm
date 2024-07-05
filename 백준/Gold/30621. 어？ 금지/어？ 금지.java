import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static class Time implements Comparable<Time>{
        int t1;
        int t2;
        int c;
        public Time(int t1,int t2,int c){
            this.t1=t1;
            this.t2=t2;
            this.c=c;
        }
        @Override
        public int compareTo(Time o){
            int x=this.t2-o.t2;
            if(x==0){
                x=this.t1-o.t1;
            }
            return x;
        }
    }
    static int[] t;
    static int[] b;
    static int[] c;
    static long[] dp;
    static Time[] times;

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        t=new int[N+1];
        b=new int[N+1];
        c=new int[N+1];
        dp=new long[N+1];
        times=new Time[N+1];
        times[0]=new Time(0,0,0);
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            t[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            b[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            c[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N+1;i++){
            times[i]=new Time(t[i]-b[i],t[i],c[i]);
        }
        Arrays.sort(times);
        long answer=0L;
        for(int i=1;i<N+1;i++){
            int idx=binary(times[i].t1-1);
            dp[i]=Math.max(times[i].c+dp[idx],answer);
            answer=Math.max(answer,dp[i]);
        }
        System.out.println(answer);

    }
    public static int binary(int t){ //t1
        int left=0;
        int right=N;
        int Mid=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(times[mid].t2>t){
                right=mid-1;
            }
            else{
                Mid=mid;
                left=mid+1;
            }
        }
        return Mid;
    }
}
/*
8
1 2 5 7 7 8 10 13
1 1 2 3 1 5 10 2
4 5 20 30 20 15 5 100

7
1 2 5 7 7 8 10
1 1 2 3 1 5 10
4 5 20 30 20 15 5
* */