import java.util.*;
import java.io.*;
public class Main {
    //1,2,3,4 : 위,아래,왼,오
    static int dy[]={0,-1,1,0,0};
    static int dx[]={0,0,0,-1,1};

    static int n,m,k;
    static class Map{ // (냄새 뿌린 날짜, 상어 번호,y,x), 현재 날짜 - 냄새 뿌린 날짜 >= k이면 해당 위치엔 냄새가 없음.
        int smell;
        int sharkNum;
        int isMove;
        public Map(int smell, int sharkNum,int isMove) {
            this.smell = smell;
            this.sharkNum = sharkNum;
            this.isMove=isMove;
        }
        @Override
        public String toString(){
            return smell+", "+sharkNum;
        }
    }
    static class Shark implements Comparable<Shark>{ // (냄새 뿌린 날짜, 상어 번호,y,x), 현재 날짜 - 냄새 뿌린 날짜 >= k이면 해당 위치엔 냄새가 없음.
        int smell;
        int sharkNum;
        int y;
        int x;
        public Shark(int smell, int sharkNum,int y,int x) {
            this.smell = smell;
            this.sharkNum = sharkNum;
            this.y=y;
            this.x=x;
        }
        @Override
        public String toString(){
            return sharkNum+" "+smell+" "+y+" "+x;
        }
        @Override
        public int compareTo(Shark o) {
            int x=this.smell-o.smell;
            if (x == 0) {
                x=this.sharkNum-o.sharkNum;
            }
            return x;
        }
    }
    static Map map[][];
    static int sharkDir[][][]; //sharkDir[상어번호][바라보고 있는 방향][바라보고 있는 뱡향에서의 우선순위]
    static PriorityQueue<Shark> pq=new PriorityQueue<>(); //smell 오름차순 후, sharkNum 오름차순
    static int headingDir[]; //headingDir[상어번호]=해당 상어가 바라보고 있는 방향
    public static void main(String[] args) throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        map=new Map[n][n];
        sharkDir=new int[m+1][5][4];
        headingDir=new int[m+1];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++){
                int tmp=Integer.parseInt(st.nextToken());
                if(tmp!=0){
                    map[i][j]=new Map(1,tmp,1);
                    pq.add(new Shark(1,tmp,i,j));
                }else {
                    map[i][j] = new Map(0, 0,1);
                }
            }
        }
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<=m;i++){
            headingDir[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=4;j++){
                st=new StringTokenizer(bf.readLine());
                for(int k=0;k<4;k++){
                    sharkDir[i][j][k]=Integer.parseInt(st.nextToken());
                }
            }
        }
        int nowDay=2;
        int previousSharkNum=0;
        while(pq.size()!=1 && nowDay<=1000){

            Shark nowShark=pq.poll();
            int nowSharkNum=nowShark.sharkNum; //현재 상어 번호
            int nowSmell=nowShark.smell; //현재 상어 smell뿌린 날짜
            int nowY=nowShark.y; //현재 상어의 위치
            int nowX=nowShark.x;
            int nowDir=headingDir[nowSharkNum]; //현재 상어의 바라보고 있는 방향
            int isMove=0;

            if(nowSharkNum==1){
                if(previousSharkNum!=nowSharkNum) {
                    nowDay = nowSmell;
                }
            }
            for(int i=0;i<4;i++){
                int move=sharkDir[nowSharkNum][nowDir][i]; //dy[move], dx[move];
                int nextY=nowY+dy[move];
                int nextX=nowX+dx[move];

                if(nextY>=0 && nextY<n && nextX>=0 && nextX<n){ //nextY와 nextX가 유효 범위 인지
                    if((map[nextY][nextX].smell==0) || ((nowDay-map[nextY][nextX].smell)>=k)){ //해당 위치에 향기가 아예 없을 때, 시간이 지나서 (현재 날짜 - smell의 날짜 >=k) 해당 위치에 향기가 없어졌을 때
                        map[nextY][nextX].sharkNum=nowSharkNum;
                        map[nextY][nextX].smell=nowSmell+1;
                        pq.add(new Shark(nowSmell+1,nowSharkNum,nextY,nextX)); //Shark(int smell, int sharkNum,int y,int x)
                        headingDir[nowSharkNum]=move; //바라보고 있는 방향 update
                        isMove=1;
                        map[nextY][nextX].isMove=1;
                        break;
                    }else if(map[nextY][nextX].sharkNum<nowSharkNum && map[nextY][nextX].smell==(nowSmell+1) && map[nextY][nextX].isMove==1){ //가야되는 곳인데, 같은 turn에 이미 숫자가 작은 애가 있을 때, 그냥 쫓겨나
                        isMove=1;
                        map[nextY][nextX].isMove=1;
                        break;
                    }
                }

            }
            if(isMove==0){
                for(int i=0;i<4;i++){
                    int move=sharkDir[nowSharkNum][nowDir][i]; //dy[move], dx[move];
                    int nextY=nowY+dy[move];
                    int nextX=nowX+dx[move];
                    if(nextY>=0 && nextY<n && nextX>=0 && nextX<n){
                        if(map[nextY][nextX].sharkNum==nowSharkNum){
                            map[nextY][nextX].smell=nowSmell+1;
                            headingDir[nowSharkNum]=move;
                            pq.add(new Shark(nowSmell+1,nowSharkNum,nextY,nextX));
                            map[nextY][nextX].isMove=0;
                            break;
                        }
                    }
                }
            }
            previousSharkNum=nowSharkNum;
        }
        if (nowDay > 1000) {
            nowDay=-1;
        }
        System.out.println(nowDay);

    }

    public static void print(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(map[i][j]+" | ");
            }
            System.out.println();
        }
    }
}