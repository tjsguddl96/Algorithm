
import java.util.*;
import java.io.*;

/*17836
* 0은 빈 공간,
* 1은 마법의 벽,
* 2는 그람이 놓여있는 공간을 의미한다.
* 용사 첫 위치 (0,0)
* 공주 위치(N-1,M-1)
*
* */
public class Main {
    static int N,M,T;
    static int[][] map;
    static int[][] ch;
    static class Position{
        int y;
        int x;
        int d;
        public Position(int y,int x,int d){
            this.y=y;
            this.x=x;
            this.d=d;
        }
    }
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int dist=Integer.MAX_VALUE;
        dist=bfs(0,0);
        int dist2=Integer.MAX_VALUE;
        dist2=bfs2();
//        System.out.println(dist+" "+dist2);
        int answer=Math.min(dist,dist2);
        if(answer>T){
            System.out.println("Fail");
        }
        else{
            System.out.println(answer);
        }




    }
    public static int bfs2(){
        ArrayDeque<Position> q=new ArrayDeque<>();
        ch=new int[N][M];
        ch[0][0]=1;
        boolean flag=false;
        q.add(new Position(0,0,0));
        int tmp=0;
        int sY=0;
        int sX=0;
        tmp=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Position now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowD=now.d;
            if(map[nowY][nowX]==2){
                flag=true;
                tmp=nowD;
//                tmp+=nowD;
                sY=nowY;
                sX=nowX;
                break;
            }
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                int nextD=nowD+1;
                if(!flag) {
                    if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && ch[nextY][nextX] == 0 && map[nextY][nextX] != 1) {
                        ch[nextY][nextX] = 1;
                        q.add(new Position(nextY, nextX, nextD));
                    }
                }
                else{
                    if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && ch[nextY][nextX] == 0) {
                        ch[nextY][nextX] = 1;
                        q.add(new Position(nextY, nextX, nextD));
                    }
                }
            }
        }
//        System.out.println("tmp : "+tmp);
        ch=new int[N][M];
        ch[sY][sX]=1;
//        System.out.println(sY+ " "+sX+"!");
        q=new ArrayDeque<>();
        q.add(new Position(sY,sX,0));
        while(!q.isEmpty()){
            Position now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowD=now.d;
            if(nowY==N-1 && nowX==M-1){
                tmp+=nowD;
                break;
            }
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                int nextD=nowD+1;
                if(!flag) {
                    if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && ch[nextY][nextX] == 0 && map[nextY][nextX] != 1) {
                        ch[nextY][nextX] = 1;
                        q.add(new Position(nextY, nextX, nextD));
                    }
                }
                else{
                    if (nextY >= 0 && nextY < N && nextX >= 0 && nextX < M && ch[nextY][nextX] == 0) {
                        ch[nextY][nextX] = 1;
                        q.add(new Position(nextY, nextX, nextD));
                    }
                }
            }
        }
        return tmp;
    }
    public static int bfs(int y,int x){
        ArrayDeque<Position> q=new ArrayDeque<>();
        ch=new int[N][M];
        ch[y][x]=1;
        q.add(new Position(y,x,0));
        int dist=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Position now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowD=now.d;
            if(nowY==N-1 && nowX==M-1){
                dist=nowD;
            }
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                int nextD=nowD+1;
                if(nextY>=0 && nextY<N && nextX>=0 && nextX<M && ch[nextY][nextX]==0 && map[nextY][nextX]!=1){
                    ch[nextY][nextX]=1;
                    q.add(new Position(nextY,nextX,nextD));
                }
            }
        }
        return dist;
    }

}
