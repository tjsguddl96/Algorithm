import java.util.*;
import java.io.*;

public class Main {
    static Stack<String> st=new Stack<>();
    static int N;
    static String input;
    static boolean flag=false;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        input=bf.readLine();
        N=input.length();
        for(int i=0;i<N;i++){
            char now=input.charAt(i);
            if(now=='(' || now=='['){
                st.add(now+"");
            }
            else if(now==')'){
                int tmp=0;
                if(st.isEmpty()){
                    flag=true;
                }
                else {
                    while(!st.isEmpty() && !st.peek().equals("(")){
                        if(st.peek().equals("[")){
                            flag=true;
                            break;
                        }
                        tmp+=Integer.parseInt(st.pop());

                    }
                    if(!st.isEmpty() && st.peek().equals("(")){
                        st.pop();
                        if(tmp==0){
                            st.add("2");
                        }else{
                            int tmp2=tmp*2;
                            st.add(tmp2+"");
                        }
                    }
                    else{
                        flag=true;
                        break;
                    }
                }
            }
            /*
            [][[][]]

            * */
            else if(now==']'){
                int tmp=0;
                if(st.isEmpty()){
                    flag=true;
                }
                else {
                    while(!st.isEmpty() && !st.peek().equals("[")){
                        if(st.peek().equals("(")){
                            flag=true;
                            break;
                        }
                        tmp+=Integer.parseInt(st.pop());

                    }
                    if(!st.isEmpty() && st.peek().equals("[")){
                        st.pop();
                        if(tmp==0){
                            st.add("3");
                        }else{
                            int tmp2=tmp*3;
                            st.add(tmp2+"");
                        }
                    }
                    else{
                        flag=true;
                        break;
                    }
                }
            }
            if(flag){
                break;
            }
        }


        int answer=0;
        while (!st.isEmpty()) {
            if(st.peek().equals("(") || st.peek().equals(")") || st.peek().equals("[") || st.peek().equals("]")){
                flag=true;
                break;
            }
            answer+=Integer.parseInt(st.pop());
        }
        if(flag){
            System.out.println("0");
        }
        else {
            System.out.println(answer);
        }

    }
}