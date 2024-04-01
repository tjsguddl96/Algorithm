import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static int[] end;
    static int[] sum;
    static int[] endSum;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        end=new int[K+1]; //end도 1부터 사용!
        sum=new int[N+1];
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            int input=Integer.parseInt(st.nextToken());
            sum[i]=input+sum[i-1];
        }
        for(int i=1;i<K+1;i++){
            if(i==K){
                end[i]=N;
            }
            else{
                end[i]=i;
            }
        }
        int answer=0;

        while(true){
            endSum=new int[K+1];
            int min=Integer.MAX_VALUE;
            int minIdx=-1;
            for(int i=1;i<K+1;i++){
                if(i==1){
                    endSum[i]=sum[end[i]];
                }
                else {
                    endSum[i] = sum[end[i]] - sum[end[i - 1]];
                }
                if(min>endSum[i]){
                    min=endSum[i];
                    minIdx=i;
                }
            }
            answer=Math.max(answer,min);
            if(minIdx==K){
                break;
            }
            end[minIdx]++;
            for(int i=minIdx+1;i<K+1;i++){
                if(end[i-1]==end[i]){
                    end[i]++;
                }
                else{
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}