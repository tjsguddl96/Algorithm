import java.util.*;
import java.io.*;
public class Main {
    static int R,C,K,answer;
    static int[][] map;
    static int[] dy={0,0,1,-1};
    static int[] dx={1,-1,0,0};
    static int[][] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        map=new int[R][C];
        ch=new int[R][C];
        for(int i=0;i<R;i++){
            String str=bf.readLine();
            for(int j=0;j<C;j++){
                char c=str.charAt(j);
                if(c=='.'){
                    map[i][j]=0;
                }
                else{
                    map[i][j]=1;
                }
            }
        }
        ch[R-1][0]=1;
        dfs(R-1,0,1);
        System.out.println(answer);



    }
    public static void dfs(int nowY,int nowX,int nowK){
        if(nowK>K){
            return ;
        }
        if(nowY==0 && nowX==C-1 && nowK==K){
            answer++;
            return ;
        }
        for(int i=0;i<4;i++){
            int nextY=nowY+dy[i];
            int nextX=nowX+dx[i];
            if(canGo(nextY,nextX)){
                ch[nextY][nextX]=1;
                dfs(nextY,nextX,nowK+1);
                ch[nextY][nextX]=0;
            }
        }

    }
    public static boolean canGo(int y,int x){
        if(y>=0 && y<R && x>=0 && x<C && map[y][x]==0 && ch[y][x]==0){
            return true;
        }
        return false;
    }
}