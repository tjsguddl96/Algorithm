import java.util.*;
import java.io.*;
public class Main {
    static int N,answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        for(int n=0;n<N;n++){
            String str=bf.readLine();
            Stack<Character> stack=new Stack<>();
            for(int i=0;i<str.length();i++){
                char now=str.charAt(i);
                if(stack.isEmpty()){
                    stack.add(now);
                }
                else{
                    if(stack.peek()==now){
                        stack.pop();
                    }
                    else{
                        stack.add(now);
                    }
                }
            }
            if(stack.isEmpty()){
                answer++;
            }
        }
        System.out.println(answer);
    }
}