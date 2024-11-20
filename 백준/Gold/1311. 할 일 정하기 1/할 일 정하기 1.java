import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[][] w;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        w=new int[N][N];
        StringTokenizer st;
        dp=new int[N][1<<N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                w[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<(1<<N);j++){
                dp[i][j]=-1;
            }
        }
        System.out.println(solve(0,0));


    }
    //dp[idx][지금까지 일한 애들]
    //10001 -> 1번과 5번이 일함

    static public int solve(int idx,int cnt){
        if(idx==N){
            return 0;
        }
        if(dp[idx][cnt]!=-1){
            return dp[idx][cnt];
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            if((cnt&(1<<i))==0){
                min=Math.min(min,w[idx][i]+solve(idx+1,cnt|(1<<i)));
            }
        }
        dp[idx][cnt]=min;
        return dp[idx][cnt];
    }
}
/*
4
2 3 3 1
3 2 3 1
3 3 2 1
2 3 3 1
->7
* */