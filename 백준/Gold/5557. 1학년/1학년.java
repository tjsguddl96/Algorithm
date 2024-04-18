import java.util.*;
import java.io.*;
public class Main {
    //answer은 Long 타입이여야함
    static int N;
    static long[][] dp;
    static int[] num;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        num=new int[N];
        dp=new long[N][21];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        dp[0][num[0]]=1;
        for(int i=1;i<N;i++){
            int now=num[i];
            for(int j=0;j<21;j++){
                if(dp[i-1][j]!=0){
                    if(j+now>=0 && j+now<=20){
                        dp[i][j+now]+=dp[i-1][j];
                    }
                    if(j-now>=0 && j-now<=20){
                        dp[i][j-now]+=dp[i-1][j];
                    }
                }

            }
        }
        System.out.println(dp[N-2][num[N-1]]);
    }
}