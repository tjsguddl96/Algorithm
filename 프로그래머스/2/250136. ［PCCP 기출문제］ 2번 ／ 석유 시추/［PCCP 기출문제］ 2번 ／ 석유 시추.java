import java.util.*;

class Solution {
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }

    }
    static int N,M;//N=행->세로, M=열->가로
    static int[][] ch;
    static ArrayList<Integer> list=new ArrayList<>();
    static int[] ch2;
    public int solution(int[][] land) {
        int answer = 0;
        list.add(-1);
        int idx=1;
        N=land.length;
        M=land[0].length;
        ch=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(land[i][j]==1 && ch[i][j]==0){
                    bfs(i,j,idx,land);
                    idx++;
                }
            }
        }
        
        for(int i=0;i<M;i++){
            int sum=0;
            ch2=new int[idx];
            for(int j=0;j<N;j++){
                if(ch2[ch[j][i]]==0 && ch[j][i]!=0){
                    ch2[ch[j][i]]=1;
                    sum+=list.get(ch[j][i]);
                }
            }
            System.out.println();
            answer=Math.max(answer,sum);
        }
        return answer;
    }
    
    public static void bfs(int startY,int startX,int idx,int[][] land){
        ArrayDeque<Position> q=new ArrayDeque<>();
        q.add(new Position(startY,startX));
        ch[startY][startX]=idx;
        int sum=0;
        while(!q.isEmpty()){
            Position now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            sum++;
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(isIn(nextY,nextX)&&land[nextY][nextX]==1){
                    ch[nextY][nextX]=idx;
                    q.add(new Position(nextY,nextX));
                }
            }
        }
        list.add(sum);
    }
    public static boolean isIn(int y,int x){
        if(y>=0 && y<N && x>=0 && x<M &&ch[y][x]==0){
            return true;
        }
        return false;
    }
    
}
