import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[][] map;
    static int[] dy={0,1};
    static int[] dx={1,0};
    static int[][] ch;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        ch=new int[N][M];
        for(int i=0;i<N;i++){
            String input=bf.readLine();
            for(int j=0;j<M;j++){
                map[i][j]=input.charAt(j)-'0';
            }
        }
        dfs(0,0);
        System.out.println(answer);


    }
    public static void dfs(int nowY,int nowX){

        if(nowY==N){
            //계산
            sum();
            return ;
        }
        if(nowX==M){
            dfs(nowY+1,0);
            return ;
        }
        ch[nowY][nowX]=1;
        dfs(nowY,nowX+1);
        ch[nowY][nowX]=0;
        dfs(nowY,nowX+1);

    }
    public static void sum(){
        int result=0;
        int tmp=0;
        for(int i=0;i<N;i++){
            tmp=0;
            for(int j=0;j<M;j++){
                if(ch[i][j]==1){ //ch[i][j]==1이면 가로라는 뜻
                    tmp*=10;
                    tmp+=map[i][j];
                }
                else{
                    result+=tmp;
                    tmp=0;
                }
            }
            result+=tmp;
        }
        for(int i=0;i<M;i++){
            tmp=0;
            for(int j=0;j<N;j++){
                if(ch[j][i]==0){
                    tmp*=10;
                    tmp+=map[j][i];
                }
                else{
                    result+=tmp;
                    tmp=0;
                }
            }
            result+=tmp;
        }
        answer=Math.max(answer,result);
    }
}