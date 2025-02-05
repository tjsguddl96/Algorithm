import java.io.*;
import java.util.*;

public class Main {
    static int N,K,cnt1;
    static ArrayList<Integer> list=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(a>=b){
                cnt1++;
            }
            else{
                list.add(b-a);
            }
        }
        if(cnt1>=K){
            System.out.println(0);
        }
        else{
            K-=cnt1;
            Collections.sort(list);
//            int left=0;
//            int right=list.size()-1;
//            int Mid=0;
//            while(left<=right){
//                int mid=(left+right)/2;
//
//            }
//            System.out.println(K);
            System.out.println(list.get(K-1));
        }


    }
}