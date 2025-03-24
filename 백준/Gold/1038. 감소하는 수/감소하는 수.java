import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Long> arr=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        for(int i=0;i<10;i++){
            arr.add((long)i);
        }
        for(int i=1;i<10;i++){
            solve(i,i);
        }
        Collections.sort(arr);
        if(N>1022){
            System.out.println(-1);
        }
        else{
            System.out.println(arr.get(N));
        }


    }
    public static void solve(long num,int lastNum){
        for(int i=0;i<lastNum;i++){
            long makeNum=num*10+i;
            arr.add(makeNum);
            solve(makeNum,i);
        }

    }
}
