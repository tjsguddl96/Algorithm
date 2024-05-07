import java.util.*;
import java.io.*;

public class Main {
    static long N;
    static int M;
    static int[] time;
    static long Mid;
    static long answer=1L;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Long.parseLong(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        time=new int[M];
        st=new StringTokenizer(bf.readLine());
        int max=0;
        for(int i=0;i<M;i++){
            time[i]=Integer.parseInt(st.nextToken());
            max=Math.max(max,time[i]);
        }
        long left=0L;
        long right=max*N;
        long mid=0L;
        long cnt=0L;
        while(left<=right){
            mid=(left+right)/2;
//            System.out.println(left+" "+right+" "+mid);
            cnt=0L;
            for(int i=0;i<M;i++){
                if(mid%time[i]!=0){
                    cnt+=(mid/time[i]+1);
                }
                else {
                    cnt += mid / time[i];
                }
            }
            if(cnt>=N){
                right=mid-1;
            }
            else{
                Mid=mid;
                left=mid+1;
            }
        }
//        System.out.println(Mid);
//        System.out.println(mid+" "+cnt);
        cnt=0L;
        for (int i = 0; i < M; i++) {
            if(Mid%time[i]!=0){
                cnt+=(Mid/time[i]+1);
            }
            else {
                cnt += Mid / time[i];
            }
        }
//        System.out.println(Mid+" "+cnt+"!");
        for(int i=0;i<M;i++){
            if(Mid%time[i]==0){
                cnt++;
            }
            if(cnt==N){
                answer=i+1;
                break;
            }
        }


        System.out.println(answer);
    }
}
/*
24 5
1 2 2 4 4
->4
* */