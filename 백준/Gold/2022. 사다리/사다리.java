import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        double x=Double.parseDouble(st.nextToken());
        double y=Double.parseDouble(st.nextToken());
        double c=Double.parseDouble(st.nextToken());
        double left=0.0;
        double right=Math.min(x,y);
        double mid=0.0;
        while(left+0.001<right){
            mid=(left+right)/2;
            double h1=Math.sqrt(Math.pow(y,2)-Math.pow(mid,2));
            double h2=Math.sqrt(Math.pow(x,2)-Math.pow(mid,2));
            double tmpC=(h1*h2)/(h1+h2);
            if(tmpC>=c){
                left=mid;
            }
            else{
                right=mid;
            }
        }
        System.out.println(String.format("%.3f",mid));
    }
}