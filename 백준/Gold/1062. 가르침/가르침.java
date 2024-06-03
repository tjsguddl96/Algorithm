import java.util.*;
import java.io.*;
public class Main {
    static int N,K;
    static int answer;
    static int[] ch;
    static int[] temp={97,110,116,105,99};
    static String[] input;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        ch=new int[26];
        input=new String[N];
        for(int i=0;i<temp.length;i++){
            ch[temp[i]-97]=1;
        }
        for(int i=0;i<N;i++){
            String str=bf.readLine();
            String in="";
            for(int j=0;j<str.length();j++){
                char c=str.charAt(j);
                if(ch[(int)c-97]==1){
                    continue;
                }
                in+=c;
            }
            input[i]=in;
        }
        if(K<5){
            System.out.println(0);
        }
        else if(K>=26){
            System.out.println(N);
        }
        else{
            combination(0,0);
            System.out.println(answer);
        }

    }
    public static void combination(int cnt,int idx){
        if(cnt==K-5){
            //이때 ans 계산
            int count=0;
            for(int i=0;i<N;i++) {
                int flag=0;
                for(int j=0;j<input[i].length();j++){
                    if(ch[(int)input[i].charAt(j)-97]==0){
                        flag=1;
                        break;
                    }
                }
                if(flag==1){
                    continue;
                }
                count++;
            }
            answer=Math.max(answer,count);
            return ;
        }
        for(int i=idx;i<26;i++){
            if(ch[i]==0) {
                ch[i] = 1;
                combination(cnt + 1, i+1);
                ch[i] = 0;
            }
        }

    }
}