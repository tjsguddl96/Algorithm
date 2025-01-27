import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        N=Integer.parseInt(bf.readLine());
        map=new int[N][N];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            
            for(int j=0;j<N;j++){
                answer.append((i+1)+" ");
            }
            answer.append("\n");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
        
    }
}