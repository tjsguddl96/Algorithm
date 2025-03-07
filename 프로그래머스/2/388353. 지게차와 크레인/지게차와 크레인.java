import java.util.*;
class Solution {
    static int N,M;
    static int[][] map;
    static int[] dy={0,0,1,-1};
    static int[] dx={1,-1,0,0};
    static int[][] ch;
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static int answer;
    public int solution(String[] storage, String[] requests) {

        N=storage.length;
        M=storage[0].length();
        answer=N*M;
        map=new int[N+2][M+2];
        ch=new int[N+2][M+2];
        for(int i=1;i<N+1;i++){
            String str=storage[i-1];
            for(int j=1;j<M+1;j++){
                map[i][j]=(int)(str.charAt(j-1));
            }
        }
        for(int i=0;i<requests.length;i++){
            String str=requests[i];
            if(str.length()==2){
                crain(str.charAt(0));
            }
            else{
                car(str.charAt(0));
                bfs();
            }
            // print();
        }
        return answer;
    }
    public static void print(){
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("---------");
    }
    public static void car(char request){
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if((int)request==map[i][j] && isOut(i,j)){
                    map[i][j]=-1;
                    answer--;
                }
            }
        }
    }
    public static void crain(char request){
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M+1;j++){
                if((int)request==map[i][j]){
                    map[i][j]=-1;
                    answer--;
                    bfs();
                }
            }
        }
    }
    public static boolean isOut(int nowY,int nowX){
        if(map[nowY-1][nowX]==0){
            return true;
        }
        if(map[nowY+1][nowX]==0){
            return true;
        }
        if(map[nowY][nowX-1]==0){
            return true;
        }
        if(map[nowY][nowX+1]==0){
            return true;
        }
        return false;
    }
    public static boolean isIn(int nowY,int nowX){
        if(nowY>=0 && nowY<N+2 && nowX>=0 && nowX<M+2 && ch[nowY][nowX]==0 && (map[nowY][nowX]==0 || map[nowY][nowX]==-1)){
            return true;
        }
        return false;
    }
    public static void bfs(){
        ArrayDeque<Position> q=new ArrayDeque<>();
        q.add(new Position(0,0));
        ch=new int[N+2][M+2];
        while(!q.isEmpty()){
            Position now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(isIn(nextY,nextX)){
                    ch[nextY][nextX]=1;
                    map[nextY][nextX]=0;
                    q.add(new Position(nextY,nextX));
                }
            }
        }
    }
}