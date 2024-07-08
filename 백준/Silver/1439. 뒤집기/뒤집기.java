import java.util.*;
import java.io.*;
public class Main {
    static String S;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        S=bf.readLine();
        //0을 1로
        char prev='1';
        int cnt=0;
        for(int i=0;i<S.length();i++){
            char now=S.charAt(i);
            if(now=='0' && prev=='1'){
                cnt++;
                prev='0';
            }
            else if(now=='1'){
                prev='1';
            }

        }
        answer=Math.min(answer,cnt);
        //1을 0으로
        prev='0';
        cnt=0;
        for(int i=0;i<S.length();i++){
            char now=S.charAt(i);
            if(now=='1' && prev=='0'){
                cnt++;
                prev='1';
            }
            else if(now=='0'){
                prev='0';
            }

        }
        System.out.println(Math.min(answer,cnt));
    }
}