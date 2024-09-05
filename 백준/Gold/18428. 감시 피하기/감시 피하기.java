import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[][] map;
    static int[] dy={1,-1,0,0};
    static int[] dx={0,0,1,-1};
    static String answer="NO";
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static ArrayList<Position> teachers=new ArrayList<>();
    static int[] res=new int[3];
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        map=new char[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=st.nextToken().charAt(0);
                if(map[i][j]=='T'){
                    teachers.add(new Position(i,j));
                }
            }
        }
        Combi(0,0);
        System.out.println(answer);
    }
    public static void Combi(int cnt,int start){
        if(answer.equals("YES")){
            return ;
        }
        if(cnt==3){
            //여부
            for(int i=0;i<3;i++) {
                if (map[res[i] / N][res[i] % N] != 'X') {
                    return;
                }
            }
            for(int i=0;i<3;i++){
                map[res[i]/N][res[i]%N]='O';
            }
            boolean flag=false;
            for(int i=0;i<teachers.size();i++){
                int y=teachers.get(i).y;
                int x=teachers.get(i).x;
                for(int j=0;j<4;j++){
                    int nextY=y+dy[j];
                    int nextX=x+dx[j];
                    while(isIn(nextY,nextX)){
                        if(map[nextY][nextX]=='O'){
                            break;
                        }
                        else if(map[nextY][nextX]=='S'){
                            flag=true;
                            break;
                        }
                        nextY+=dy[j];
                        nextX+=dx[j];
                    }
                    if(flag){
                        break;
                    }
                }
                if(flag){
                    break;
                }
            }
            if(!flag){
                answer="YES";
            }
            for(int i=0;i<3;i++){
                map[res[i]/N][res[i]%N]='X';
            }
            return ;
        }
        for(int i=start;i<N*N;i++){
            res[cnt]=i;
            Combi(cnt + 1, i + 1);
        }
    }
    public static boolean isIn(int y,int x){
        if(y>=0 && y<N && x>=0 && x<N){
            return true;
        }
        return false;
    }


}
/*
4
X S X T
X X S X
X X X X
T T T X
->YES

5
X X S X X
X X X X X
S X T X S
X X X X X
X X S X X
NO
* */