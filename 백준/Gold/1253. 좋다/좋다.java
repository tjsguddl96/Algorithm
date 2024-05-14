import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[] input;
    static ArrayList<Integer> arr=new ArrayList<>();
    static HashMap<Integer,Integer> map=new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(bf.readLine());
        input=new int[N];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            input[i]=Integer.parseInt(st.nextToken());
            if(map.get(input[i])==null){
                map.put(input[i],1);
            }
            else{
                int tmp=map.get(input[i]);
                map.put(input[i],tmp+1);
            }
        }
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(input[i]==0 && input[j]==0 && map.get(0)>=3){
                    arr.add(input[i]+input[j]);
                }
                else if(input[i]==0&& input[j]!=0 && map.get(input[j])>=2){
                    arr.add(input[i]+input[j]);
                }
                else if(input[i]!=0 && input[j]==0 && map.get(input[i])>=2){
                    arr.add(input[i]+input[j]);
                }
                else if(input[i]!=0 && input[j]!=0){
                    arr.add(input[i]+input[j]);
                }
            }
        }
        Collections.sort(arr);
        int answer=0;
        for(int i=0;i<N;i++){
            int now=input[i];
            int left=0;
            int right=arr.size()-1;
            int mid=0;
            while(left<=right){
                mid=(left+right)/2;
                if(arr.get(mid)>now){
                    right=mid-1;
                }
                else if(arr.get(mid)==now){
                    answer++;
                    break;
                }
                else{
                    left=mid+1;
                }
            }
        }
        System.out.println(answer);
    }
}
/*
3
0 0 0
=>3

2
0 0
out : 0

3
0 3 3
out : 2

2
0 1
out : 0

3
0 0 0
out : 3

4
0 1 2 3
out : 1

3
0 -5 5
out : 1
* */