import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int cnt;
    static HashMap<Character,Integer> map=new HashMap<>();
    static HashMap<Integer,Character> map2=new HashMap<>();
    static int[] res;
    static int[] ch;
    static String[] input;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        input=new String[N];
        for(int i=0;i<N;i++){
            input[i]=bf.readLine();
            for(int j=0;j<input[i].length();j++){
                char now=input[i].charAt(j);
                if(!map.containsKey(now)){
                    map.put(now,cnt);
                    map2.put(cnt,now);
                    cnt++;
                }
            }
        }
        ch=new int[10];
        res=new int[cnt];
        permu(0);
        System.out.println(answer);
    }
    public static void permu(int n){
        if(n==cnt){
            int sum=0;
            for(int i=0;i<N;i++){
                int tmp=1;
                for(int j=input[i].length()-1;j>=0;j--){
                    char now=input[i].charAt(j);
                    sum+=(tmp*res[map.get(now)]);
                    tmp*=10;
                }
            }
            answer=Math.max(answer,sum);
            return ;
        }
        for(int i=9;i>=(9-cnt+1);i--){
            if(ch[i]==0){
                ch[i]=1;
                res[n]=i;
                permu(n+1);
                ch[i]=0;
            }
        }
    }
}