import java.io.*;
import java.util.*;
public class Main {
    static int MAX=123456*2;
    static int[] prime=new int[MAX+1];
    static int[] sum=new int[MAX+1];

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        for(int i=2;i<MAX+1;i++){
            prime[i]=1;
        }
        isPrime();
        for(int i=1;i<MAX+1;i++){
            sum[i]=sum[i-1]+prime[i];
        }
        while(true){
            int N=Integer.parseInt(bf.readLine());
            if(N==0){
                break;
            }
            answer.append(sum[2*N]-sum[N]+"\n");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();


    }
    //prime[i]=1이면 소수
    //prime[i]=0이면 소수x
    public static void isPrime(){
        for(int i=2;i*i<MAX+1;i++){
            if(prime[i]==1) {
                for (int j = i*i; j < MAX+1; j+=i) {
                    prime[j] = 0;
                }
            }
        }
    }
}
