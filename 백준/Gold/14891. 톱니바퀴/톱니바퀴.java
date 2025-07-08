import java.util.*;
import java.io.*;

/*

입력은 12시방향부터 시계방향 순서대로 주어진다. N극은 0, S극은 1로 나타나있다.
첫 번째 정수는 회전시킨 톱니바퀴의 번호, 두 번째 정수는 방향이다.
방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향

인덱스는 0번부터 시작
1-2번 톱니는 1번의 2번 인덱스와 2번의 6번 인덱스와 맞닿아 있음
2-3번 2번의 2번 인덱스와 3번의 6번 인덱스와 맞닿아 있음
3-4번 3번의 2번 인덱스와 4번의 6번 인덱스와 맞닿아 있음
둘중에 작은애의 2번, 둘 중에 큰 애의 6번


맞닿아 있는 극끼리 다르다면 회전하는 톱니의 반대 방향으로 돌고
같다면 회전하지 않음
정답은
1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점

------
시계방향 회전
>>shift후
10101111 -> 11010111
x1010111 | a.charAt(7)-'0'
반시계방향 회전
* */
public class Main {
    static String[] cl=new String[4];
    static int K;
    static int[] w;
    //xor -> 다르면 1
    //10011101
    public static void main(String[] args) throws IOException{


        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<4;i++){
            cl[i]=bf.readLine();
        }
        w=new int[4];
        K=Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int i=0;i<K;i++){
            st=new StringTokenizer(bf.readLine());
            int c=Integer.parseInt(st.nextToken());
            int wise=Integer.parseInt(st.nextToken());
            w=new int[4];
            c-=1;
            w[c]=wise; //w[i]=2이면 움직이지 않는것.
            ArrayDeque<Integer> q=new ArrayDeque<>();
            q.add(c);
            while(!q.isEmpty()){
                int now=q.poll();
                if(now+1<4 && w[now+1]==0){
                    int tmp1=cl[now].charAt(2)-'0';
                    int tmp2=cl[now+1].charAt(6)-'0';
                    int tmp=tmp1^tmp2;
                    //맞닿아 있는 극이 다르면 -> 반대 방향 회전
                    if(tmp==1){
                        w[now+1]=w[now]*(-1);
                        q.add(now+1);
                    }
                    else{
                        w[now+1]=2;
                    }

                }
                if(now-1>=0 && w[now-1]==0 ){
                    int tmp1=cl[now].charAt(6)-'0';
                    int tmp2=cl[now-1].charAt(2)-'0';
                    int tmp=tmp1^tmp2;
                    //맞닿아 있는 극이 다르면 -> 반대 방향 회전
                    if(tmp==1){
                        w[now-1]=w[now]*(-1);
                        q.add(now-1);
                    }
                    else{
                        w[now-1]=2;
                    }
                }
            }
            for(int j=0;j<4;j++){
//                System.out.println(j+" "+w[j]);
                if(w[j]==0 || w[j]==2){
                    continue;
                }
                move(j,w[j]);
//                System.out.println(cl[j]);
            }


        }


//        1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
//        2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
//        3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
//        4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
        int answer=0;
        if(cl[0].charAt(0)=='1'){
            answer+=1;
        }
        if(cl[1].charAt(0)=='1'){
            answer+=2;
        }
        if(cl[2].charAt(0)=='1'){
            answer+=4;
        }
        if(cl[3].charAt(0)=='1'){
            answer+=8;
        }
        System.out.println(answer);
////        StringBuilder answer=new StringBuilder();
//

    }
    //시계 방향
    public static void move(int idx,int wise){
        //시계
//        시계방향 회전
//>>shift후
//        10101111 -> 11010111
//        x1010111 | a.charAt(7)-'0'
//        반시계방향 회전
//        10101111 -> 01011111
        String tmp="";
        if(wise==1){
            tmp+=cl[idx].charAt(7);
            for(int i=0;i<7;i++){
                tmp+=cl[idx].charAt(i);
            }

        }
        else if(wise==-1) {
            for(int i=1;i<8;i++){
                tmp+=cl[idx].charAt(i);
            }
            tmp+=cl[idx].charAt(0);
        }
        cl[idx]=tmp;

    }



}

/*
10101111
01111101
11001110
00000010
2
3 -1
1 1
->7
* */