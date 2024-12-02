import java.util.*;
import java.io.*;
public class Main {
    static String input;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        input=bf.readLine();
        String[] tmp=input.split("-");

        for(int i=0;i<tmp.length;i++){
            String now=tmp[i];
            int sum=0;
            String[] tmp2=now.split("\\+");
            for(int j=0;j<tmp2.length;j++){
                sum+=Integer.parseInt(tmp2[j]);
            }
            if(i==0){
                answer=sum;
            }
            else{
                answer-=sum;
            }

        }
        System.out.println(answer);


    }
}