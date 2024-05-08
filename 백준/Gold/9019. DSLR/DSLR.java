import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static int A,B;
    static int[] a;
    static int[] b;
    static class Num{
        int num;
        int cnt;
        String op;
        public Num(int num,int cnt,String op){
            this.num=num;
            this.cnt=cnt;
            this.op=op;
        }
    }
    static ArrayDeque<Num> q;
    static int[] ch;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            st=new StringTokenizer(bf.readLine());
            q=new ArrayDeque<>();
            A=Integer.parseInt(st.nextToken());
            B=Integer.parseInt(st.nextToken());
            a=new int[4];
            b=new int[4];
            q.add(new Num(A,0,""));
            ch=new int[10000];
            ch[A]=1;
            while(!q.isEmpty()){
                Num now=q.poll();
                int nowNum=now.num;
                int cnt=now.cnt;
                String nowOp=now.op;
                if(nowNum==B){
                    answer.append(nowOp+"\n");
                    break;
                }
                //D
                int tmpNum=nowNum*2;
                if(tmpNum>9999){
                    tmpNum%=10000;
                }
                if(ch[tmpNum]==0) {
                    q.add(new Num(tmpNum, cnt + 1, nowOp + "D"));
                    ch[tmpNum]=1;
                }
                //S
                tmpNum=nowNum-1;
                if(nowNum==0){
                    tmpNum=9999;
                }
                if(ch[tmpNum]==0) {
                    q.add(new Num(tmpNum, cnt + 1, nowOp + "S"));
                    ch[tmpNum]=1;
                }
                //L
                int tmp=nowNum/1000;
                tmpNum=(nowNum%1000)*10+tmp;
                if(ch[tmpNum]==0) {
                    q.add(new Num(tmpNum, cnt + 1, nowOp + "L"));
                    ch[tmpNum]=1;
                }
                //R
                tmp=nowNum%10;
                tmpNum=tmp*1000+nowNum/10;
                if(ch[tmpNum]==0) {
                    q.add(new Num(tmpNum, cnt + 1, nowOp + "R"));
                    ch[tmpNum]=1;
                }
            }

        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
}
/*
1
0 1000
-> SDDLDSLDRDDD


* */