import java.util.*;
import java.io.*;
public class Main {
    static int MOD=1000000;
    static String N;
    static int L;
    static long[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=bf.readLine();
        L=N.length();
        dp=new long[L+1][27];
        for(int i=0;i<N.length()+1;i++){
            for(int j=0;j<27;j++){
                dp[i][j]=-1;
            }
        }
        long answer=solve(1,N.charAt(0)+"");
        if(N.charAt(0)=='0'){
            answer=0;
        }
        if(answer==-1){
            answer=0;
        }
        System.out.println(answer);
    }

    public static long solve(int depth,String number){
        if(depth==L){
            dp[depth][Integer.parseInt(number)]=1;
            return 1L;
        }
        if(dp[depth][Integer.parseInt(number)]!=-1){
            return dp[depth][Integer.parseInt(number)];
        }
        long tmp=0L;
        if(N.charAt(depth)!='0') {
            tmp = solve(depth + 1, N.charAt(depth) + "");
        }
        String next=N.charAt(depth)+"";
        long tmp2=0;
        if(Integer.parseInt(number)!=Integer.parseInt(number+next) && Integer.parseInt(number+next)<27){
            tmp2=solve(depth+1,number+next);
        }
        dp[depth][Integer.parseInt(number)]=(tmp%MOD+tmp2%MOD)%MOD;

        return dp[depth][Integer.parseInt(number)]%MOD;
    }

}
/*
1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
->84101

27 ->1

20114 ->3

20114 --> 정답: 3   /   1010 --> 정답: 1   /   111012 --> 정답: 4

1131212501112122 --> 정답: 0

* */