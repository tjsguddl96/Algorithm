import java.util.*;
import java.io.*;
public class Main {
    static int[] n;
    static int[] dp;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str=bf.readLine();
        N=str.length();
        n=new int[str.length()];
        dp=new int[N];
        for(int i=0;i<str.length();i++){
            n[i]=str.charAt(i)-'0';
            dp[i]=-1;
        }
        int answer=solve(0);

        System.out.println(solve(0));
    }
    public static int solve(int idx){
        if(idx>=N){
            if(idx==N) {
                return 1;
            }
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int result=0;
        if(n[idx]==0){
            return 0;
        }
        //next 안 붙이는 경우
        result+=solve(idx+1);

        //next 붙이는 경우
        if(idx+1<N && n[idx]*10+n[idx+1]>=1 && n[idx]*10+n[idx+1]<35) {
            result += solve(idx + 2);
        }
        dp[idx]=result;
        return dp[idx];
    }
}