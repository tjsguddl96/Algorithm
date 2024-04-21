import java.util.*;
import java.io.*;

public class Main {
    static String input;
    static String[] ans;
    static int tmpIdx1=-1; //::의 첫 번째 idx
    static int tmpIdx2=-1; //::의 첫 번째 idx
    static String[] zero={"","0","00","000"};
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        input=bf.readLine();
        ans=new String[8];
        int idx=0;
        String tmp="";
        int flag=0;
        for(int i=0;i<input.length();i++){
            char now=input.charAt(i);
            if(now==':'){
                if(flag==1){
                    tmpIdx1=idx;
                    break;
                }
                if(tmp.equals("")){
                    flag=1;
                    continue;
                }
                ans[idx]=tmp;
                flag=1;
                tmp="";
                idx++;
            }
            else{
                tmp+=now;
                flag=0;
            }
        }
        if(idx==7){
            ans[idx]=tmp;
        }
        if(tmpIdx1!=-1){
            tmp="";
            flag=0;
            idx=7;
            for(int i=input.length()-1;i>=0;i--){
                char now=input.charAt(i);
                if(now==':'){
                   if(flag==1){
                       tmpIdx2=idx;
                       break;
                   }
                    if(tmp.equals("")){
                        flag=1;
                        continue;
                    }
                   String t="";
                   for(int j=tmp.length()-1;j>=0;j--){
                       t+=tmp.charAt(j);
                   }
                   ans[idx]=t;
                   flag=1;
                   tmp="";
                   idx--;
                }
                else{
                    tmp+=now;
                    flag=0;
                }
            }
        }
        if(tmpIdx1!=-1) {
            for (int i = tmpIdx1; i <= tmpIdx2; i++) {
                ans[i] = "0000";
            }
        }
        for(int i=0;i<8;i++){
            String now=ans[i];
            if(now.length()<4){
                ans[i]=zero[4-now.length()]+ans[i];
            }
        }
        for(int i=0;i<8;i++){
            if(i==7){
                System.out.print(ans[i]);
            }
            else {
                System.out.print(ans[i] + ":");
            }
        }
    }
}