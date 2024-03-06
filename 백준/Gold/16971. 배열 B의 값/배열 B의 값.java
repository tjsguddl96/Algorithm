import java.io.*;
import java.util.*;

public class Main {
    static int N,M; //N이 행, M이 열
    static int[][] A;
    static int[][] sumRow;
    static int[][] sumCol;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        A=new int[N][M];
        sumRow=new int[N+1][M+1];
        sumCol=new int[N+1][M+1];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                A[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if(j==1 || j==M){
                    sumRow[i][j]=sumRow[i][j-1]+A[i-1][j-1];
                }
                else{
                    sumRow[i][j]=sumRow[i][j-1]+(A[i-1][j-1]*2);
                }
            }
        }
        for(int i=1;i<M+1;i++){
            for(int j=1;j<N+1;j++){
                if(j==1 || j==N){
                    sumCol[j][i]=sumCol[j-1][i]+A[j-1][i-1];
                }
                else{
                    sumCol[j][i]=sumCol[j-1][i]+(A[j-1][i-1]*2);
                }
            }
        }
        int answer=Integer.MIN_VALUE;
        for(int i=1;i<N;i++){
            int tmp=sumRow[N][M];
            for(int j=1;j<N;j++){
                if(j==i){
                    tmp+=sumRow[j][M];
                }
                else{
                    tmp+=(sumRow[j][M]*2);
                }
            }
            if(answer<tmp){
                answer=tmp;
            }
        }
        for(int i=N;i>=2;i--){
            int tmp=sumRow[1][M];
            for(int j=N;j>=2;j--){
                if(j==i){
                    tmp+=sumRow[j][M];
                }
                else{
                    tmp+=(sumRow[j][M]*2);
                }
            }
            if(answer<tmp){
                answer=tmp;
            }
        }

        for(int i=1;i<M;i++){
            int tmp=sumCol[N][M];
            for(int j=1;j<M;j++){
                if(j==i){
                    tmp+=sumCol[N][j];
                }
                else{
                    tmp+=(sumCol[N][j]*2);
                }
            }
            if(answer<tmp){
                answer=tmp;
            }
        }
        for(int i=M;i>=2;i--){
            int tmp=sumCol[N][1];
            for(int j=M;j>=2;j--){
                if(j==i){
                    tmp+=sumCol[N][j];
                }
                else{
                    tmp+=(sumCol[N][j]*2);
                }
            }
            if(answer<tmp){
                answer=tmp;
            }
        }

        System.out.println(answer);

    }
}
/*
3 3
6 5 4
3 2 1
9 8 7
->92
* */