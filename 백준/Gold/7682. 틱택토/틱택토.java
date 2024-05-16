import java.util.*;
import java.io.*;
public class Main {
    static int[] dy={0,0,1,-1};
    static int[] dx={1,-1,0,0};
    static class Position{
        int y;
        int x;
        int cnt;
        int dir;
        public Position(int y,int x,int cnt,int dir){
            this.y=y;
            this.x=x;
            this.cnt=cnt;
            this.dir=dir;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        while(true){
            String input=bf.readLine();
            String ans="invalid";
            if(input.equals("end")){
                break;
            }
            int xCnt=0;
            int oCnt=0;
            char[][] map=new char[3][3];
            int flag=0;
            ArrayDeque<Position> q=new ArrayDeque<>();
            for(int i=0;i<9;i++){
                char now=input.charAt(i);
                if(now=='X'){
                    xCnt++;
                }
                else if(now=='O'){
                    oCnt++;
                }
                map[i/3][i%3]=now;
            }
            if(oCnt>xCnt){
                ans="invalid";
            }
            else{
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        if(map[i][j]=='X'){
                            q=new ArrayDeque<>();
                            q.add(new Position(i,j,1,0));
                            q.add(new Position(i,j,1,1));
                            q.add(new Position(i,j,1,2));
                            q.add(new Position(i,j,1,3));
                            while(!q.isEmpty()){
                                Position now=q.poll();
                                int nowY=now.y;
                                int nowX=now.x;
                                int nowCnt=now.cnt;
                                int nowDir=now.dir;
                                if(nowCnt==3){
                                    if(flag==2){
                                        flag=3;
                                    }
                                    else {
                                        flag = 1;
                                    }
                                    break;
                                }
                                //가로
                                int nextY=0;
                                int nextX=0;
                                if(nowDir==0) {
                                    nextY = nowY;
                                    nextX = nowX + 1;
                                    if (nextY >= 0 && nextY < 3 && nextX >= 0 && nextX < 3 && map[nextY][nextX] == 'X') {
                                        q.add(new Position(nextY, nextX, nowCnt + 1,nowDir));

                                    }
                                }
                                //세로
                                else if(nowDir==1) {
                                    nextY = nowY + 1;
                                    nextX = nowX;
                                    if (nextY >= 0 && nextY < 3 && nextX >= 0 && nextX < 3 && map[nextY][nextX] == 'X') {
                                        q.add(new Position(nextY, nextX, nowCnt + 1,nowDir));
                                    }
                                }
                                //대각선
                                else if(nowDir==2){
                                    nextY = nowY + 1;
                                    nextX = nowX + 1;
                                    if (nextY >= 0 && nextY < 3 && nextX >= 0 && nextX < 3 && map[nextY][nextX] == 'X') {
                                        q.add(new Position(nextY, nextX, nowCnt + 1,nowDir));

                                    }
                                }
                                else{
                                    nextY=nowY+1;
                                    nextX=nowX-1;
                                    if (nextY >= 0 && nextY < 3 && nextX >= 0 && nextX < 3 && map[nextY][nextX] == 'X') {
                                        q.add(new Position(nextY, nextX, nowCnt + 1,nowDir));

                                    }
                                }
                            }
                        }
                        else if(map[i][j]=='O'){
                            q=new ArrayDeque<>();
                            q.add(new Position(i,j,1,0));
                            q.add(new Position(i,j,1,1));
                            q.add(new Position(i,j,1,2));
                            q.add(new Position(i,j,1,3));
                            while(!q.isEmpty()){
                                Position now=q.poll();
                                int nowY=now.y;
                                int nowX=now.x;
                                int nowCnt=now.cnt;
                                int nowDir=now.dir;
                                if(nowCnt==3){
                                    if(flag==1){
                                        flag=3;
                                    }
                                    else {
                                        flag = 2;
                                    }
                                    break;
                                }
                                //가로
                                int nextY=0;
                                int nextX=0;
                                if(nowDir==0) {
                                    nextY = nowY;
                                    nextX = nowX + 1;
                                    if (nextY >= 0 && nextY < 3 && nextX >= 0 && nextX < 3 && map[nextY][nextX] == 'O') {
                                        q.add(new Position(nextY, nextX, nowCnt + 1,nowDir));
                                    }
                                }
                                //세로
                                else if(nowDir==1) {
                                    nextY = nowY + 1;
                                    nextX = nowX;
                                    if (nextY >= 0 && nextY < 3 && nextX >= 0 && nextX < 3 && map[nextY][nextX] == 'O') {
                                        q.add(new Position(nextY, nextX, nowCnt + 1,nowDir));
                                    }
                                }
                                //대각선
                                else if(nowDir==2){
                                    nextY = nowY + 1;
                                    nextX = nowX + 1;
                                    if (nextY >= 0 && nextY < 3 && nextX >= 0 && nextX < 3 && map[nextY][nextX] == 'O') {
                                        q.add(new Position(nextY, nextX, nowCnt + 1,nowDir));
                                    }
                                }
                                else{
                                    nextY=nowY+1;
                                    nextX=nowX-1;
                                    if (nextY >= 0 && nextY < 3 && nextX >= 0 && nextX < 3 && map[nextY][nextX] == 'O') {
                                        q.add(new Position(nextY, nextX, nowCnt + 1,nowDir));

                                    }
                                }
                            }
                        }

                    }
                }
//                System.out.println(flag+" "+xCnt+" "+oCnt);
                if(flag==1 && xCnt==oCnt+1){
                    ans="valid";
                }
                else if(flag==2 && xCnt==oCnt){
                    ans="valid";
                }
                else if(flag==0 && xCnt==5 && oCnt==4){
                    ans="valid";
                }
                else{
                    ans="invalid";
                }
            }
            answer.append(ans+"\n");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
}
/*
XO.OX...X
end
->valid

XXXXXOOOO
XXXXOOXOO
end
->invalid
valid

.XXX.XOOO
end
->invalid

XOXOXOXO.
XOXOXOX..
end
->invalid
valid

XXXXXOOOO
XXXXOOXOO
...XOXOXO
OOOXOXOXX
OOOXX....
end
->invalid
valid
invalid
invalid
invalid

OXOXOXOXX
end
->invalid

.OXXOX.OX
end
->invalid
* */