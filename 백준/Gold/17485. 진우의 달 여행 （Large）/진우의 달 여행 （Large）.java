import java.util.*;
import java.io.*;

public class Main {
    static int[] dy={0,-1,-1,-1};
    static int[] dx={0,-1,0,1};
    static class Ship implements Comparable<Ship>{
        int y;
        int x;
        int w;
        int dir;
        public Ship(int y,int x,int w,int dir){
            this.y=y;
            this.x=x;
            this.w=w;
            this.dir=dir;
        }
        @Override
        public int compareTo(Ship o){
            return this.w-o.w;
        }
    }
    static int N,M; //행,열
    static int[][] map;
    static int[][][] ch;
    static int INF=Integer.MAX_VALUE;
    static PriorityQueue<Ship> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        ch=new int[N][M][4];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(i==N-1){
                    pq.add(new Ship(i,j,map[i][j],0));
                    ch[i][j][0]=map[i][j];
                }else {
                    for(int k=1;k<4;k++){
                        ch[i][j][k]=INF;
                    }
                }
            }
        }
        while(!pq.isEmpty()){
            Ship now=pq.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowW=now.w;
            int nowDir=now.dir;
//            System.out.println("y : "+nowY+" x : "+nowX+" w : "+nowW);
            for(int i=1;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(nextY>=0 && nextY<N && nextX>=0 && nextX<M && ch[nextY][nextX][i]>nowW+map[nextY][nextX] && nowDir!=i){
                    ch[nextY][nextX][i]=nowW+map[nextY][nextX];
                    pq.add(new Ship(nextY,nextX,nowW+map[nextY][nextX],i));
                }
            }
        }
//        for(int i=0;i<N;i++){
//            for(int j=0;j<M;j++){
//                System.out.print(ch[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        int min=INF;
        for(int i=0;i<M;i++){
            for(int j=1;j<4;j++){
                min=Math.min(min,ch[0][i][j]);
            }
        }
        System.out.println(min);
    }
}
/*
3 3
1 10 5
1 2 10
1 10 1
->4

3 3
1 2 2
9 1 9
9 9 1
->4

3 3
9 9 1
9 1 9
1 2 2
->4
* */