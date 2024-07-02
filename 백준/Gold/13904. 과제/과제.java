import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static class Work implements Comparable<Work>{
        int d;
        int w;
        public Work(int d,int w){
            this.d=d;
            this.w=w;
        }
        @Override
        public int compareTo(Work o){
            int x=o.w-this.w;
            if(x==0){
                x=o.d-this.d;
            }
            return x;
        }
    }
    static int[] dp;
    static PriorityQueue<Work> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        dp=new int[1001];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            int d=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            pq.add(new Work(d,w));
        }
        while(!pq.isEmpty()){
            Work now=pq.poll();
            int nowD=now.d;
            int nowW=now.w;
//            System.out.println(nowD+" "+nowW);
            for(int i=nowD;i>=1;i--){
                if(dp[i]<nowW){
                    dp[i]=nowW;
                    break;
                }
            }
        }
        int answer=0;
        for(int i=1;i<1001;i++){
//            if(dp[i]!=0){
//                System.out.println(i+" "+dp[i]);
//            }
            answer+=dp[i];
        }
        System.out.println(answer);

    }
    public static int binary(int d,int w){
        int left=1;
        int right=d;
        int Mid=0;
        while(left<=right){
            int mid=(left+right)/2;
            if(dp[mid]>=w){
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