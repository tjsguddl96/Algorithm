import java.util.*;
import java.io.*;
public class Main {
    static int n,m;
    static long[][] d;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        n=Integer.parseInt(bf.readLine());
        m=Integer.parseInt(bf.readLine());
        d=new long[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==j){
                    d[i][j]=0;
                    continue;
                }
                d[i][j]=Long.MAX_VALUE;
            }
        }
        StringTokenizer st;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            d[n1][n2]=Math.min(d[n1][n2],w);
        }

        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(d[i][k]==Long.MAX_VALUE || d[k][j]==Long.MAX_VALUE){
                        continue;
                    }
                    else {
                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(d[i][j]==Long.MAX_VALUE){
                    answer.append(0+" ");
                }
                else {
                    answer.append(d[i][j] + " ");
                }
            }
            answer.append("\n");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();

    }
}