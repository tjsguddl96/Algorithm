import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static long[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();

        while(true){
            N=Integer.parseInt(bf.readLine());
            if(N==0){
                break;
            }
            dp=new long[N+1][N+1];
            for(int i=0;i<N+1;i++){
                for(int j=0;j<N+1;j++){
                    dp[i][j]=-1;
                }
            }
            answer.append(solution(N,0)+"\n");
        }

        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
    public static long solution(int whole,int half){
        if(whole==0 && half==0){
            return 1;
        }
        if(dp[whole][half]==-1){
            long cnt=0;
            if(whole>0) {
                cnt += solution(whole - 1, half + 1);
            }
            if(half>0) {
                cnt += solution(whole, half - 1);
            }
            dp[whole][half]=cnt;
        }
        return dp[whole][half];
    }
}