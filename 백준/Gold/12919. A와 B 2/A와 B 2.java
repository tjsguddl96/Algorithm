import java.io.*;
import java.util.*;
public class Main {
    static String S,T;
    static int answer=0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        S=bf.readLine();
        T=bf.readLine();
        recur(T);
        System.out.println(answer);
    }
    public static void recur(String nowString){
        if(nowString.equals(S)){
            answer=1;
            return ;
        }
        if((nowString.length()==S.length() && !nowString.equals(S)) || nowString.length()<S.length()){
            return ;
        }
        if(nowString.charAt(nowString.length()-1)=='A'){
            String newString="";
            for(int i=0;i<nowString.length()-1;i++){
                newString+=nowString.charAt(i);
            }
            recur(newString);
        }
        if(nowString.charAt(0)=='B'){
            String newString="";
            for(int i=nowString.length()-1;i>=1;i--){
                newString+=nowString.charAt(i);
            }
            recur(newString);
        }
    }
}
/*
AB
1. B
BBA
2. B
BABB
3. A
BABBA
4. B
BABBAB
5. A
BABBABA
6. A
BABBABAA

1. T부터 시작
1-1. 맨 뒤 글자가 A면 A를 빼
1-2. 맨 앞 글자가 B면 B빼고 reverse
* */