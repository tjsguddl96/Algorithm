import java.util.*;
import java.io.*;

public class Main {
    static int N,K;
    static int[][] dist;
    static int[] ch;
    static int[][] ch2;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        dist=new int[N][N];
        ch2=new int[N][N];
        ch=new int[N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                dist[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }


        ch[K]=1;
        solve(K,0);
        if(answer==Integer.MAX_VALUE){
            answer=0;
        }
        System.out.println(answer);

    }
    public static void solve(int now,int totalDist){
        boolean flag=true;
        for(int i=0;i<N;i++){
            if(ch[i]==0){
                flag=false;
                break;
            }
        }
        if(flag){
            answer=Math.min(answer,totalDist);
            return ;
        }
        for(int i=0;i<N;i++){
            if(i==now){
                continue;
            }
            if(ch[i]==0){
                ch[i]=1;
                solve(i,totalDist+dist[now][i]);
                ch[i]=0;
            }
        }
    }
}
/*
3 0
0 2 1
1 0 29
2 5 0
->4

2 0
0 10
1 0
* */