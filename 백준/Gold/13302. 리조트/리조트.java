//import java.util.*;
//import java.io.*;
//public class Main {
//    static int N,M;
//    static int[] holidays;
//    static int[][] dp;
//    static int INF=Integer.MAX_VALUE;
//    public static void main(String[] args) throws IOException{
//        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st=new StringTokenizer(bf.readLine());
//        N=Integer.parseInt(st.nextToken());
//        M=Integer.parseInt(st.nextToken());
//        holidays=new int[N+1];
//        dp=new int[N+1][N+1];
//        st=new StringTokenizer(bf.readLine());
//        for(int i=0;i<M;i++){
//            holidays[Integer.parseInt(st.nextToken())]=1;
//        }
//        for(int i=1;i<N+1;i++){
//            for(int j=0;j<N+1;j++){
//                dp[i][j]=INF;
//            }
//        }
//        System.out.println(solve(1,0));
//
//    }
//    public static int solve(int day,int coupon){
//        if(day>N){
//            return 0;
//        }
//        if(dp[day][coupon]!=INF){
//            return dp[day][coupon];
//        }
//        if(holidays[day]==1){
//            dp[day][coupon]=Math.min(dp[day][coupon],solve(day+1,coupon));
//            return dp[day][coupon];
//        }
//        else {
//            if (coupon >= 3) {
//                dp[day][coupon] = Math.min(dp[day][coupon], solve(day + 1, coupon - 3));
//            }
//            dp[day][coupon] = Math.min(dp[day][coupon], solve(day + 1, coupon) + 10000);
//            dp[day][coupon] = Math.min(dp[day][coupon], solve(day + 3, coupon + 1) + 25000);
//            dp[day][coupon] = Math.min(dp[day][coupon], solve(day + 5, coupon + 2) + 37000);
//        }
//        return dp[day][coupon];
//    }
//}

import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int INF=Integer.MAX_VALUE;
    static boolean[] holiday;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        holiday = new boolean[n+1];

        if(m>0) {
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<m; i++) {
                holiday[Integer.parseInt(st.nextToken())] = true;
            }
        }

        dp = new int[n+1][n+1];

        for(int i=1;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j]=INF;
            }
        }

        System.out.println(solve(1, 0));

    }

    static int solve(int day, int coupon) {

        if(day > n) return 0;

        if(dp[day][coupon]!=INF) return dp[day][coupon];

        if(holiday[day]) {
            return dp[day][coupon] = Math.min(dp[day][coupon], solve(day+1, coupon));
        }
        else {
            if(coupon >= 3 ) {
                dp[day][coupon] = Math.min(dp[day][coupon], solve(day+1, coupon-3));
            }
            dp[day][coupon] = Math.min(dp[day][coupon], solve(day+1, coupon)+ 10000);
            dp[day][coupon] = Math.min(dp[day][coupon], solve(day+3, coupon+1) +25000);
            dp[day][coupon] = Math.min(dp[day][coupon], solve(day+5, coupon+2) + 37000);

        }

        return dp[day][coupon];
    }
}