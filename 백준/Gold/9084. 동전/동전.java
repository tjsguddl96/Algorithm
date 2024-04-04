import java.util.*;
import java.io.*;

public class Main {
    static int T,N,M;
    static int[] coin;
    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        T=Integer.parseInt(bf.readLine());
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        for(int t=0;t<T;t++){
            N=Integer.parseInt(bf.readLine());
            coin=new int[N];
            st=new StringTokenizer(bf.readLine());
            for(int i=0;i<N;i++){
                coin[i]=Integer.parseInt(st.nextToken());
            }
            M=Integer.parseInt(bf.readLine());
            dp=new int[M+1];
            dp[0]=1;
            for(int i=0;i<N;i++){
                for(int j=coin[i];j<M+1;j++){
                    dp[j]+=dp[j-coin[i]];
                }
            }
            answer.append(dp[M]+"\n");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
}