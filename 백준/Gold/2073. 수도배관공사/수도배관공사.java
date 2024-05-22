import java.util.*;
import java.io.*;

public class Main {
    static int D,P;
    static class Pipe{
        int l;
        int c;
        public Pipe(int l,int c){
            this.l=l;
            this.c=c;
        }
    }
    static Pipe[] pipes;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        D=Integer.parseInt(st.nextToken());
        P=Integer.parseInt(st.nextToken());
        pipes=new Pipe[P+1];
        dp=new int[P+1][D+1];
//        for(int i=0;i<P+1;i++){
//            for(int j=0;j<D+1;j++){
//                dp[i][j]=Integer.MAX_VALUE;
//            }
//        }
        for(int i=1;i<P+1;i++){
            st=new StringTokenizer(bf.readLine());
            int l=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            pipes[i]=new Pipe(l,c);
            dp[i][l]=c;
        }
        for(int i=1;i<P+1;i++){
            Pipe now=pipes[i];
            for(int j=0;j<D+1;j++){
                if(j>now.l && dp[i-1][j-now.l]!=Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(now.c, dp[i - 1][j - now.l]);
                }
                dp[i][j]=Math.max(dp[i][j],dp[i-1][j]);
            }
        }

//        for(int i=1;i<P+1;i++){
//            System.out.print(i +" : " );
//            for(int j=1;j<D+1;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[P][D]);
    }
}
/*
7 6
3 6
4 5
2 7
1 4
6 7
1 5
* */