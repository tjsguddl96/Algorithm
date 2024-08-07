import java.util.*;
import java.io.*;
public class Main {
    static int N,L,answer;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        map=new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        //열
        for(int i=0;i<N;i++){
            int prev=map[0][i]; //[행][열]
            int j=1;
            boolean flag=true;
            int tmpL=1;
            while(j<N){
                int now=map[j][i];
                //1. prev>now -> L만큼 now가 붙어 있는지
                if(prev==now+1) {
                    for (int k = j; k < j + L; k++) {
                        if(k>=N){
                            flag=false;
                            break;
                        }
                        int tmp = map[k][i];
                        if (now != tmp) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        j += L;
                        prev = now;
                    } else {
                        break;
                    }
                    tmpL=0;
                }
                //2. prev==now
                else if(prev==now){
                    tmpL++;
                    j++;
                }

                //3. prev<now ->
                else if(prev+1==now){
                    if(tmpL<L){
                        flag=false;
                        break;
                    }
                    prev=now;
                    tmpL=1;
                    j++;
                }
                else{
                    flag=false;
                    break;
                }
            }
            if(flag){
                answer++;
            }
        }


        //행
        for(int i=0;i<N;i++){
            int prev=map[i][0]; //[행][열]
            int j=1;
            boolean flag=true;
            int tmpL=1;
            while(j<N){
                int now=map[i][j];
                //1. prev>now -> L만큼 now가 붙어 있는지
                if(prev==now+1) {
                    for (int k = j; k < j + L; k++) {
                        if(k>=N){
                            flag=false;
                            break;
                        }
                        int tmp = map[i][k];
                        if (now != tmp) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        j += L;
                        prev = now;
                    } else {
                        break;
                    }
                    tmpL=0;
                }
                //2. prev==now
                else if(prev==now){
                    tmpL++;
                    j++;
                }

                //3. prev<now ->
                else if(prev+1==now){
                    if(tmpL<L){
                        flag=false;
                        break;
                    }
                    prev=now;
                    tmpL=1;
                    j++;
                }
                else{
                    flag=false;
                    break;
                }
            }
            if(flag){
                answer++;
            }
        }
        System.out.println(answer);
    }
}