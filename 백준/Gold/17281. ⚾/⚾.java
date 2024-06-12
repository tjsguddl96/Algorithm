import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] input;
    static int[] ch;
    static int[] res;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        input=new int[N][10];
        ch=new int[10];
        res=new int[9];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=1;j<10;j++){
                input[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        permutation(0);
        System.out.println(answer);
    }
    public static void permutation(int cnt){
        if(cnt==3){
            res[cnt]=1;
            permutation(cnt+1);
        }
        if(cnt==9){
            int nowPlayer=0;
            int point=0;
            for(int i=0;i<N;i++){
                int outCnt=0;
                int nowRoo=0;
                while(outCnt<3){
                    nowPlayer%=9;
                    int result=input[i][res[nowPlayer]];
                    if(result==0){
                        outCnt++;
                    }
                    else{
                        for(int j=0;j<result;j++){
                            if(j==3){
                                break;
                            }
                            nowRoo=nowRoo<<1;
                            if(nowRoo>=8){
                                point+=1;
                            }
                            nowRoo=nowRoo&7;
                        }
                        if(result==1){
                            nowRoo=nowRoo|1;
                        }
                        else if(result==2){
                            nowRoo=nowRoo|2;
                        }
                        else if(result==3){
                            nowRoo=4;
                        }
                        else if(result==4){
                            //홈런 이니까 +1
                            point+=1;
                            nowRoo=0;
                        }
                    }
                    nowPlayer++;
                }
            }
            answer=Math.max(answer,point);
            return ;
        }
        for(int i=2;i<10;i++){
            if(ch[i]==0){
                ch[i]=1;
                res[cnt]=i;
                permutation(cnt+1);
                ch[i]=0;
            }
        }

    }
}