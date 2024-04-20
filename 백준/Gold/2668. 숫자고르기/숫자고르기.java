import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static HashSet<Integer> num=new HashSet<>();
    static int[] ch;
    static int[] input;
    static int[] prevCh;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        N=Integer.parseInt(bf.readLine());
        ch=new int[N+1];
        input=new int[N+1];
        for(int i=1;i<N+1;i++){
            input[i]=Integer.parseInt(bf.readLine());
            num.add(input[i]);
            ch[i]=1;
        }
        boolean flag=true;
        int cnt=0;
        while(flag==true){
            prevCh=new int[N+1];
            cnt=0;
            for(int i=1;i<N+1;i++){
                prevCh[i]=ch[i];
                ch[i]=1;
            }
            for(int i=1;i<N+1;i++){
                if(num.contains(i)){
                    ch[i]=0;
                }
            }
//            System.out.println("------------");
//            for(int i=1;i<N+1;i++){
//                System.out.print(ch[i]+" ");
//            }
//            System.out.println();
//            for(int i=1;i<N+1;i++){
//                System.out.print(prevCh[i]+" ");
//            }
//            System.out.println("------------");

            for(int i=1;i<N+1;i++){
                if(ch[i]!=prevCh[i]){
                    flag=true;
                    break;
                }
                if(ch[i]==0){
                    cnt++;
                }
                flag=false;
            }
            num=new HashSet<>();
            for(int i=1;i<N+1;i++){
                if(ch[i]==0){
                    num.add(input[i]);
                }
            }

        }
        answer.append(cnt+"\n");
        for(int i=1;i<=N;i++){
            if(ch[i]==0){
                answer.append(i+"\n");
            }
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
}