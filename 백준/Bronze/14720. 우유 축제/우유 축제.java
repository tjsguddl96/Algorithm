import java.util.*;
import java.io.*;
public class Main {
    /*
    * 1. 처음엔 무조건 딸기
    * 2. 딸기 -> 초코
    * 3. 초코 -> 바나나
    * 4. 바나나 -> 딸기
    * 딸 : 0, 초 : 1, 바 : 2
    * */
    static int N;
    static int[] shops;
    static int answer=1;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        shops=new int[N];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            shops[i]=Integer.parseInt(st.nextToken());
        }
        int prev=-1;
        for(int i=0;i<N;i++){
            if(prev!=-1){
                if(shops[i]==(prev+1)%3){
                    answer++;
                    prev=shops[i];
                }
            }
            else if(prev==-1 && shops[i]==0){
                prev=shops[i];
            }
        }
        System.out.println(answer);

    }
}