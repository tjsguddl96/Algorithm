import java.util.*;
import java.io.*;

/*
* */
public class Main {
    static long a;
    static int[] b;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();
        a=Long.parseLong(bf.readLine());
        b=new int[3];
        String input=bf.readLine();
        for(int i=0;i<3;i++){
            b[i]=input.charAt(i)-'0';
        }
        long sum=0;
        for(int i=2;i>=0;i--){
            long tmp=a*b[i];
            answer.append(a*b[i]+"\n");
            sum+=tmp*(long)Math.pow(10,2-i);
        }
        System.out.println(answer.toString()+sum);
    }







}
/*

* */