import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static long k;
    static int[] input;
    static boolean[] ch;
    static int[] ans;
    static int op;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        ch=new boolean[N+1];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        op=Integer.parseInt(st.nextToken());
        if(op==1){
            k=Long.parseLong(st.nextToken());
            ans=new int[N];
            for(int i=N-1;i>0;i--){
                long fac=factorial(i);
                long tmp1=k/fac;
                long tmp2=k%fac;
                if(tmp2!=0) {
                    tmp1++;
                }
                int tmpCnt=0;
                int tmp=0;
                for(int j=1;j<N+1;j++){
                    boolean flag=true;
                    for(int k=0;k<N-(i+1);k++){
                        if(ans[k]==j){
                           flag=false;
                           break;
                        }
                    }
                    if(!flag){
                        continue;
                    }
                    tmpCnt++;
                    if(tmpCnt==tmp1){
                        tmp=j;
                        break;
                    }
                }
                ans[N-(i+1)]=tmp;
                ch[tmp]=true;
                k=tmp2;
            }
            for(int j=0;j<N;j++) {
                if(ans[j]!=0){
                    continue;
                }
                for (int i = N; i >0; i--) {
                    if (!ch[i]) {
                        ans[j]=i;
                        ch[i]=true;
                        break;
                    }
                }
            }
            StringBuilder answer=new StringBuilder();
            for(int i=0;i<N;i++){
                answer.append(ans[i]+" ");
            }
            System.out.println(answer.toString());
        }
        else{
            long answer=0;
            input=new int[N];
            for(int i=0;i<N;i++){
                input[i]=Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<N;i++){
                int tmpCnt=1;
                for(int j=0;j<i;j++){
                    if(input[i]>input[j]){
                        tmpCnt++;
                    }
                }
                answer+=(input[i]-tmpCnt)*factorial(N-(i+1));
            }
            System.out.println(answer+1);
        }
    }
    public static long factorial(int n){
        long result=1;
        for(int i=2;i<=n;i++){
            result*=i;
        }
        return result;
    }
}
/*
4
2 4 3 2 1
-> 24

5
2 1 5 4 3 2
-> 24

5
2 2 1 3 4 5
-> 25
* */