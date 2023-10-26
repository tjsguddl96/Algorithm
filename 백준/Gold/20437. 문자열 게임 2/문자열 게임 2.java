import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int K;
    static int[][] answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        T=Integer.parseInt(bf.readLine());
        answer=new int[T][2];
        for(int t=0;t<T;t++) {
            String str = bf.readLine();
            K=Integer.parseInt(bf.readLine());
            if(K==1){
                answer[t][0]=1;
                answer[t][1]=1;
                continue;
            }
            int min = 999999999;
            int max=0;
            int right=0;
            HashMap<Character,ArrayDeque> map=new HashMap<>();

            while(right<str.length()){
                char nowC=str.charAt(right);
                if(!(map.containsKey(nowC))){
                    ArrayDeque<Integer> q=new ArrayDeque<>();
                    q.add(right);
                    map.put(nowC,q);
                }else{
                    ArrayDeque<Integer> q=map.get(nowC);
                    q.add(right);
                    map.put(nowC,q);
                    if(q.size()>=K){
                        int first=q.poll();
                        if((right-first)<min){
                            min=right-first;
                        }
                        if((right-first)>max){
                            max=right-first;
                        }
                    }
                }
                right++;
            }
            if(min==999999999){
                answer[t][0]=-1;
            }else{
                answer[t][0]=min+1;
                answer[t][1]=max+1;
            }
        }
        for(int i=0;i<T;i++){
            if(answer[i][0]==-1){
                System.out.println(answer[i][0]);
            }else{
                System.out.println(answer[i][0]+" "+answer[i][1]);
            }
        }

    }
}
/*
3
abcdabaabbb
3
abcdabaabbb
4
abcdabaabbb
1
->
3 8
6 9

* */