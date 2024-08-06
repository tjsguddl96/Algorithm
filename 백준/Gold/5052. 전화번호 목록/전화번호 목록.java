import java.util.*;
import java.io.*;
public class Main {
    static int T,N;
    static ArrayList<Str> arr;
    static class Str implements Comparable<Str>{
        String str;
        public Str(String str){
            this.str=str;
        }
        @Override
        public int compareTo(Str o){
            int x=this.str.length()-o.str.length();
            if(x==0){
                x=str.compareTo(o.str);
            }
            return x;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++){
            String ans="YES";
            N=Integer.parseInt(bf.readLine());
            arr=new ArrayList<>();
            int maxLength=0;
            for(int i=0;i<N;i++){
                String str=bf.readLine();
                arr.add(new Str(str));
                maxLength=Math.max(str.length(),maxLength);
            }
            Collections.sort(arr);

            ArrayList<String> tmp=new ArrayList<>();
            HashSet<String> set=new HashSet<>();
            for(int i=0;i<N;i++){
                tmp.add("");
            }
            for(int i=0;i<maxLength;i++){
                for(int j=0;j<N;j++){
                    String nowStr=arr.get(j).str;
                    if(i<nowStr.length()){
                       char nowChar=nowStr.charAt(i);
                       String next=tmp.get(j)+nowChar;
                       if(next.equals(nowStr)){
                           set.add(nowStr);
                           continue;
                       }
                       if(set.contains(next)){
                           ans="NO";
                           break;
                       }
                       tmp.set(j,next);
                    }
                }
                if(ans.equals("NO")){
                    break;
                }
            }
            answer.append(ans+"\n");

        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
}
/*
1
8
113
11440
12340
123440
12345
123
98346
1234

1
5
100
1
1234
23
3
* */