import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K; //행, 열
    static HashMap<String,Integer> map=new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            String input=bf.readLine();
            if(map.containsKey(input)){
                map.put(input,map.get(input)+1);
            }
            else{
                map.put(input,1);
            }
        }
        K=Integer.parseInt(bf.readLine());
        int answer=0;
        for(String key:map.keySet()){
            int cnt=0;
            for(int i=0;i<M;i++){
                if(key.charAt(i)=='0'){
                    cnt++;
                }
            }
            if(cnt<=K){
                if(cnt%2==K%2){
                    answer=Math.max(answer,map.get(key));
                }
            }

        }

        System.out.println(answer);


    }
}