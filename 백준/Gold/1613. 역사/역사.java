import java.util.*;
import java.io.*;

public class Main {
    static int answer=0;
    static int INF=999999999;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answerStr=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] history=new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                history[i][j]=INF;
            }
        }
        for(int i=0;i<m;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken()); //n2보다 큼 -> n2의 bigger에 저장
            int n2=Integer.parseInt(st.nextToken()); //n1보다 작음 -> n1의 smaller에 저장
            //n1>n2
            //n1의 큰 것들은 모두 n2의 큰것들
            history[n2][n1]=1;
        }
        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    history[i][j]=Math.min(history[i][j],history[i][k]+history[k][j]);
                }
            }
        }
        
        int s=Integer.parseInt(bf.readLine());
        for(int i=0;i<s;i++){
            answer=0;
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            if(history[n2][n1]!=INF){
                answer=-1;
            }else if(history[n1][n2]!=INF){
                answer=1;
            }else{
                answer=0;
            }
            answerStr.append(answer+"\n");
        }
        System.out.println(answerStr.toString());
    }

}