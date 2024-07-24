import java.util.*;
import java.io.*;
public class Main {
    static int T,N;
    static StringBuilder answer=new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            N=Integer.parseInt(bf.readLine());
            solve(1,"");
            answer.append("\n");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
    public static void solve(int idx,String str){
        str+=idx;
        if(idx==N){
            int sum=0;
            char nowOp='*';
            String tmp="1";
            for(int i=1;i<str.length();i++){
                char now=str.charAt(i);
                if((int)now>=49 && (int)now<=57){
                    tmp+=now;
                }
                else{
                    if(now==' '){
                        continue;
                    }
                    if(nowOp=='*'){
                        sum+=Integer.parseInt(tmp);
                    }
                    else if(nowOp=='+'){
                        sum+=Integer.parseInt(tmp);
                    }
                    else if(nowOp=='-'){
                        sum-=Integer.parseInt(tmp);
                    }
                    nowOp=now;
                    tmp="";
                }
            }

            if(nowOp=='+'){
                sum+=Integer.parseInt(tmp);
            }
            else if(nowOp=='-'){
                sum-=Integer.parseInt(tmp);
            }
            else if(nowOp=='*'){
                sum+=Integer.parseInt(tmp);
            }
            if(sum==0) {
                answer.append(str+"\n");
            }
            return ;
        }

        solve(idx+1,str+" ");
        solve(idx+1,str+"+");
        solve(idx+1,str+"-");









    }

}