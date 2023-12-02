import java.util.*;
import java.io.*;
class Solution {
    static class Dir{
        char dir;
        int dy;
        int dx;
        public Dir(char dir,int dy,int dx){
            this.dir=dir;
            this.dy=dy;
            this.dx=dx;
        }
    }
    static Dir[] d={new Dir('d',1,0),new Dir('l',0,-1),new Dir('r',0,1),new Dir('u',-1,0)};
    static String answer="";
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        //n: 세로, m:가로, x-> y로, y->x 로, r은 y, c는 x, k는 목적지에 가야되는 거리
        int distance=Math.abs(x-r)+Math.abs(y-c);
        if(k<distance || ((k-distance)%2==1)){
            answer="impossible";
        }
        else{
            dfs(n,m,r,c,k,"",x,y);
        }
        return answer;
    }
    static String dfs(int n,int m,int r,int c,int k,String path,int nowY,int nowX){
        if(!(answer.equals(""))){
            return answer;
        }
        if(path.length()+(Math.abs(nowY-r)+Math.abs(nowX-c))>k){
            return answer;
        }
        if(nowY==r && nowX==c && path.length()==k){
            answer=path;
            return answer;
        }
        for(int i=0;i<4;i++){
            String nextPath=path+d[i].dir;
            int nextY=nowY+d[i].dy;
            int nextX=nowX+d[i].dx;
            if(nextY>=1 && nextY<=n && nextX>=1 && nextX<=m && answer.equals("")){
                dfs(n,m,r,c,k,nextPath,nextY,nextX);
            }
        }
        return answer;
    }
}