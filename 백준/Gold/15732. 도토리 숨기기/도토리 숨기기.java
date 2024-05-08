import java.util.*;
import java.io.*;

public class Main {
    static int N,K,D;
    static class Rule{
        int st;
        int end;
        int c;
        public Rule(int st,int end,int c){
            this.st=st;
            this.end=end;
            this.c=c;
        }
    }
    static Rule[] rule;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());
        rule=new Rule[K];
        int max=0;
        for(int i=0;i<K;i++){
            st=new StringTokenizer(bf.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            rule[i]=new Rule(start,end,c);
            max=Math.max(max,end);
        }
        int left=0;
        int right=max;
        int mid=0;
        int MID=0;
        while(left<=right){
            mid=(left+right)/2;
            long cnt=0L;
//            System.out.print(left+" "+right+" "+mid+" ");
            for(int i=0;i<K;i++){
                Rule now=rule[i];
                int start=now.st;
                int end=now.end;
                int c=now.c;
                if(start>mid){
                    continue;
                }
                if(end<mid){
                    cnt+=((end-start)/c+1);
                    continue;
                }
                cnt+=((mid-start)/c+1);
            }
//            System.out.println(cnt);
            if(cnt>=D){
                MID=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        System.out.println(MID);
    }
}
/*
200 2 5
100 200 10
110 150 15
-> 125

200 3 5
100 150 5
110 150 15
90 100 10
-> 110

200 3 7
100 150 5
110 150 15
90 100 10
-> 115

200 3 2
90 90 10
100 100 5
110 150 15
->100

200 3 3
90 90 10
100 106 5
110 150 15


200 4 25
90 100 10
100 150 5
110 150 15
90 140 7
->111

*/