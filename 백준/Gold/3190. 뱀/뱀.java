import java.util.*;
import java.io.*;
public class Main {
    static int[][] ch;
    static int[] dy={0,1,0,-1};
    static int[] dx={1,0,-1,0};
    static class Snake{ //머리의 위치와 방향
        int y;
        int x;
        int dir;
        public Snake(int y,int x,int dir){
            this.y=y;
            this.x=x;
            this.dir=dir;
        }
    }
    static class Move{
        int t;
        char dir;
        public Move(int t,char dir){
            this.t=t;
            this.dir=dir;
        }
    }
    static class Tail{
        int y;
        int x;
        public Tail(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static int N,K,L;
    static int[][] map;
    static ArrayDeque<Move> moves=new ArrayDeque<>();
    static ArrayDeque<Tail> tails=new ArrayDeque<>();
    public static void main(String[] args) throws IOException{

        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        map=new int[N+1][N+1];
        ch=new int[N+1][N+1];
        K=Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int i=0;i<K;i++){
            st=new StringTokenizer(bf.readLine());
            int y=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            map[y][x]=1;
        }
        L=Integer.parseInt(bf.readLine());

        for(int i=0;i<L;i++){
            st=new StringTokenizer(bf.readLine());
            int t=Integer.parseInt(st.nextToken());
            char dir=st.nextToken().charAt(0);
            moves.add(new Move(t,dir));
        }
        tails.add(new Tail(1,1));
        ArrayDeque<Snake> q=new ArrayDeque<>();
        q.add(new Snake(1,1,0));
        ch[1][1]=1;
        long time=1;
        while(!q.isEmpty()){
            Snake now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowDir=now.dir;
            int nextY=nowY+dy[nowDir];
            int nextX=nowX+dx[nowDir];
            int nextDir=now.dir;
            //이동
            if(!canContinue(nextY,nextX)){
                break;
            }
            ch[nextY][nextX]=1;
            //줄이기 -> 이동한 위치에 사과가 없다면
            if(map[nextY][nextX]==1){ //사과 먹고, 줄이기 X
                map[nextY][nextX]=0;
            }
            else{ //사과는 못먹고, 줄이기
                Tail tail=tails.poll();
                ch[tail.y][tail.x]=0;
            }
            //방향 전환
            if(!moves.isEmpty() &&moves.peek().t==time){
                Move nowMove=moves.poll();
                char goDir=nowMove.dir;
                if(goDir=='L'){
                    nextDir=(nowDir+3)%4;
                }
                else{
                    nextDir=(nowDir+1)%4;
                }
            }

            q.add(new Snake(nextY,nextX,nextDir));
            tails.add(new Tail(nextY,nextX));
            time++;
//            System.out.println(time+" 초 : "+nextY+" "+nextX+" "+nextDir);
//            for(int i=1;i<N+1;i++){
//                for(int j=1;j<N+1;j++){
//                    System.out.print(ch[i][j]+" ");
//                }
//                System.out.println();
//            }
        }

        System.out.println(time);
    }
    public static boolean canContinue(int y,int x){
        if(y>0 && y<N+1 && x>0 && x<N+1 && ch[y][x]==0){
            return true;
        }
        return false;
    }

}
