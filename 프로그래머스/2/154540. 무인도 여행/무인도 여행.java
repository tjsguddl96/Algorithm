import java.util.*;
class Solution {
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static int[][] ch;
    static int[][] map;
    static int N,M; //N행,M열
    public int[] solution(String[] maps) {
        ArrayList<Integer> list=new ArrayList<>();
        
        N=maps.length;
        M=maps[0].length();
        map=new int[N][M];
        ch=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                String str=maps[i].charAt(j)+"";
                if(str.equals("X")){
                    map[i][j]=0;
                }
                else{
                    map[i][j]=Integer.parseInt(str);
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(ch[i][j]==0 && map[i][j]!=0){
                    int tmp=bfs(i,j);
                    list.add(tmp);
                }
            }
        }
        if(list.size()==0){
            int[] answer=new int[1];
            answer[0]=-1;
            return answer;        
        }
    
        int[] answer = new int[list.size()];
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        
        
        return answer;
    }
    public static int bfs(int startY,int startX){
        int sum=0;
        ArrayDeque<Position> q=new ArrayDeque<>();
        ch[startY][startX]=1;
        q.add(new Position(startY,startX));
        while(!q.isEmpty()){
            Position now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            sum+=map[nowY][nowX];
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(isIn(nextY,nextX)){
                    ch[nextY][nextX]=1;
                    q.add(new Position(nextY,nextX));
                }
            }
        }
        return sum;
    }
    public static boolean isIn(int y,int x){
        if(y>=0 && y<N && x>=0 && x<M && ch[y][x]==0 && map[y][x]!=0){
            return true;
        }
        return false;
    }
    
}