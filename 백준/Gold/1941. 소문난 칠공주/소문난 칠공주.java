import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static int[] res=new int[7];
    static int[] dy={0,0,1,-1};
    static int[] dx={1,-1,0,0};
    static int answer;
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static int[][] ch=new int[6][6];
    public static void main(String[] args) throws IOException{
//        int a=50*23*22*19; -> 480700
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        map=new char[6][6];
        for(int i=1;i<6;i++){
            String input=bf.readLine();
            for(int j=1;j<6;j++){
                map[i][j]=input.charAt(j-1);
            }
        }
        combi(0,1);

        System.out.println(answer);
    }
    public static void combi(int cnt,int start){
        if(cnt==7){
            HashSet<Integer> set=new HashSet<>();
            for(int i=0;i<7;i++){
                set.add(res[i]);
            }
            int y=res[0]/5+1;
            int x=res[0]%5;
            if(x==0){
                x=5;
                y-=1;
            }
            ArrayDeque<Position> q=new ArrayDeque<>();
            int cntY=0;
            int cntS=0;
            q.add(new Position(y,x));
            ch=new int[6][6];
            ch[y][x]=1;
            while(!q.isEmpty()){
                Position now=q.poll();
                int nowY=now.y;
                int nowX=now.x;
                if(map[nowY][nowX]=='Y'){
                    cntY++;
                }
                else{
                    cntS++;
                }
                int nowCnt=(nowY-1)*5+nowX;
                for(int i=0;i<4;i++){
                    int nextY=nowY+dy[i];
                    int nextX=nowX+dx[i];
                    int nextCnt=(nextY-1)*5+nextX;
                    if(isIn(nextY,nextX) && ch[nextY][nextX]==0 && set.contains(nextCnt)){
                        ch[nextY][nextX]=1;
                        q.add(new Position(nextY,nextX));
                    }
                }
            }
            if(cntY+cntS==7 && cntS>=4){
                answer++;
            }
            return ;
        }
        for(int i=start;i<26;i++){
            res[cnt]=i;
            combi(cnt+1,i+1);
        }

    }
    public static boolean isIn(int y,int x){
        if(y>=1 && y<6 && x>=1 && x<6){
            return true;
        }
        return false;
    }
}