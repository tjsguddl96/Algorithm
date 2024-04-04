import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static class Mos implements Comparable<Mos>{
        int time;
        int flag; //flag==0 -> in, flag==1 -> out
        public Mos(int time,int flag){
            this.time=time;
            this.flag=flag;
        }
        @Override
        public int compareTo(Mos o){
            int x=this.time-o.time;
            if(x==0){
                x=o.flag-this.flag; //out이 먼저
            }
            return x;
        }
    }
    static PriorityQueue<Mos> pq=new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        N=Integer.parseInt(bf.readLine());

        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            int in=Integer.parseInt(st.nextToken());
            int out=Integer.parseInt(st.nextToken());
            pq.add(new Mos(in,0));
            pq.add(new Mos(out,1));
        }
        int answerIn=0;
        int answerOut=-1;
        int max=0;
        int cnt=0;
        int tmp=0;
        while(!pq.isEmpty()){
            Mos now=pq.poll();
            int nowTime=now.time;
            int nowFlag=now.flag;
            if(nowFlag==0){
                cnt++;
            }
            else{
                cnt--;
            }
            if(max<cnt){
                max=cnt;
                answerIn=nowTime;
                tmp=0;
            }
            else if(max==cnt && nowTime!=answerOut){
                tmp=1;
            }

            if(tmp==1){
                continue;
            }
            if(cnt==max-1 && nowFlag==1){
                answerOut=nowTime; //max가 똑같은데 떨어져 있는 구간, max가 똑같은데 붙어있는 구간을 고려 해야됨
            }

        }
        answer.append(max+"\n");
        answer.append(answerIn+" "+answerOut);
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
}
/*

5
2 16
2 4
3 4
9 10
8 10
->3
3 4

3
2 16
4 6
6 10
-> 2
4 10

6
2 16
2 4
3 4
8 10
9 12
9 10
->4
9 10
* */