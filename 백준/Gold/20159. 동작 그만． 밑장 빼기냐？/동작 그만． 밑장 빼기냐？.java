import java.util.*;
import java.io.*;

public class Main {
    static int[] card;
    static long[] sum;
    static long[] sum2;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int size=n/2;
        card=new int[n];
        sum=new long[size];
        sum2=new long[size];
        for(int i=0;i<n;i++){
            card[i]=Integer.parseInt(st.nextToken());
        }
        sum[0]=card[n-1];
        for(int i=0;i<n-1;i++){
            if(i%2==0){
                if(i/2!=0) {
                    sum2[i / 2] = sum2[i / 2 - 1] + card[i];
                }
                else{
                    sum2[i/2]=card[i];
                }
            }
            else{
                sum[i/2+1]=sum[i/2]+card[i];
            }
        }
        int lastCard=card[n-1];
        long answer=sum[size-1];
        for(int i=1;i<n;i++){
            if(i%2==1){
                answer=Math.max(answer,sum2[i/2]+sum[size-1]-sum[i/2]);
            }
            else {
                answer=Math.max(sum2[i/2-1]+lastCard+sum[size-1]-sum[i/2],answer);
            }
        }

        System.out.println(answer);

    }
}
/*
8
1 2 5 4 3 30 6 8
* */