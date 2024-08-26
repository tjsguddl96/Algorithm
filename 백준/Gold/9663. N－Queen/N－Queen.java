import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int answer;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        map=new int[N][N];
        solve(0,1);
        System.out.println(answer);
    }
    public static void solve(int nowY,int idx){
        if(idx==N+1){
            answer++;
            return ;
        }
        if(nowY==N){
            return ;
        }
        for(int x=0;x<N;x++){
            if(map[nowY][x]==0){
                //가로
                for(int i=0;i<N;i++){
                    map[nowY][i]+=idx;
                }
                //세로
                for(int i=0;i<N;i++){
                    map[i][x]+=idx;
                }
                //대각선
                int nextY=nowY-1;
                int nextX=x-1;
                while(nextY>=0 && nextY<N && nextX>=0 && nextX<N){
                    map[nextY][nextX]+=idx;
                    nextY-=1;
                    nextX-=1;
                }
                nextY=nowY+1;
                nextX=x-1;
                while(nextY>=0 && nextY<N && nextX>=0 && nextX<N){
                    map[nextY][nextX]+=idx;
                    nextY+=1;
                    nextX-=1;
                }
                nextY=nowY+1;
                nextX=x+1;
                while(nextY>=0 && nextY<N && nextX>=0 && nextX<N){
                    map[nextY][nextX]+=idx;
                    nextY+=1;
                    nextX+=1;
                }
                nextY=nowY-1;
                nextX=x+1;
                while(nextY>=0 && nextY<N && nextX>=0 && nextX<N){
                    map[nextY][nextX]+=idx;
                    nextY-=1;
                    nextX+=1;
                }
                solve(nowY+1,idx+1);
                for(int i=0;i<N;i++){
                    map[nowY][i]-=idx;
                }
                //세로
                for(int i=0;i<N;i++){
                    map[i][x]-=idx;
                }
                //대각선
                nextY=nowY-1;
                nextX=x-1;
                while(nextY>=0 && nextY<N && nextX>=0 && nextX<N){
                    map[nextY][nextX]-=idx;
                    nextY-=1;
                    nextX-=1;
                }
                nextY=nowY+1;
                nextX=x-1;
                while(nextY>=0 && nextY<N && nextX>=0 && nextX<N){
                    map[nextY][nextX]-=idx;
                    nextY+=1;
                    nextX-=1;
                }
                nextY=nowY+1;
                nextX=x+1;
                while(nextY>=0 && nextY<N && nextX>=0 && nextX<N){
                    map[nextY][nextX]-=idx;
                    nextY+=1;
                    nextX+=1;
                }
                nextY=nowY-1;
                nextX=x+1;
                while(nextY>=0 && nextY<N && nextX>=0 && nextX<N){
                    map[nextY][nextX]-=idx;
                    nextY-=1;
                    nextX+=1;
                }
            }
        }


    }

}