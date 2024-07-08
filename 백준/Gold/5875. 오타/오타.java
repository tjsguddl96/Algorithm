import java.util.*;
import java.io.*;
public class Main {
    static String str;
    static int len;
    static int[] arr;
    static int[] sum1;
    static int[] sum2;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        str=bf.readLine();
        len=str.length();
        arr=new int[len+1];
        sum1=new int[len+1];
        sum2=new int[len+1];
        for(int i=1;i<len+1;i++){
            char now=str.charAt(i-1);
            if(now=='('){
                arr[i]=1;
            }
            else{
                arr[i]=-1;
            }
            sum1[i]=sum1[i-1]+arr[i];
        }
        sum2[len]=arr[len];
        for(int i=len-1;i>0;i--){
            sum2[i]=sum2[i+1]+arr[i];
        }
        if(sum1[len]==-2){ // ) 가 더 많다는 뜻

            for(int i=1;i<len+1;i++){
                if(arr[i]==-1){
                    answer++;
                }
                if(sum1[i]==-1){
                    break;
                }
            }


        }
        else if(sum1[len]==2){ // ( 가 더 많다는 뜻
            for(int i=len;i>0;i--){
                if(arr[i]==1){
                    answer++;
                }
                if(sum2[i]==1){
                    break;
                }
            }
        }


        System.out.println(answer);

    }
}