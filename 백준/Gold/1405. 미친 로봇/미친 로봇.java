import java.util.*;
import java.io.*;
public class Main {
    static int[] dy={0,0,1,-1};
    static int[] dx={1,-1,0,0};
    static int N;
    static double[] dir;
    static int[][] ch; //처음 위치 = [15][15]
    static double answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        dir=new double[4]; //동서남북 순
        ch=new int[30][30];
        N=Integer.parseInt(st.nextToken());
        for(int i=0;i<4;i++){
            int n=Integer.parseInt(st.nextToken());
            dir[i]=(double)n/(double)100;
        }
        ch[15][15]=1;
        solve(0,1,15,15);
        System.out.println(answer);
    }
    public static void solve(int depth,double probability,int nowY,int nowX){
        if(depth==N){
            answer+=probability;
            return ;
        }
        for(int i=0;i<4;i++){
            int nextY=nowY+dy[i];
            int nextX=nowX+dx[i];
            if(nextY>=1 && nextY<30 && nextX>=1 && nextX<30 && ch[nextY][nextX]==0){
                ch[nextY][nextX]=1;
                solve(depth+1,probability*dir[i],nextY,nextX);
                ch[nextY][nextX]=0;
            }
        }


    }

}