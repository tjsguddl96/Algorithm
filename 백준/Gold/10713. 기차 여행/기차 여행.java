import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static class info{
        int destination;
        int trainNumber;
        public info(int destination,int trainNumber){
            this.destination=destination;
            this.trainNumber=trainNumber;
        }
    }
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
    static int trainCnt[];
    static ArrayList<info> arr[];
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        n=Integer.parseInt(st.nextToken()); //도시 갯수
        m=Integer.parseInt(st.nextToken()); //여행 일자

        plan=new int[m]; //j일 째, Pj -> Pj+1로 이동
        train=new trainPrice[n-1];
        trainCnt=new int[n-1]; //해당 철도 타는 횟수
        arr=new ArrayList[n];

//        for(int i=0;i<n;i++){
//            arr[i]=new ArrayList<>();
//            if(i>=1 && i<n-1) {
//                arr[i].add(new info(i + 1, i));
//                arr[i].add(new info(i-1,i-1));
//            }else if(i==0){
//                arr[i].add(new info(i+1,i));
//            }else{
//                arr[i].add(new info(i-1,i-1));
//            }
//        }


        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<m;i++){
            plan[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(bf.readLine());

            int ticket=Integer.parseInt(st.nextToken());
            int ic=Integer.parseInt(st.nextToken());
            int card=Integer.parseInt(st.nextToken());

            train[i]=new trainPrice(ticket,ic,card);
        }
        for(int i=0;i<m-1;i++){
            cal(plan[i]-1,plan[i+1]-1);
        }
        int ans=0;
        for(int i=0;i<trainCnt.length;i++){
            int ticket=trainCnt[i]*train[i].ticket;
            int card=(trainCnt[i]*train[i].ic)+train[i].card;
            ans+=Math.min(ticket,card);
        }
        System.out.println(ans);
    }
    public static void cal(int nowCity,int endCity){
        if(nowCity==endCity){ //도착
            return ;
        }
        //nowCity가 endCity보다 작으면 +1하면서 가면 됨 (trainCnt[nowCity] +1)
        if(nowCity<endCity){
            int nextCity=nowCity+1;
            trainCnt[nowCity]+=1;
            cal(nextCity,endCity);
        }
        //nowCity가 endCity보다 크면 -1하면서 가면 됨 (trainCnt[nowCity-1]+1)
        else{
            int nextCity=nowCity-1;
            trainCnt[nowCity-1]+=1;
            cal(nextCity,endCity);

        }
    }

}