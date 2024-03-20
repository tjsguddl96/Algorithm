import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] num;
    static int[] lGcd;
    static int[] rGcd;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        num=new int[N];
        lGcd=new int[N];
        rGcd=new int[N];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }
        lGcd[0]=num[0];
        rGcd[N-1]=num[N-1];
        for(int i=1;i<N;i++){
            int now=num[i];
            lGcd[i]=gcd(lGcd[i-1],now);
        }
        for(int i=N-2;i>=0;i--){
            int now=num[i];
            rGcd[i]=gcd(rGcd[i+1],now);
        }
        int answer=-1;
        int removal=0;
        for(int i=0;i<N;i++){
            int now=num[i];
            int nowGcd=0;
            if(i==0){
                nowGcd=rGcd[i+1];
            }
            else if(i==N-1){
                nowGcd=lGcd[i-1];
            }
            else {
                nowGcd = gcd(lGcd[i - 1], rGcd[i + 1]);
            }
            if(now%nowGcd!=0){
                if(answer<nowGcd){
                    answer=nowGcd;
                    removal=now;
                }
            }
        }
        if (answer == -1) {
            System.out.println(answer);
        }
        else {
            System.out.println(answer + " " + removal);
        }

    }
    public static int gcd(int a,int b){//a<b
        if(a>b){
            int tmp=b;
            b=a;
            a=tmp;
        }
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }
}