import java.io.*;
import java.util.*;

public class Main {
    static int R,C,T;
    static int[][] map;
    static boolean flag;
    static int[][] ch;
    static class Machine{
        int y;
        int x;
        public Machine(int y,int x){
            this.y=y;
            this.x=x;
        }
        @Override
        public String toString(){
            return y+" "+x;
        }
    }
    static Machine[] machines=new Machine[2];
    static class Dust{
        int y;
        int x;
        int cnt;
        public Dust(int y,int x,int cnt){
            this.y=y;
            this.x=x;
            this.cnt=cnt;
        }
        @Override
        public String toString(){
            return y+" "+x+" "+cnt;
        }

    }
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static ArrayList<Dust> dusts=new ArrayList<>(); //확산될 dustList
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());
        map=new int[R][C];
        for(int i=0;i<R;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<C;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==-1 && !flag){ //위쪽
                    machines[0]=new Machine(i,j);
                    flag=true;
                }
                else if(map[i][j]==-1 && flag){
                    machines[1]=new Machine(i,j);
                }
                else if(map[i][j]!=0){
                    dusts.add(new Dust(i,j,map[i][j]));
                }
            }
        }
        for(int i=0;i<T;i++){
            dustMove();
            windMoveUp(machines[0].y,machines[0].x,0);
            windMoveDown(machines[1].y,machines[1].x,0);
            makeDustList();
        }
        int answer=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j]!=0){
                    answer+=map[i][j];
                }
            }
        }
        System.out.println(answer);

    }
    public static void print(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("--------");
    }
    public static void windMoveUp(int nowY,int nowX,int dir){
        if(dir==0 && nowY==0){
            windMoveUp(nowY,nowX,1);
            return ;
        }
        else if(dir==1 && nowX==C-1){
            windMoveUp(nowY,nowX,2);
            return ;
        }
        else if(dir==2 && nowY==machines[0].y){
            windMoveUp(nowY,nowX,3);
            return ;
        }
        else if(dir==3 && nowX==machines[0].x){
            return ;
        }
        int nextY=0;
        int nextX=0;
        if(dir==0){
            nextY=nowY-1;
            nextX=nowX;
        }
        else if(dir==1){
            nextY=nowY;
            nextX=nowX+1;
        }
        else if(dir==2){
            nextY=nowY+1;
            nextX=nowX;

        }
        else if(dir==3){
            nextY=nowY;
            nextX=nowX-1;
        }
        if(nextY>=0 && nextY<R && nextX>=0 && nextX<C){
            map[nowY][nowX]=map[nextY][nextX];
            if(nowY==machines[0].y && nowX==machines[0].x){
                map[nowY][nowX]=0;
            }
            windMoveUp(nextY,nextX,dir);
        }
    }
    public static void makeDustList(){
        dusts=new ArrayList<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j]!=0){
                    dusts.add(new Dust(i,j,map[i][j]));
                }
            }
        }
    }
    public static void windMoveDown(int nowY,int nowX,int dir){
        if(dir==0 && nowY==R-1){
            windMoveDown(nowY,nowX,1);
            return ;
        }
        else if(dir==1 && nowX==C-1){
            windMoveDown(nowY,nowX,2);
            return ;
        }
        else if(dir==2 && nowY==machines[1].y){
            windMoveDown(nowY,nowX,3);
            return;
        }
        else if(dir==3 && nowX==0){
            return ;
        }

        int nextY=0;
        int nextX=0;
        if(dir==0){
            nextY=nowY+1;
            nextX=nowX;
        }
        else if(dir==1){
            nextY=nowY;
            nextX=nowX+1;
        }
        else if(dir==2){
            nextY=nowY-1;
            nextX=nowX;
        }
        else if(dir==3){
            nextY=nowY;
            nextX=nowX-1;
        }
        if(nextY>=0 && nextY<R && nextX>=0&& nextX<C){
            map[nowY][nowX]=map[nextY][nextX];
            if(nowY==machines[1].y && nowX==0){
                map[nowY][nowX]=0;
            }
            windMoveDown(nextY,nextX,dir);
        }
    }
    public static void dustMove(){
        ch=new int[R][C];
        for(int i=0;i<dusts.size();i++){
            Dust now=dusts.get(i);
            int nowY=now.y;
            int nowX=now.x;
            int nowCnt=now.cnt;
            int spreadCnt=nowCnt/5;
            int cnt=0;
            for(int j=0;j<4;j++){
                int nextY=nowY+dy[j];
                int nextX=nowX+dx[j];
                if(isIn(nextY,nextX)){
                    ch[nextY][nextX]+=spreadCnt;
                    cnt++;
                }
            }
            ch[nowY][nowX]+=(nowCnt-cnt*spreadCnt);
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                map[i][j]=ch[i][j];
            }
        }
    }
    public static boolean isIn(int y,int x){
        if(y>=0 && y<R && x>=0 && x<C){
            if(machines[0].y==y && machines[0].x==x){
                return false;
            }
            else if(machines[1].y==y && machines[1].x==x){
                return false;
            }
            return true;
        }
        return false;
    }
}
/*
3 3 2
0 30 7
-1 10 0
-1 0 20

4 4 2
0 0 0 0
-1 0 0 0
-1 10 10 0
0 0 0 0 0

* */