import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static ArrayList<Integer> arr=new ArrayList<>();
    static class Freq implements Comparable<Freq>{
        int num;
        int cnt;
        public Freq(int num,int cnt){
            this.num=num;
            this.cnt=cnt;
        }
        @Override
        public int compareTo(Freq o){
            int x=o.cnt-this.cnt;
            if(x==0){
                x=this.num-o.num;
            }
            return x;
        }
    }
    static ArrayList<Integer> list=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        N=Integer.parseInt(bf.readLine());
        TreeMap<Integer,Integer> map=new TreeMap<>();
        HashSet<Integer> set=new HashSet<>();
        int maxNum=0;
        int maxCnt=0;
        long sum=0;
        for(int i=0;i<N;i++){
            int now=Integer.parseInt(bf.readLine());
            arr.add(now);
            if(map.containsKey(now)){
                map.put(now,map.get(now)+1);
            }
            else{
                map.put(now,1);
            }
            if(maxCnt<map.get(now)){
                maxCnt=map.get(now);
                set=new HashSet<>();
                set.add(now);
            }
            else if(maxCnt==map.get(now)){
                set.add(now);
            }

            sum+=now;
        }
        Collections.sort(arr);
        for(int val:set){
            list.add(val);
        }
        Collections.sort(list);

        answer.append(Math.round((double)sum/N)+"\n");
        answer.append(arr.get(N/2)+"\n");
        if(list.size()>1){
            answer.append(list.get(1)+"\n");
        }
        else{
            answer.append(list.get(0)+"\n");
        }
        answer.append(arr.get(arr.size()-1)-arr.get(0));
        bw.flush();
        bw.write(answer.toString());
        bw.close();




    }

}

/*
7
10
9
8
2
10
2
1
->



*/
