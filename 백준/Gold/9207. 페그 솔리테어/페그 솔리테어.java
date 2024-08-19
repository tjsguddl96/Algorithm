import java.util.*;
import java.io.*;
public class Main {
    static int T;
    static char[][] map;
    static int N=5;
    static int M=9;
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static int minFin=Integer.MAX_VALUE;
    static int minMove=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            map=new char[N][M];
            minFin=Integer.MAX_VALUE;
            minMove=Integer.MAX_VALUE;
            int finCnt=0;
            for(int i=0;i<N;i++){
                String str=bf.readLine();
                for(int j=0;j<M;j++){
                    map[i][j]=str.charAt(j);
                    if(map[i][j]=='o'){
                        finCnt++;
                    }
                }
            }
            solve(finCnt,0);
            if(minFin==Integer.MAX_VALUE || minFin==finCnt){
                minFin=finCnt;
                minMove=0;
            }
            answer.append(minFin+" "+minMove+"\n");
            if(t<T-1) {
                String s = bf.readLine();
            }
        }
        System.out.println(answer.toString());
    }
    public static void solve(int fin,int move){
//        boolean flag=false;
//        int cntFin=0;
//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                if(map[i][j]=='o'){
//                    cntFin++;
//                    for(int k=0;k<4;k++){
//                        int nextY=i+dy[k];
//                        int nextX=j+dx[k];
//                        if(canGo(nextY,nextX)){
//                            flag=true;
//                        }
//                    }
//                }
//            }
//        }
//        if(!flag){
            if(fin<=minFin){
                if(fin==minFin){
                    if(move<minMove){
                        minMove=move;
                    }
                }
                else {
                    minFin = fin;
                    minMove=move;
                }
//                return ;
            }
//        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]=='o'){
                    for(int k=0;k<4;k++){
                        int nextY=i+dy[k];
                        int nextX=j+dx[k];
                        int nextY2=i+dy[k]*2;
                        int nextX2=j+dx[k]*2;
                        if(canGo(nextY,nextX) && canGo2(nextY2,nextX2)){
                            map[nextY][nextX]='.';
                            map[i][j]='.';
                            map[nextY2][nextX2]='o';
                            solve(fin-1,move+1);
                            map[nextY2][nextX2]='.';
                            map[i][j]='o';
                            map[nextY][nextX]='o';
                        }


                    }
                }
            }
        }

    }
    public static boolean canGo(int y,int x){
        if(y>=0 && y<N && x>=0 && x<M && map[y][x]=='o'){
            return true;
        }
        return false;
    }
    public static boolean canGo2(int y,int x){
        if(y>=0 && y<N && x>=0 && x<M && map[y][x]=='.'){
            return true;
        }
        return false;
    }
}
/*
1
###...###
..o......
.....o...
.........
###...###

1
###...###
........o
........o
.........
###...###
* */