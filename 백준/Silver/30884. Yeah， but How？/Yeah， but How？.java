import java.io.*;
import java.util.*;

public class Main {
    static String input;
    static class Node{
        int idx;
        char c;
        public Node(int idx,char c){
            this.idx=idx;
            this.c=c;
        }
    }
    static class Add implements Comparable<Add>{
        int a;
        int b;
        char c;
        public Add(int a,int b,char c){
            this.a=a;
            this.b=b;
            this.c=c;
        }

        @Override
        public int compareTo(Add o){
            int x=this.a-o.a;
            return x;
        }
        @Override
        public String toString(){
            return a+" "+b+" "+c;
        }
    }
    static Stack<Node> stack=new Stack<>();
    static PriorityQueue<Add> list=new PriorityQueue<>();
    static StringBuilder answer=new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        input=bf.readLine();
        stack.add(new Node(0,input.charAt(0)));
        // answer+=input.charAt(0);
        answer.append(input.charAt(0));
        for(int i=1;i<input.length();i++){
            char now=input.charAt(i);
            if(now=='('){
                if(!stack.isEmpty() && (stack.peek().idx)+1==i){
                    stack.add(new Node(i,now));
                    // answer+=now;

                    answer.append(now);
                }
                else{
                    // list.add(new Add(i-1,i,'+'));
                    // answer+="+";
                    answer.append("+");
                    // answer+=now;
                    answer.append(now);
                    stack.add(new Node(i,now));
                }
            }
            else{
                if(!stack.isEmpty() && (stack.peek().idx)+1==i){
                    // list.add(new Add(i-1,i,'1'));
                    stack.pop();
                    // answer+="1";
                    answer.append("1");
                    answer.append(now);
                    // answer+=now;
                }
                else{
                    stack.pop();
                    // answer+=now;
                    answer.append(now);
                }
            }
        }
        
        // for(int i=0;i<input.length();i++){
        //     if(!list.isEmpty()){
        //         if(list.peek().a>=i){
        //             answer+=input.charAt(i);
        //         }
        //         else{
        //             answer+=list.poll().c;
        //             answer+=input.charAt(i);
        //         }
        //     }
        //     else{
        //         answer+=input.charAt(i);
        //     }
        // }
        // System.out.println(answer);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        bw.flush();
        bw.write(answer.toString());
        bw.close();
        
    }
}