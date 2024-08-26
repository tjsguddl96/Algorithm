import java.util.*;
import java.io.*;
public class Main {
    static String S;
    static int s;
    static int[] cnt;
    //a:97 z:122;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        S=bf.readLine();
        s=S.length();
        cnt=new int[26];
        for(int i=0;i<s;i++){
            cnt[(int)S.charAt(i)-97]++;
        }
        solve(0,' ');
        System.out.println(answer);
    }
    public static void solve(int depth,char prev){
        if(depth==s){
            answer++;
            return ;
        }
        for(int i=0;i<26;i++){
            if(cnt[i]==0){
                continue;
            }
            if(prev!=(char)(i+97)){
                cnt[i]--;
                solve(depth+1,(char)(i+97));
                cnt[i]++;
            }
        }
    }
}
//abcde