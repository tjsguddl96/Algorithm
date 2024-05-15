import java.util.*;
import java.io.*;
public class Main {
    static int H,W; //높이,너비
    static int[] rain;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        H=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        rain=new int[W];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<W;i++){
            rain[i]=Integer.parseInt(st.nextToken());
        }
        int answer=0;
        for(int h=0;h<H+1;h++){
            ArrayList<Integer> tmp=new ArrayList<>();
            for(int i=0;i<W;i++){
                if(h<=rain[i]){
                    tmp.add(i);
                }
            }
            for(int i=0;i<tmp.size()-1;i++){
                int idx1=tmp.get(i);
                int idx2=tmp.get(i+1);
                for(int j=idx1+1;j<idx2;j++){
                    if(h>rain[j]){
                        answer+=1;
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
/*
4 8
0 1 2 3 4 1 1 2
->2

4 9
0 3 2 3 4 1 1 2 3
->6
* */