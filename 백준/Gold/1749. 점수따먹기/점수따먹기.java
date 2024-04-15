import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] arr;
    static long[][] sum;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N+1][M+1];
        sum=new long[N+1][M+1];
        long max=Long.MIN_VALUE;
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=1;j<M+1;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                max=Math.max(max,arr[i][j]);
            }
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                sum[i][j]=sum[i][j-1]+sum[i-1][j]-sum[i-1][j-1]+arr[i][j];
                max=Math.max(max,sum[i][j]);
            }
        }
        for(int startY=1;startY<N+1;startY++){
            for(int startX=1;startX<M+1;startX++){
                for(int endY=startY;endY<N+1;endY++){
                    for(int endX=startX;endX<M+1;endX++){
                        max=Math.max(max,sum[endY][endX]-sum[endY][startX-1]-sum[startY-1][endX]+sum[startY-1][startX-1]);
                    }
                }
            }
        }
        System.out.println(max);
    }
}