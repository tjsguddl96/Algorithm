import java.io.*;
import java.util.*;
public class Main {
    static int T;
    static ArrayDeque<Character> q;
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(bf.readLine());
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        for(int t=0;t<T;t++){
            String input=bf.readLine();
            q=new ArrayDeque<>();
            stack=new Stack<>();
            for(int i=0;i<input.length();i++){
                char now=input.charAt(i);
                if(now=='<'){
                    if(!q.isEmpty()){
                        stack.add(q.pollLast());
                    }
                }
                else if(now=='>'){
                    if(!stack.isEmpty()){
                        q.add(stack.pop());
                    }
                }
                else if(now=='-'){
                    if(!q.isEmpty()) {
                        q.pollLast();
                    }
                }
                else{
                    q.add(now);
                }
            }
            while(!stack.isEmpty()){
                q.add(stack.pop());
            }
            while(!q.isEmpty()){
                answer.append(q.poll());
            }
            answer.append("\n");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();


    }
}

/*
7
BPS<<-
BPS<<<-
abcd<<-
abcd<<e
abcd<<eb>f
abcd<<eb>f-
abcd<<eb>f--
-> PS
->BPS
->acd
->abecd
->abebcfd
->abebcd
->abebd
* */
