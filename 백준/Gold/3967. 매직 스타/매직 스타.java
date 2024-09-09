import java.util.*;
import java.io.*;
public class Main {
    static char[][] map;
    static class Position{
        int y;
        int x;
        public Position(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    //A:65, L:76
    static ArrayList<Position> list=new ArrayList<>();
    static boolean answer=false;
    static int[] ch;
    static char[][] ans;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        map=new char [5][9];
        ans=new char [5][9];
        ch=new int[12]; //ch[0]=> A, ch[11]=>L
        for(int i=0;i<5;i++){
            String st=bf.readLine();
            for(int j=0;j<9;j++){
                map[i][j]=st.charAt(j);
                if(map[i][j]=='x'){
                    list.add(new Position(i,j));
                }
                else if(map[i][j]!='.'){
                    ch[(int)map[i][j]-65]=1;
                }
            }
        }
        solve(0);
        for(int i=0;i<5;i++){
            for(int j=0;j<9;j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
    public static void solve(int cnt){
        if(answer){
            return ;
        }
        if(cnt==list.size()){
            //여부 확인
//            System.out.println(rowCh(1));
//            System.out.println(rowCh(3));
//            System.out.println(check1(3,1));
//            System.out.println(check1(4,4));
//            System.out.println(check2(1,1));
//            System.out.println(check2(0,4));
            if(rowCh(1)&&rowCh(3)&&check1(3,1)&&check1(4,4)&&check2(1,1)&&check2(0,4)){
                for(int i=0;i<5;i++){
                    for(int j=0;j<9;j++){
                        ans[i][j]=map[i][j];
                    }
                }
                answer=true;
            }
            return ;
        }
        for(int i=0;i<12;i++){
            Position now=list.get(cnt);
            int nowY=now.y;
            int nowX=now.x;
            if(ch[i]==0){
                ch[i]=1;
                map[nowY][nowX]=(char)(i+65);
                solve(cnt+1);
                ch[i]=0;
            }
        }
    }
    public static boolean rowCh(int rowCnt){
        int res=0;
        for(int i=0;i<9;i++){
            if(map[rowCnt][i]!='.'){
                res+=((int)map[rowCnt][i]-64);
            }
        }
        if(res==26){
            return true;
        }
        return false;
    }
    public static boolean check1(int startY,int startX){ //(3,1),(4,4)
        int res=0;
        for(int i=0;i<4;i++){
            res+=((int)map[startY][startX]-64);
            startY-=1;
            startX+=1;
        }
        if(res==26){
            return true;
        }
        return false;
    }
    public static boolean check2(int startY,int startX){ //(1,1),(4,0)
        int res=0;
        for(int i=0;i<4;i++){
            res+=((int)map[startY][startX]-64);
            startY+=1;
            startX+=1;
        }
        if(res==26){
            return true;
        }
        return false;
    }
}