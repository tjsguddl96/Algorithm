import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static class trainPrice{
        int ticket;
        int ic;
        int card;
        public trainPrice(int ticket,int ic,int card){
            this.ticket=ticket;
            this.ic=ic;
            this.card=card;
        }
    }
    static int plan[];
    static trainPrice train[];
    static long trainCnt[];
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken()); //도시 갯수
        m=Integer.parseInt(st.nextToken()); //여행 일자

        plan=new int[m]; //j일 째, Pj -> Pj+1로 이동
        train=new trainPrice[n-1];
        trainCnt=new long[n]; //해당 철도 타는 횟수


        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<m;i++){
            plan[i]=Integer.parseInt(st.nextToken())-1;
        }

        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(bf.readLine());

            int ticket=Integer.parseInt(st.nextToken());
            int ic=Integer.parseInt(st.nextToken());
            int card=Integer.parseInt(st.nextToken());

            train[i]=new trainPrice(ticket,ic,card);
        }
        for(int i=0;i<m-1;i++){
            if(plan[i]<plan[i+1]){
                trainCnt[plan[i]]+=1;
                trainCnt[plan[i+1]]-=1;
            }
            else{
                trainCnt[plan[i+1]]+=1;
                trainCnt[plan[i]]-=1;
            }
        }
        long ans=0;
        long sum=0;
        for(int i=0;i<n-1;i++){
            sum+=trainCnt[i];
            long ticket=sum*train[i].ticket;
            long card=(sum*train[i].ic)+train[i].card;
            ans+=Math.min(ticket,card);
        }
        System.out.println(ans);
    }

}