import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static class Str implements Comparable<Str>{
        int len;
        String str;
        public Str(int len,String str){
            this.len=len;
            this.str=str;
        }
        @Override
        public int compareTo(Str o){
            int x=0;
            x=this.str.compareTo(o.str);
            if(x==0){
                x=this.len-o.len;
            }
            return x;
        }
        @Override
        public String toString(){
            return this.str+" "+this.len;
        }
    }
    static PriorityQueue<Str> pq1=new PriorityQueue<>();
    static PriorityQueue<Str> pq=new PriorityQueue<>();
    static ArrayList<String>[] arr;
    static HashMap<String,Integer> map=new HashMap<>();
    static int answer;
    public static void main(String[] args) throws IOException{
         BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
         N=Integer.parseInt(bf.readLine());
         for(int i=0;i<N;i++){
             String str=bf.readLine();
             pq1.add(new Str(str.length(),str));
         }
        int idx=0;
        while(!pq1.isEmpty()){
            String str=pq1.poll().str;
            if(map.containsKey(str)){
                continue;
            }
            pq.add(new Str(str.length(),str));
            map.put(str,idx);
            idx++;
        }
//        for(String key:map.keySet()){
//            System.out.println(key+" "+map.get(key));
//        }
        arr=new ArrayList[idx];
        for(int i=0;i<idx;i++){
            arr[i]=new ArrayList<>();
        }
        while(!pq.isEmpty()){
            String now=pq.poll().str;
            while(!pq.isEmpty() && isEqual(now,pq.peek().str)){
                 find(now,pq.peek().str);
                 pq.poll();
             }
        }
         for(int i=0;i<idx;i++){
             if(arr[i].size()==0){
                 answer++;
             }
         }
        System.out.println(answer);
//         for(int i=0;i<N;i++){
//             System.out.print(i+" : ");
//             for(int j=0;j<arr[i].size();j++){
//                 System.out.print(arr[i].get(j));
//             }
//             System.out.println();
//         }
    }
    static public boolean isEqual(String prev,String next){
        for(int i=0;i<prev.length();i++){
            if(prev.charAt(i)!=next.charAt(i)){
                return false;
            }
        }
        return true;
    }
    static public void find(String now,String origin){
        int nowIdx=map.get(now);
        if(arr[nowIdx].size()==0){
            arr[nowIdx].add(origin);
            return ;
        }
        boolean flag=false;
        for(int i=0;i<arr[nowIdx].size();i++){
            String next=arr[nowIdx].get(i);
            if(isEqual(next,origin)){
                find(next,origin);
                flag=true;
            }
        }
        if(!flag) {
            arr[nowIdx].add(origin);
            return;
        }
    }
}
/*
8
hellow
ren
hello
hi
h
run
rerun
running


9
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaae
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaad
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaac
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
aaa
aaaa
aaa
aaa
->5

7
hello
hi
h
run
rerun
running
hello

* */