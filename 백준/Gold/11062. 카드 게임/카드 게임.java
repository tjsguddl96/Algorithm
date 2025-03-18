import java.util.*;
import java.io.*;
public class Main {
    static int T,N;
    static int[][] dp;
    static int[] cards;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            N=Integer.parseInt(bf.readLine());
            st=new StringTokenizer(bf.readLine());
            dp=new int[N][N];
            cards=new int[N];
            for(int i=0;i<N;i++){
                cards[i]=Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    dp[i][j]=-1;
                }
            }
            System.out.println(solve(0,N-1,true));
        }

    }
    //turn이 true=>선우, false=>명우
    public static int solve(int left,int right,boolean turn){
        if(left>right){
            return 0;
        }
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        if(turn){
            dp[left][right]=Math.max(cards[left]+solve(left+1,right,false),cards[right]+solve(left,right-1,false));
        }
        else{
            dp[left][right]=Math.min(solve(left+1,right,true),solve(left,right-1,true));
        }
        return dp[left][right];
    }
}
