import java.util.*;
import java.io.*;
public class Main {
    static String str1;
    static String str2;
    static int[][] lcs;
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        str1=bf.readLine();
        str2=bf.readLine();
        N=str1.length();
        M=str2.length();
        lcs=new int[N+1][M+1];
        for(int i=1;i<N+1;i++){
            char c1=str1.charAt(i-1);
            for(int j=1;j<M+1;j++){
                char c2=str2.charAt(j-1);
                if(c1==c2){
                    lcs[i][j]=lcs[i-1][j-1]+1;
                }
                else{
                    lcs[i][j]=Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
        }
        System.out.println(lcs[N][M]);
    }
}