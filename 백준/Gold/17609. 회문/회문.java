import java.io.*;
import java.util.*;
public class Main {
    static int T;
    static StringBuilder answer=new StringBuilder();
    static int[] ans;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        T=Integer.parseInt(bf.readLine());
        ans=new int[T];
        for(int t=0;t<T;t++){
            String str=bf.readLine();
            ans[t]=-1;
            int left=0;
            int right=str.length()-1;
            check(str,left,right,0,t);
            answer.append(ans[t]+"\n");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
    public static void check(String str,int left,int right,int flag,int T){
        if(left>right){
            ans[T]=flag;
            return ;
        }
        if(str.charAt(left)==str.charAt(right)){
            check(str,left+1,right-1,flag,T);
        }
        else{
            if(flag==1){
                return ;
            }
            check(str, left+1, right, 1,T);
            check(str,left,right-1,1,T);
            if(ans[T]==-1){
                ans[T]=2;
            }
        }
    }
}
/*
1
xyyyyxy
->1
* */