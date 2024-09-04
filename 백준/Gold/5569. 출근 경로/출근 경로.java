import java.util.*;
import java.io.*;
public class Main {
    static int W,H;
    static int[][][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        W=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        dp=new int[H+1][W+1][2][2]; //[y][x][방향][교차로돈여부]

        for(int i=1;i<W+1;i++){ //0-> 수평 , 1-> 수직 , 1->이미 돌앗
            dp[1][i][0][0]=1;
        }
        for(int i=1;i<H+1;i++){
            dp[i][1][1][0]=1;
        }

        for(int i=2;i<H+1;i++){
            for(int j=2;j<W+1;j++){
                dp[i][j][0][0]=dp[i][j-1][0][0]%100000+dp[i][j-1][0][1]%100000;
                dp[i][j][0][1]=dp[i][j-1][1][0]%100000;
                dp[i][j][1][0]=dp[i-1][j][1][0]%100000+dp[i-1][j][1][1]%100000;
                dp[i][j][1][1]=dp[i-1][j][0][0]%100000;
            }
        }
        int answer=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                answer+=(dp[H][W][i][j]%100000);
            }
        }
        System.out.println(answer%100000);


    }
}