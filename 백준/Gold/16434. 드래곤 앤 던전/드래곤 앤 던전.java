import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long H;
    static class Info{
        int t;
        int a;
        int h;
        public Info(int t,int a,int h){
            this.t=t;
            this.a=a;
            this.h=h;
        }
    }
    static ArrayList<Info> list=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        H=Long.parseLong(st.nextToken());
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(bf.readLine());
            int t=Integer.parseInt(st.nextToken());
            int a=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            list.add(new Info(t,a,h));

        }
        long answer=0L;
        long mid=0L;
        long left=1L;
        long right=1000000000000000000L;
        while(left<=right){
            mid=(right+left)/2;
            long nowAttack=H;
            long life=mid;
            for(int i=0;i<list.size();i++){
                Info now=list.get(i);
                int t=now.t;
                int a=now.a;
                int h=now.h;
                if(t==1){//용
                    long demage=0L;
                    if(h%nowAttack==0){
                        demage=(long)((h/nowAttack)-1)*a;
                    }
                    else{
                        demage=(long)(h/nowAttack)*a;
                    }
                    life-=demage;
                    if(life<=0){ //죽음 -> break;하고 오른쪽으로
                        break;
                    }
                }
                else{//포션
                    nowAttack+=a;
                    life+=h;
                    if(life>mid){
                        life=mid;
                    }
                }
            }
            if(life<=0){//오
                left=mid+1;
            }
            else{//왼
                answer=mid;
                right=mid-1;
            }
        }
        System.out.println(answer);
    }
}
/*
4 3
1 1 20
1 2 40
2 3 10
1 100 100
* */