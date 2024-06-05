import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static String answer="";
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        if(N==1){
            System.out.println("1");
        }
        else {
            dfs("", 0);
            System.out.println(answer);
        }
    }
    public static void dfs(String nowStr,int cnt) {
        if(!answer.equals("")){
            return ;
        }

        for(int i=1;i<=nowStr.length()/2;i++){
            String tmp1="";
            String tmp2="";
            int idx=nowStr.length()-1;
            for(int j=0;j<i;j++){
                tmp1+=nowStr.charAt(idx);
                idx--;
            }
            for(int j=0;j<i;j++){
                tmp2+=nowStr.charAt(idx);
                idx--;
            }
            if(tmp1.equals(tmp2)){
                return ;
            }
        }
        if(cnt==N){
            for(int i=1;i<=nowStr.length()/2;i++){
                String tmp1="";
                String tmp2="";
                int idx=nowStr.length()-1;
                for(int j=0;j<i;j++){
                    tmp1+=nowStr.charAt(idx);
                    idx--;
                }
                for(int j=0;j<i;j++){
                    tmp2+=nowStr.charAt(idx);
                    idx--;
                }
                if(!tmp1.equals(tmp2)){
                    answer=nowStr;
                    return ;
                }
            }
            return ;
        }
        for(int i=1;i<=3;i++){
            String next=i+"";
            dfs(nowStr+next,cnt+1);
        }
    }
}