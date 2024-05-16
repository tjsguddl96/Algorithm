import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String[] str;
    static String[] tmp;
    static HashMap<String,ArrayList<Integer>> map=new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        str=new String[N];
        tmp=new String[N];
        int maxLength=1;
        String answer1="";
        String answer2="";
        int minIdx=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            str[i]=bf.readLine();
            if(map.get(str[i].charAt(0)+"")==null){
                ArrayList<Integer> arr=new ArrayList<>();
                arr.add(i);
                map.put(str[i].charAt(0)+"",arr);
            }
            else{
                ArrayList<Integer> arr=map.get(str[i].charAt(0)+"");
                arr.add(i);
                if(minIdx>arr.get(0)){
                    answer1=str[arr.get(0)];
                    answer2=str[arr.get(1)];
                    minIdx=arr.get(0);
                }
                map.put(str[i].charAt(0)+"",arr);
            }
            tmp[i]=str[i].charAt(0)+"";
        }

        for(int i=2;i<100;i++){
            for(int j=0;j<N;j++){
                if(str[j].length()<i){
                    continue;
                }
                String t=tmp[j]+str[j].charAt(i-1);
                if(map.get(t)==null){
                    ArrayList<Integer> arr=new ArrayList<>();
                    arr.add(j);
                    map.put(t,arr);
                }
                else{
                    ArrayList<Integer> arr=map.get(t);
                    arr.add(j);
                    if(t.length()>maxLength){
                        maxLength=t.length();
                        answer1=str[arr.get(0)];
                        answer2=str[arr.get(1)];
                        minIdx=arr.get(0);
                    }
                    else if(t.length()==maxLength){
                        if(minIdx>arr.get(0)){
                            answer1=str[arr.get(0)];
                            answer2=str[arr.get(1)];
                            minIdx=arr.get(0);

                        }
                    }
                    map.put(t,arr);
                }
                tmp[j]=t;
            }
        }
        if(answer1.equals("") && answer2.equals("")){
            answer1=str[0];
            answer2=str[1];
        }
        System.out.println(answer1+"\n"+answer2);

    }
}
/*
11
noon
is
moon
lunch
ism
most
moone
noone
waits
until
two

13
noon
is
moon
lunch
ism
mostt
moone
noone
waits
until
two
mosttte
noonee



3
a
b
c

5
abab
abaa
abcdab
abcda
abcdaa

4
aa
bb
bc
aj
* */