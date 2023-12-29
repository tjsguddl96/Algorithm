import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str=bf.readLine();
        String answer="SUBMARINE";
        String nowStr="";
        int flag=1;

        int zeroCnt=0;

        for(int i=0;i<str.length();i++){
            char now=str.charAt(i);
            nowStr+=now;
//            System.out.println(nowStr);
            if(nowStr.length()<2){
                continue;
            }
            if(nowStr.charAt(0)=='1'){
                if(now=='0'){
                    zeroCnt+=1;
                }
                else{
                    if(flag==1 && nowStr.length()==2){
                        answer="NOISE";
                        break;
                    }else if(flag==0 && nowStr.length()==2){
                        nowStr="1";
                        continue;
                    }
                    if(nowStr.length()>=3 && zeroCnt<2 &&!nowStr.equals("101")){
                        answer="NOISE";
                        break;
                    }
                    if(nowStr.equals("101") && i==2){
                        answer="NOISE";
                        break;
                    }
                    nowStr="";
                    zeroCnt=0;
                    flag=0;
                }
            }
            else{
                if(now=='0'){
                    answer="NOISE";
                    break;
                }else{
                    nowStr="";
                    flag=1;
                }
            }
//            System.out.println("flag : "+flag);
//            System.out.println(answer);
//            System.out.println("-------------");

        }
        if(nowStr.length()!=0 && flag==1){
            answer="NOISE";
        }
        System.out.println(answer);
    }
}
//1001/100
//1001/01
//1001/1/01 -> ok 101
//1001/01/1/1 -> x
//1001/1/100
//01 10001101
//01011000111