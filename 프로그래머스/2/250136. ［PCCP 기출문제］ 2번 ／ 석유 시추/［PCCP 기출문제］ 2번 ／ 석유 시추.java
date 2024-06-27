import java.util.*;
class Solution {
    static class Node{
        int y;
        int x;
        public Node(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static int[] dy={0,0,-1,1};
    static int[] dx={1,-1,0,0};
    static int N,M;//세로 가로
    static int[][] ch;
    static HashMap<Integer,Integer> map=new HashMap<>();
    public int solution(int[][] land) { //land[i][j]=0 -> 땅, land[i][j]=1 -> 석유
        int answer = 0;
        N=land.length;
        M=land[0].length;
        ch=new int[N][M];
        int number=1;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(land[i][j]==1 && ch[i][j]==0){
                    bfs(i,j,number,land);
                    number++;
                }
            }
        }
        for(int i=0;i<M;i++){ //열
            HashSet<Integer> set=new HashSet<>();
            int tmp=0;
            for(int j=0;j<N;j++){ //행
                if(ch[j][i]!=0 && !set.contains(ch[j][i])){
                    set.add(ch[j][i]);
                    tmp+=map.get(ch[j][i]);
                }
            }
            answer=Math.max(answer,tmp);
            
        }
        return answer;
    }
    //public Node(int y,int x)
    public static void bfs(int startY,int startX,int number,int[][] land){
        ch[startY][startX]=number;
        ArrayDeque<Node> q=new ArrayDeque<>();
        q.add(new Node(startY,startX));
        int cnt=0;
        while(!q.isEmpty()){
            Node now=q.poll();
            int nowY=now.y;
            int nowX=now.x;
            cnt++;
            for(int i=0;i<4;i++){
                int nextY=nowY+dy[i];
                int nextX=nowX+dx[i];
                if(isIn(nextY,nextX,land)){
                    ch[nextY][nextX]=number;
                    q.add(new Node(nextY,nextX));
                }
            }
        }
        map.put(number,cnt);
    }
    public static boolean isIn(int y,int x,int[][] land){
        if(y>=0 && y<N && x>=0 && x<M && land[y][x]==1 && ch[y][x]==0){
            return true;
        }
        return false;
    }
}