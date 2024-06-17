import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String[] input;
    static int[] ch;
    static char[] res;
    static ArrayList<String> ans=new ArrayList<>();
    static HashSet<String> set=new HashSet<>();
    static HashMap<Character,Integer> map=new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        for(int i=97;i<123;i++){
            map.put((char)i,i-97);
        }
        N=Integer.parseInt(bf.readLine());
        input=new String[N];
        for(int i=0;i<N;i++){
            input[i]=bf.readLine();
            set=new HashSet<>();
            char[] arr=new char[input[i].length()];
            for(int j=0;j<input[i].length();j++){
                arr[j]=input[i].charAt(j);
            }
            Arrays.sort(arr);
            ch=new int[input[i].length()];
            res=new char[input[i].length()];
            dfs(arr,0,"");
        }
        for(int i=0;i<ans.size();i++){
            answer.append(ans.get(i)+"\n");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
    public static void dfs(char[] input,int cnt,String str){
        set.add(str);
        if (cnt == input.length) {
            ans.add(str);
            return ;
        }
        for(int i=0;i<input.length;i++){
            int idx=map.get(input[i]);
            if(ch[i]==0 && !set.contains(str+input[i])){
                ch[i]=1;
                res[cnt]=input[i];
                dfs(input,cnt+1,str+input[i]);
                ch[i]=0;
            }
        }

    }
}