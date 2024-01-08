import java.util.*;
import java.io.*;

public class Main {
    static int V,E;
    static int[][] dist;
    static int INF=999999999;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        dist=new int[V+1][V+1];
        for(int i=1;i<V+1;i++){
            for(int j=1;j<V+1;j++){
                dist[i][j]=INF;
            }
        }
        for(int i=0;i<E;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            dist[n1][n2]=d;
        }


        for(int k=1;k<V+1;k++){
            for(int i=1;i<V+1;i++){
                for(int j=1;j<V+1;j++){
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        int answer=INF;
        for(int i=1;i<V+1;i++){
            if(answer>dist[i][i]){
                answer=dist[i][i];
            }
        }
        if(answer==INF){
            answer=-1;
        }
        System.out.println(answer);


    }
}