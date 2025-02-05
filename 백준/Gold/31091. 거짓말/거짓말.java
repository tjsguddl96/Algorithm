import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr1;
    static int[] arr2;
    static int[] sum1;
    static int[] sum2;
    static ArrayList<Integer> ans=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        StringTokenizer st=new StringTokenizer(bf.readLine());
        //양의 정수 -> 양의 정수 이상이 거짓말, 음수 -> 음수 절댓값 이하가 거짓말
        arr1=new int[N+1]; //이상 거짓말
        arr2=new int[N+1]; //이하 거짓말
        sum1=new int[N+1];
        sum2=new int[N+1];
        for(int i=1;i<N+1;i++){
            int now=Integer.parseInt(st.nextToken());
            if(now>0){
                arr1[now]+=1;
            }
            else if(now==0){
                sum2[0]++;
            }
            else{
                arr2[(-1)*now]+=1;
            }
        }
        for(int i=1;i<N+1;i++){
            sum1[i]=sum1[i-1]+arr1[i];
            sum2[i]=sum2[i-1]+arr2[i];
        }

//        System.out.println(Arrays.toString(sum1));
//        System.out.println(Arrays.toString(sum2));
        for(int i=0;i<N+1;i++){
            if(i==0){
                if(sum1[N] - sum1[i]==i){
                    ans.add(i);
                }
            }
            else {
                if (sum1[N] - sum1[i] + sum2[i - 1] == i) {
                    ans.add(i);
                }
            }

        }

        Collections.sort(ans);
        StringBuilder answer=new StringBuilder();
        answer.append(ans.size()+"\n");
        for(int i=0;i<ans.size();i++){
            answer.append(ans.get(i)+" ");
        }
        System.out.println(answer.toString());





    }
}