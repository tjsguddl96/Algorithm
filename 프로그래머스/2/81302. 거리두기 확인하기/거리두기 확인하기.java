import java.util.*;
class Solution {
    static char[][] map;
    static int[][] ch;
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static int flag;
    static class Node{
        int y;
        int x;
        int d;
        public Node(int y,int x,int d){
            this.y=y;
            this.x=x;
            this.d=d;
        }
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int t=0;t<places.length;t++){
            answer[t]=1;
            
            map=new char[5][5];
            for(int i=0;i<5;i++){
                String str=places[t][i];                
                for(int j=0;j<5;j++){
                    map[i][j]=str.charAt(j);
                }
            }
            flag=0;
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if(map[i][j]=='P'){
                        // System.out.println(i+" "+j+"!!!");
                        // ch=new int[5][5];            
                        // ch[i][j]=1;
                        // dfs(i,j,i,j,0,map);
                        bfs(i,j,map);
                        // System.out.println("----");
                        if(flag==1){
                            break;         
                        }
                        
                    }
                }
                if(flag==1){
                    break;
                }
            }
            if(flag==1){
                answer[t]=0;    
            }
            
            
        }
        return answer;
    }
    public static void bfs(int startY,int startX,char[][] map){
        
        ArrayDeque<Node> q=new ArrayDeque<>();
        q.add(new Node(startY,startX,0));
        ch=new int[5][5];
        
        while(!q.isEmpty()){
            Node now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            int nowD=now.d;
            if(nowD>2){
                break;
            }
            if(nowD<=2 && map[nowY][nowX]=='P' && (nowY!=startY || nowX!=startX)){
                flag=1;
                break;
            }
            ch[nowY][nowX]=1;
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(nextY>=0 && nextY<5 && nextX>=0 && nextX<5 && ch[nextY][nextX]==0 && map[nextY][nextX]!='X'){
                    ch[nextY][nextX]=1;
                    q.add(new Node(nextY,nextX,nowD+1));
                }
            }
        }
        
        
        
        
        
        
        
        
        
    }
    public static void dfs(int nowY,int nowX,int startY,int startX,int dist,char[][] map){
        System.out.println(nowY+" "+nowX+" "+dist+" "+map[nowY][nowX]+" "+startY+" "+startX);
        if(flag==1){
            return ;
        }
        if(dist<=2 && map[nowY][nowX]=='P' && (nowY!=startY ||nowX!=startX)){
            System.out.println("###");
            flag=1;
            return ;
        }
        if(dist>2){
            return ;
        }
        ch[nowY][nowX]=1;
        for(int i=0;i<4;i++){
            int nextY=nowY+dy[i];
            int nextX=nowX+dx[i];
            if(nextY>=0 && nextY<5 && nextX>=0 && nextX<5 && ch[nextY][nextX]==0 && map[nextY][nextX]!='X'){
                ch[nextY][nextX]=1;
                dfs(nextY,nextX,startY,startX,dist+1,map);
            }
        }
        
        
    }
}