import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static boolean[] ch;
    static int[] mix;
    static long a=1L;
    static long LCM=1L;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(bf.readLine());
        mix=new int[n+1];
        ch=new boolean[n+1];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=1;i<n+1;i++){
            int m=Integer.parseInt(st.nextToken());
            mix[m]=i;
            if(i==m){
                ch[m]=true;
            }
        }
        for(int i=1;i<n+1;i++){
            if(ch[i]) {
                continue;
            }
            recursion(i,mix[i],1);
        }

        System.out.println(LCM);
    }
    public static void recursion(int num,int position,int cnt){
        if(!ch[num] && num==position){
            ch[num]=true;
            a=gcd(cnt,a);
            LCM=lcm(LCM,cnt);
            return ;
        }
        int idx=mix[position];
        recursion(num,idx,cnt+1);

    }
    public static long gcd(long a,long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public static long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
}