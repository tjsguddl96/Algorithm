import java.util.*;

class Solution {
    static int[][][] map;
    static int r,c,n;
    static class Position{
        int y;
        int x;
        int d;
        int n;
        public Position(int y,int x,int d,int n){
            this.y=y;
            this.x=x;
            this.n=n;
            this.d=d;
        }
    }
    static ArrayList<Integer> ans=new ArrayList<>();
    static ArrayDeque<Position> pq=new ArrayDeque<>();
    static char[][] arr;
    public int[] solution(String[] grid) {
        int[] answer = {};
        r=grid.length;
        c=grid[0].length();
        n=r*c;
        arr=new char[r][c];
        for(int i=0;i<r;i++){
            String now=grid[i];
            for(int j=0;j<c;j++){
                arr[i][j]=now.charAt(j);
            }
        }
        map=new int[r][c][4];
        for(int y=0;y<r;y++){
            for(int x=0;x<c;x++){
                for(int fd=0;fd<4;fd++){
                    pq.add(new Position(y,x,fd,0));
                    int len=0;
                    int endY=y;
                    int endX=x;
                    if(map[y][x][fd]==1){
                        continue;
                    }
                    while(!pq.isEmpty()){
                        Position now=pq.poll();
                        len=now.n;
                        endY=now.y;
                        endX=now.x;
                        char nowChar=arr[now.y][now.x];
                        int nextY=now.y;
                        int nextX=now.x;
                        int nextD=now.d;
                        if(nowChar=='S'){
                            if(now.d==0){
                                nextY=now.y-1;
                            }
                            else if(now.d==1){
                                nextX=now.x-1;
                            }
                            else if(now.d==2){
                                nextY=now.y+1;
                            }
                            else{
                                nextX=now.x+1;
                            }
                            nextD=now.d;
                        }
                        else if(nowChar=='L'){
                            if(now.d==0){
                                nextD=1;
                                nextX=now.x-1;
                            }
                            else if(now.d==1){
                                nextD=2;
                                nextY=now.y+1;

                            }
                            else if(now.d==2){
                                nextD=3;
                                nextX=now.x+1;
                            }
                            else{
                                nextD=0;
                                nextY=now.y-1;
                            }
                        }
                        else{
                            if(now.d==0){
                                nextD=3;
                                nextX=now.x+1;
                            }
                            else if(now.d==1){
                                nextD=0;
                                nextY=now.y-1;
                            }
                            else if(now.d==2){
                                nextD=1;
                                nextX=now.x-1;
                            }
                            else{
                                nextD=2;
                                nextY=now.y+1;
                            }
                        }
                        if(nextY<0){
                            nextY=r-1;
                        }
                        else if(nextY>=r){
                            nextY=0;
                        }
                        if(nextX<0){
                            nextX=c-1;
                        }
                        else if(nextX>=c){
                            nextX=0;
                        }
                        if(map[nextY][nextX][nextD]==0){
                            map[nextY][nextX][nextD]=1;
                            pq.add(new Position(nextY,nextX,nextD,now.n+1));
                        }
                    }
                    ans.add(len);

                }        
            }
        }
        Collections.sort(ans);
        answer=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }
}