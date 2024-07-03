import java.util.*;
import java.io.*;
public class Main {
    static int k;
    static int[] res;
    static long min=9999999999L;
    static String minAns;
    static String maxAns;

    static long max=0L;
    static int[] ch;
    static char[] op;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        k=Integer.parseInt(bf.readLine());
        op=new char[k+1];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=1;i<k+1;i++){
            op[i]=st.nextToken().charAt(0);
        }
        res=new int[k+1];
        ch=new int[10];
        permutation(0);
        System.out.println(maxAns);
        System.out.println(minAns);
    }
    public static void permutation(int cnt){
        if(cnt==k+1){
            boolean flag=true;
            String str="";
            for(int i=1;i<k+1;i++){
                int n1=res[i-1];
                int n2=res[i];
                str+=n1;
                if(op[i]=='<'){
                    if(n1>=n2){
                        flag=false;
                        break;
                    }
                }
                else{
                    if(n1<=n2){
                        flag=false;
                        break;
                    }
                }
            }
            str+=res[k];
            if(flag){
                if(min>Long.parseLong(str)){
                    min=Math.min(min,Long.parseLong(str));
                    minAns=str;
                }
                if(max<Long.parseLong(str)){
                    max=Math.max(max,Long.parseLong(str));
                    maxAns=str;
                }
            }
            return ;
        }
        for(int i=0;i<10;i++){
            if(ch[i]==0){
                ch[i]=1;
                res[cnt]=i;
                permutation(cnt+1);
                ch[i]=0;
            }
        }
    }
}