import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[][] map;
    static int[][] time;
    static int[][] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N+1][N+1];
        dist=new int[N+1][N+1];
        time=new int[M][3];
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=1;j<N+1;j++){
                int d=Integer.parseInt(st.nextToken());
                if(d==0){
                    map[i][j]=999999999;
                }else {
                    map[i][j] = d;
                }
            }
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<3;j++){
                time[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int k=1;k<N+1;k++){
            for(int i=1;i<N+1;i++){
                for(int j=1;j<N+1;j++){
                    map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }
        for(int i=0;i<M;i++){
            int start=time[i][0];
            int end=time[i][1];
            int t=time[i][2];
            if(map[start][end]>t){
                System.out.println("Stay here");
            }else{
                System.out.println("Enjoy other party");
            }
        }

    }

}
