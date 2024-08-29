import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[][] map;
    static int[][] ch;
    static int[] dy={-1,-1,-1,0,0,1,1,1};
    static int[] dx={-1,0,1,-1,1,-1,0,1};
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        ch=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(ch[i][j]==0){
                    boolean flag=solve(i,j,map[i][j]);
                    if(flag){
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);




    }
    public static boolean solve(int nowY,int nowX,int now){
        for(int i=0;i<8;i++){
            int nextY=nowY+dy[i];
            int nextX=nowX+dx[i];
            if(isIn(nextY,nextX) && now<map[nextY][nextX]){
                return false;
            }
        }
        boolean flag=true;
        for(int i=0;i<8;i++){
            int nextY=nowY+dy[i];
            int nextX=nowX+dx[i];
            if(isIn(nextY,nextX) && now==map[nextY][nextX] && ch[nextY][nextX]==0){
                ch[nextY][nextX]=1;
                flag&=solve(nextY,nextX,now);
            }
        }
        return flag;
    }
    public static boolean isIn(int y,int x){
        if(y>=0 && y<N && x>=0 && x<M){
            return true;
        }
        return false;
    }
}

/*
8 7
4 3 2 2 1 0 1
3 4 4 4 5 5 1
2 2 2 2 1 0 0
2 1 1 1 1 0 0
1 1 0 0 0 1 0
0 0 0 1 1 1 0
0 1 2 2 1 1 0
0 1 1 1 2 1 0
->2

2 2
1 1
1 1

1 1
3

4 5
1 1 1 1 1
1 2 2 2 2
2 2 2 2 2
3 1 1 1 1
* */