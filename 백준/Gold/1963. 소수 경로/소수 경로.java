import java.util.*;
import java.io.*;
public class Main {
    static int T;
    static String A,B;
    static boolean[] prime;
    static int[] ch;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder ans=new StringBuilder();
        StringTokenizer st;
        T=Integer.parseInt(bf.readLine());
        prime=new boolean[10000]; //prime[i]=true -> i는 prime이 아님, prime[i]=false -> i는 prime
        prime[1]=true;
        isPrime();
        for(int t=0;t<T;t++){
            answer=Integer.MAX_VALUE;
            st=new StringTokenizer(bf.readLine());
            ch=new int[10000];
            for(int i=1000;i<10000;i++){
                ch[i]=Integer.MAX_VALUE;
            }
            A=st.nextToken();
            B=st.nextToken();
            ch[Integer.parseInt(A)]=0;
            dfs(A);
            ans.append(answer+"\n");
        }
        bw.flush();
        bw.write(ans.toString());
        bw.close();
    }
    public static void dfs(String now){
        if(now.equals(B)){
            answer=Math.min(answer,ch[Integer.parseInt(B)]);
            return ;
        }
        if(answer<ch[Integer.parseInt(now)]){
            return;
        }
        char[] nowChar=new char[4];
        for(int i=0;i<4;i++){
            nowChar[i]=now.charAt(i);
        }
        for(int idx=0;idx<4;idx++) {
            char nowC=now.charAt(idx);
            for (int i = 0; i < 10; i++) {
                nowChar[idx] = (i + "").charAt(0);
                String next = "";
                for (int j = 0; j < 4; j++) {
                    next += nowChar[j];
                }
                if (isAvailable(now, next)) {
                    ch[Integer.parseInt(next)] = ch[Integer.parseInt(now)] + 1;
                    dfs(next);
                }
                nowChar[idx]=nowC;
            }
        }

    }



    public static boolean isAvailable(String A,String B){
        int num1=Integer.parseInt(A);
        int num2=Integer.parseInt(B);
        if(num2>=1000 && !prime[num2] && ch[num1]+1<ch[num2]){
            return true;
        }
        return false;
    }
    public static void isPrime(){
        for(int i=2;i<10000;i++){
            if(prime[i]){
                continue;
            }
            for(int j=i*i;j<10000;j+=i){
                prime[j]=true;
            }
        }
    }
}