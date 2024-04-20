import java.io.*;
import java.util.*;

public class Main {
    static int N,d,k,c;
    static int[] sushi;
    static HashMap<Integer,Integer> eat=new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        sushi=new int[N];
        for(int i=0;i<N;i++){
            sushi[i]=Integer.parseInt(bf.readLine());
        }
        int left=0;
        int right=0;
        int max=0;
        while(left<N){
            if(right-left+1<=k){
                if(eat.containsKey(sushi[right%N])){
                    eat.put(sushi[right%N],eat.get(sushi[right%N])+1);
                }
                else{
                    eat.put(sushi[right%N],1);
                }
                right++;
            }
            else{
                eat.put(sushi[left],eat.get(sushi[left])-1);
                if(eat.get(sushi[left])==0){
                    eat.remove(sushi[left]);
                }
                left++;
            }
            if(eat.containsKey(c)){
                max=Math.max(max,eat.size());
            }
            else{
                max=Math.max(max,eat.size()+1);
            }

        }
        System.out.println(max);
    }
}