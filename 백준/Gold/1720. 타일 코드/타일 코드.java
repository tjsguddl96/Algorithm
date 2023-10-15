import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long[] dp;

    static int N;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        dp=new long[N+1];
        dp[0]=0L;
        if(N==1){
            answer=1;
            System.out.println(answer);
            return;
        }
        else if(N==2){
            answer=3;
            System.out.println(answer);
            return ;
        }
        dp[1]=1L;
        dp[2]=3L;


        for(int i=3;i<=N;i++){
            dp[i]=dp[i-1]+2*dp[i-2];
            long tmp=0L;
            if(i%2==0){
                tmp=dp[i/2]+dp[(i-2)/2]*2;
            }else{
                tmp=dp[(i-1)/2];
            }
            answer=tmp+((dp[i]-tmp)/2);
        }
        if(N==1){
            answer=1;
        }
        else if(N==2){
            answer=3;
        }
        System.out.println(answer);
    }

}