import java.util.*;
import java.io.*;
public class Main {
    static int N,M; //행,열
    static int[][] map;
    static int[] dy={0,0,1,-1};
    static int[] dx={1,-1,0,0};
    static int[][][] ch;
    static class Position implements Comparable<Position>{
        int y;
        int x;
        int d;
        int flag;
        public Position(int y,int x,int d,int flag){
            this.y=y;
            this.x=x;
            this.d=d;
            this.flag=flag;
        }
        @Override
        public int compareTo(Position o){
            return this.d-o.d;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N+1][M+1];
        ch=new int[N+1][M+1][2];
        for(int i=1;i<N+1;i++){
            String input=bf.readLine();
            for(int j=0;j<M;j++){
                map[i][j+1]=input.charAt(j)-'0';
                for(int k=0;k<2;k++) {
                    ch[i][j + 1][k] = Integer.MAX_VALUE;
                }
            }
        }
        PriorityQueue<Position> pq=new PriorityQueue<>();
        pq.add(new Position(1,1,1,0));
        while(!pq.isEmpty()){
            Position now=pq.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowD=now.d;
            int nowFlag=now.flag;
            ch[nowY][nowX][nowFlag]=nowD;
            if(nowY==N && nowX==M){
                break;
            }
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                int nextD=nowD+1;
                if(nextY>=1 && nextY<N+1 && nextX>=1 && nextX<M+1){
//                System.out.println("("+nowY+", "+nowX+") -> "+"("+nextY+", "+nextX+")");
                    if(map[nextY][nextX]==1 && ch[nextY][nextX][nowFlag]>nextD){ //flag->1
                        if(nowFlag==0){
                            ch[nextY][nextX][1]=nextD;
                            pq.add(new Position(nextY,nextX,nextD,1));
                        }
                    }
                    else if(map[nextY][nextX]==0 && ch[nextY][nextX][nowFlag]>nextD){
                        ch[nextY][nextX][nowFlag]=nextD;
                        pq.add(new Position(nextY,nextX,nextD,nowFlag));
                    }
                }
            }
        }
//        for(int i=1;i<N+1;i++){
//            for(int j=1;j<M+1;j++){
//                System.out.print(ch[i][j][0]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("-------------");
//        for(int i=1;i<N+1;i++){
//            for(int j=1;j<M+1;j++){
//                System.out.print(ch[i][j][1]+" ");
//            }
//            System.out.println();
//        }
        if(Math.min(ch[N][M][0],ch[N][M][1])==Integer.MAX_VALUE){
            ch[N][M][0]=-1;
        }
        System.out.println(Math.min(ch[N][M][0],ch[N][M][1]));


    }


}
/*
3 4
0000
0000
0000
* */