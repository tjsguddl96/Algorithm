import java.util.*;
import java.io.*;

public class Main {
    //누적합 레츠고
    static int m,n,k; // 세로, 가로, 조사할 영역 수
    static int[][] jungle;
    static int[][] ocean;
    static int[][] ice;
    static int[][][] sum; //[][][0] : 정글, [][][1] : 바다, [][][2] : 얼음
    static Answer[] answer;
    static class Answer{
        int j;
        int o;
        int i;
        public Answer(int j,int o,int i){
            this.j=j;
            this.o=o;
            this.i=i;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(bf.readLine());
        jungle=new int[m+1][n+1];
        ocean=new int[m+1][n+1];
        ice=new int[m+1][n+1];
        sum=new int[m+1][n+1][3];
        answer=new Answer[k];
        for(int i=1;i<m+1;i++){
           String str=bf.readLine();
           for(int j=0;j<str.length();j++){
               char now=str.charAt(j);
               if(now=='J'){
                   jungle[i][j+1]=1;
               }
               else if(now=='O'){
                   ocean[i][j+1]=1;
               }
               else{
                   ice[i][j+1]=1;
               }
           }
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                sum[i][j][0]=sum[i][j-1][0]+sum[i-1][j][0]-sum[i-1][j-1][0]+jungle[i][j];
                sum[i][j][1]=sum[i][j-1][1]+sum[i-1][j][1]-sum[i-1][j-1][1]+ocean[i][j];
                sum[i][j][2]=sum[i][j-1][2]+sum[i-1][j][2]-sum[i-1][j-1][2]+ice[i][j];
            }
        }
        for(int i=0;i<k;i++){
            st=new StringTokenizer(bf.readLine());
            int y1=Integer.parseInt(st.nextToken());
            int x1=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int j=sum[y2][x2][0]-sum[y2][x1-1][0]-sum[y1-1][x2][0]+sum[y1-1][x1-1][0];
            int o=sum[y2][x2][1]-sum[y2][x1-1][1]-sum[y1-1][x2][1]+sum[y1-1][x1-1][1];
            int ice=sum[y2][x2][2]-sum[y2][x1-1][2]-sum[y1-1][x2][2]+sum[y1-1][x1-1][2];
            answer[i]=new Answer(j,o,ice);
        }
        for(int i=0;i<k;i++){
            Answer ans=answer[i];
            System.out.println(ans.j+" "+ans.o+" "+ans.i);
        }


    }
}