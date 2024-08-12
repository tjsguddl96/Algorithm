import java.util.*;
import java.io.*;
public class Main {
    static int[][] map;
    static StringBuilder answer=new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        map=new int[10][10];
        for(int i=1;i<10;i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=1;j<10;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        solve(1,1);

    }

    public static boolean check(int y,int x,int val){
        //가로
        for(int i=1;i<10;i++){
            if(map[y][i]==val){
                return false;
            }
        }

        //세로
        for(int i=1;i<10;i++){
            if(map[i][x]==val){
                return false;
            }
        }

        //3*3
        int tmpI=y%3-1;
        if(y%3==0){
            tmpI=2;
        }
        int startY=y-tmpI;
        int tmpJ=x%3-1;
        if(x%3==0){
            tmpJ=2;
        }
        int startX=x-tmpJ;
        for(int i=startY;i<startY+3;i++){
            for(int j=startX;j<startX+3;j++){
                if(map[i][j]==val){
                    return false;
                }
            }
        }
        return true;
    }
    public static void solve(int y,int x){
        if(x==10){
            solve(y+1,1);
            return ;
        }
        if(y==10){
            for(int i=1;i<10;i++){
                for(int j=1;j<10;j++){
                    answer.append(map[i][j]+" ");
                }
                answer.append("\n");
            }
            System.out.println(answer.toString());
            System.exit(0);
        }
        if(map[y][x]==0){
            for(int i=1;i<10;i++){
                if(check(y,x,i)){
                    map[y][x]=i;
                    solve(y,x+1);
                    map[y][x]=0;
                }
            }
            return ;
        }



        solve(y,x+1);

    }
}