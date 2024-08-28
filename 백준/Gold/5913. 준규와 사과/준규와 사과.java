import java.util.*;
import java.io.*;

public class Main {
    static int N=5;
    static int K;
    static int[][] map;
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        K=Integer.parseInt(bf.readLine());
        StringTokenizer st;
        map=new int[N+1][N+1];
        for(int i=0;i<K;i++){
            st=new StringTokenizer(bf.readLine());
            int y=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            map[y][x]=-1;
        }
        map[1][1]=1;
        solve(1,1,0);
        System.out.println(answer);

    }
    public static void solve(int nowY,int nowX,int cnt){
        if(nowY==5 && nowX==5 && cnt==(25-K-1)){
            answer++;
            return ;
        }
        for(int i=0;i<4;i++){
            int nextY=nowY+dy[i];
            int nextX=nowX+dx[i];
            if(isIn(nextY,nextX)){
                map[nextY][nextX]=1;
                solve(nextY,nextX,cnt+1);
                map[nextY][nextX]=0;
            }
        }


    }
    public static boolean isIn(int y,int x){
        if(y>0 && y<N+1 && x>0 && x<N+1 && map[y][x]==0){
            return true;
        }
        return false;
    }
}
/*
2
2 1
1 2

5
1 3
2 3
3 3
4 3
* */