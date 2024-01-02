import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str1=bf.readLine();
        String str2=bf.readLine();
        ArrayList<Character> kooTmp=new ArrayList<>();
        ArrayList<Character> cubeTmp=new ArrayList<>();
        ArrayDeque<Character> koo=new ArrayDeque<>();
        ArrayDeque<Character> cube=new ArrayDeque<>();
        int N=str1.length();
        for(int i=0;i<N;i++){
            kooTmp.add(str1.charAt(i));
            cubeTmp.add(str2.charAt(i));
        }
        Collections.sort(kooTmp);
//        System.out.println("koo : " +kooTmp);
        Collections.sort(cubeTmp,Collections.reverseOrder());
//        System.out.println("cube : "+cubeTmp);
//        System.out.println("------------------------------------");
        for(int i=0;i<(N+1)/2;i++){
            koo.add(kooTmp.get(i));
        }
        for(int i=0;i<N/2;i++){
            cube.add(cubeTmp.get(i));
        }
        char[] answer=new char[N];
        int left=0;
        int right=N-1;
        for(int i=0;i<N;i++){
            if(i%2==0){ //구사과 차례
                if(!cube.isEmpty() && koo.peek()>=cube.peek()){
                    answer[right]=koo.pollLast();
                    right-=1;
                }
                else{
                    answer[left]=koo.poll();
                    left+=1;
                }
            }
            else{ //큐브 차례
                if(!koo.isEmpty() && koo.peek()>=cube.peek()){
                    answer[right]=cube.pollLast();
                    right-=1;
                }
                else{
                    answer[left]=cube.poll();
                    left+=1;
                }
            }
        }

        System.out.println(String.valueOf(answer));
    }
}
/*
efgh -> 사전 순으로 맨 앞부터 채우려고 함
dcba -> 역순으로(제일 큰 애를) 맨 앞부터 채우려고 함
->????
???e
??de
?gde
=> bgde (??)

* */