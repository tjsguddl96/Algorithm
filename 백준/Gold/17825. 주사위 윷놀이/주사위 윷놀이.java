import java.util.*;
import java.io.*;
public class Main {
    static int[] dices;
    static int[] positions;//positions[말idx]=현재위치
    static int done;
    static int N=4,M=10;
    static int answer;
    static int[] points;
    static ArrayList<Integer>[] arr;
    static HashSet<Integer>[] set;
    static boolean flag;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        points=new int[33]; //[32]:도착
        set=new HashSet[33];
        arr=new ArrayList[33];
        initPoint();
        positions=new int[N];
        dices=new int[10];
        for(int i=0;i<10;i++){
            dices[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++){
            set[0].add(i);
        }
        solve(0,0,0);
        System.out.println(answer);
    }
    //위치가 5,10,15이면 arr[위치].get(1)로 이동해야됨
    public static void solve(int diceIdx,int point,int done){
        answer=Math.max(answer,point);
        if(diceIdx==M || done==N){
            return ;
        }
        for(int i=0;i<N;i++){
            int nowPosition=positions[i];
            flag=true;
            if(nowPosition==32){
                continue;
            }
            if(nowPosition!=5 && nowPosition!=10 && nowPosition!=15) {
                move(dices[diceIdx], 1, arr[nowPosition].get(0), i);
                if(!flag){
                    continue;
                }
                set[nowPosition].remove(i);
                set[positions[i]].add(i);
            }
            else{
                move(dices[diceIdx],1,arr[nowPosition].get(1),i);
                if(!flag){
                    continue;
                }
                set[nowPosition].remove(i);
                set[positions[i]].add(i);
//                System.out.println(i+" : "+nowPosition+" -> "+positions[i]+" "+points[positions[i]]);
            }
            if(positions[i]==32){
                solve(diceIdx+1,point+points[positions[i]],done+1);
            }
            else{
                solve(diceIdx+1,point+points[positions[i]],done);
            }
            set[nowPosition].add(i);
            set[positions[i]].remove(i);
            positions[i]=nowPosition;
        }
    }
    public static void move(int cnt,int moveCnt,int now,int horseIdx){ //처음엔 무조건 한번 간걸로 ㄱㄱ
        if(now>=32){
            positions[horseIdx]=32;
            return ;
        }
        if(cnt==moveCnt){
            if(set[now].size()>=1){
                flag=false;
                return ;
            }
            positions[horseIdx]=now;
            return ;
        }
        move(cnt,moveCnt+1,arr[now].get(0),horseIdx);
    }

    public static void initPoint(){
        for(int i=0;i<33;i++){
            set[i]=new HashSet<>();
            arr[i]=new ArrayList<>();
        }
        arr[0].add(1);
        for(int i=1;i<=20;i++){
            points[i]=2*i;
            if(i==20){
                arr[i].add(32);
            }
            else{
                arr[i].add(i+1);
            }
        }
        int tmp=13;
        for(int i=21;i<24;i++){
            points[i]=tmp;
            if(i==21){
                arr[5].add(i);
            }
            if(i==23){
                arr[i].add(29);
            }
            else {
                arr[i].add(i + 1);
            }
            tmp+=3;
        }
        tmp=22;
        for(int i=24;i<26;i++){
            points[i]=tmp;
            if(i==24){
                arr[10].add(i);
            }
            if(i==25){
                arr[i].add(29);
            }
            else{
                arr[i].add(i+1);
            }
            tmp+=2;
        }
        tmp=28;
        for(int i=26;i<29;i++){
            points[i]=tmp;
            if(i==26){
                arr[15].add(i);
            }
            if(i==28){
                arr[i].add(29);
            }
            else{
                arr[i].add(i+1);
            }
            tmp-=1;
        }
        tmp=25;
        for(int i=29;i<32;i++){
            points[i]=tmp;
            if(i==31){
                arr[i].add(20);
            }
            else{
                arr[i].add(i+1);
            }

            tmp+=5;
        }
    }
}
/*
4 1 4 4 4 4 3 2 2 4
답: 205

4 1 3 4 4 4 3 3 2 4
답: 211

4 3 2 1 3 4 3 4 1 2
답: 202

5 3 2 5 2 4 4 2 4 1
답: 231

3 1 2 5 5 3 2 4 4 3
답: 202

5 3 4 3 1 3 3 3 5 2
답: 216

5 4 5 2 2 2 5 3 1 4
답: 245

1 2 3 4 1 2 3 4 1 2
Ans: 190
1 1 1 1 1 1 1 1 1 1
Ans: 133
5 1 2 3 4 5 5 3 2 4
Ans: 214
5 5 5 5 5 5 5 5 5 5
Ans: 130

3 1 1 5 4 5 3 3 2 5
Ans: 204
3 1 2 5 5 3 2 4 4 3
Ans: 202
3 5 2 5 3 5 2 1 3 1
Ans: 246
4 1 3 4 4 4 3 3 2 4

Ans: 211
4 1 4 4 4 4 3 2 2 4

Ans: 205
4 3 2 1 3 4 3 4 1 2

Ans: 202
4 5 5 5 3 4 3 5 3 4

Ans: 229
5 3 2 5 2 4 4 2 4 1

Ans: 231
5 3 4 3 1 3 3 3 5 2

Ans: 216
5 4 5 2 2 2 5 3 1 4

Ans: 245
5 5 5 5 5 1 1 1 1 1

Ans: 167
5 5 5 5 5 2 2 1 3 3

Ans: 161
5 5 5 5 5 2 2 2 2 2

Ans: 160
* */