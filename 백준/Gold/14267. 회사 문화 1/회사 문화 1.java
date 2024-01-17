import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[] boss;
    static int[] compliment;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        boss=new int[n+1]; //boss[i] = i가 모시고 있는 상사
        compliment=new int[n+1];
        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<n+1;i++){
            boss[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int boss=Integer.parseInt(st.nextToken());
            int comple=Integer.parseInt(st.nextToken());
            compliment[boss]+=comple;
        }
        for(int i=1;i<n+1;i++){
            if(i!=1){
                compliment[i]+=compliment[boss[i]];
            }
            answer.append(compliment[i]+" ");
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();

    }

}