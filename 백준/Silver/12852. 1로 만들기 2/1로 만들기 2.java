import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] dp;
    static StringBuilder answer=new StringBuilder();
    static ArrayList<Integer>[] ans;
    static int INF=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(bf.readLine());
        dp=new int[N+1];
        ans=new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            dp[i]=INF;
            ans[i]=new ArrayList<>();
        }
        dp[1]=0;
        answer.append(N+" ");
        for(int i=2;i<N+1;i++){
            int tmp=0;
            if(i%3==0){
                if(dp[i]>dp[i/3]+1){
                    dp[i]=dp[i/3]+1;
                    tmp=(i/3);
                }
            }
            if(i%2==0){
                if(dp[i]>dp[i/2]+1) {
                    dp[i] = dp[i / 2] + 1;
                    tmp=(i/2);
                }
            }
            if(dp[i]>dp[i-1]+1){
                dp[i]=dp[i-1]+1;
                tmp=i-1;
            }
            ans[i].add(tmp);
        }
        int now=N;
        while(ans[now].size()!=0){
            now=ans[now].get(0);
            answer.append(now+" ");
        }
        bw.flush();
        bw.write(dp[N]+"\n");
        bw.write(answer.toString());
        bw.close();
    }
}