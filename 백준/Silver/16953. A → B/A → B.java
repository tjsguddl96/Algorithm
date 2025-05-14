import java.util.*;
import java.io.*;
public class Main {
    static int A,B;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        A=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());
        solve(A,1);
        if(answer==Integer.MAX_VALUE){
            answer=-1;
        }
        System.out.println(answer);

    }
    public static void solve(long num,int now){
        if(num>B){
            return ;
        }
        else if(num==B){
            answer=Math.min(answer,now);
            return ;
        }
        solve(num * 2, now + 1);
        solve(num * 10 + 1, now + 1);
    }
}
