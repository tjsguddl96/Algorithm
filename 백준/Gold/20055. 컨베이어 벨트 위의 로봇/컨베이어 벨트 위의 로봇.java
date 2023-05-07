import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class robot{
        int posi; //cnt
        int r; //1이면 로봇이 그 위치에 있고, 0이면 그 위치에 없음
        public robot(int posi, int r){
            this.posi=posi;
            this.r=r;
        }
    }
    static int N,K;
    static robot[] belt;
    static int zeroCnt;
    static Deque<Integer> q=new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(bf.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        belt=new robot[2*N];

        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<2*N;i++){
            belt[i]=new robot(Integer.parseInt(st.nextToken()),0);
        }
        int ans=1;
        //올리는 위치 idx=0, 내리는 위치 Idx=N-1
        while(zeroCnt<K){

            belt=rotateBelt();

            if(belt[N-1].r==1){
                belt[N-1].r=0;
            }
            for(int i=N-1;i>=0;i--){
                if(belt[i].r==1){
                    q.add(i);
                }
            }
            while(!(q.isEmpty())){
                int now=q.pop();
                if(belt[now+1].r==0 && belt[now+1].posi>0){ //이때만 이동 가능
                    if(now+1==N-1){
                        belt[now].r=0;
                        belt[now+1].posi-=1;

                    }else {
                        belt[now + 1].r = 1;
                        belt[now].r = 0;
                        belt[now + 1].posi -= 1;
                    }
                    if(belt[now+1].posi==0){
                        zeroCnt+=1;
                    }
                }

            }
            if(belt[0].posi>0) {
                belt[0].r = 1;
                belt[0].posi -= 1;
                if(belt[0].posi==0){
                    zeroCnt+=1;
                }
            }
            if(zeroCnt>=K){
                continue;
            }
            ans+=1;
        }

        System.out.println(ans);

    }
    public static void print(){
        for(int i=0;i<2*N;i++){
            System.out.println(belt[i].posi+", "+belt[i].r);
        }
        System.out.println("---------------");
    }
    public static robot[] rotateBelt(){
        robot[] tmp=new robot[2*N];
        for(int i=0;i<2*N;i++){
            tmp[(i+1)%(2*N)]=new robot(belt[i].posi,belt[i].r);
        }
        return tmp;
    }
}