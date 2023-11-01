import java.util.*;
class Solution {
    static int[] dy={0,0,1,-1};
    static int[] dx={1,-1,0,0};
    static int[][] map=new int[102][102];
    static int[][] ch=new int[102][102];
    static class Position{
        int y;
        int x;
        int dist;
        public Position(int y,int x,int dist){
            this.y=y;
            this.x=x;
            this.dist=dist;
        }
    }
    static ArrayDeque<Position> q=new ArrayDeque<>();
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY){
        int answer = 0;
        for(int i=0;i<rectangle.length;i++){
            int x1=rectangle[i][0]*2;
            int y1=rectangle[i][1]*2;
            int x2=rectangle[i][2]*2;
            int y2=rectangle[i][3]*2;
                
            makeMap(y1,x1,y2,x2);
        }
        q.add(new Position(characterY*2,characterX*2,0));
        while(!q.isEmpty()){
            Position now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowD=now.dist;
            if(nowY==itemY*2 && nowX==itemX*2){
                answer=nowD/2;
                break;
            }
            ch[nowY][nowX]=1;
            
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                int nextD=nowD+1;
                
                if(nextY>=0 && nextY<102 && nextX>=0 && nextX<102 && ch[nextY][nextX]==0 &&map[nextY][nextX]==1){
                    ch[nextY][nextX]=1;
                    q.add(new Position(nextY,nextX,nextD));
                }
            }
        }
        
        return answer;
    }
    public void makeMap(int y1,int x1,int y2,int x2){
        for(int y=y1;y<y2+1;y++){
            for(int x=x1;x<x2+1;x++){
                if(y==y1 || y==y2 || x==x1||x==x2){
                    if(map[y][x]==0){
                        map[y][x]=1;
                    }
                }else{
                    map[y][x]=2;
                }
            }
        }
    }
}
