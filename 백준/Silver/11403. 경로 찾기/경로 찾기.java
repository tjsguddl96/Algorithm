import java.util.*;
import java.io.*;


public class Main{

    static int N;
    static int[][] arr;
    static int INF=Integer.MAX_VALUE;
    public static void main(String[] Args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());

        arr=new int[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                int now=Integer.parseInt(st.nextToken());
                if(now==1) {
                    arr[i][j] = 1;
                }
                else{
                    arr[i][j]=INF;
                }
            }
        }


        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(arr[i][k]==1 && arr[k][j]==1){
                        arr[i][j]=1;
                    }
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]==INF){
                    System.out.print(0+" ");
                }
                else{
                    System.out.print(1+" ");
                }
            }
            System.out.println();
        }

    }
}