import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int X,Y;
    static Stack<Integer> stack=new Stack<>();
    static int[] parent;
    static int[] ch1;
    static int[] ch2;
    static int nodeX;
    static int nodeY;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        parent=new int[N+1];
        arr=new int[N+1][2];
        ch1=new int[N+1];
        ch2=new int[N+1];
        String str=bf.readLine();
        int nowNode=1;
        StringTokenizer st=new StringTokenizer(bf.readLine());
        X=Integer.parseInt(st.nextToken());
        Y=Integer.parseInt(st.nextToken());
        for(int i=1;i<str.length()+1;i++){
            int now=str.charAt(i-1)-'0';
            if(stack.isEmpty()){
                stack.add(nowNode);
                arr[nowNode][0]=i;
                if(i==X){
                    nodeX=nowNode;
                }
                if(i==Y){
                    nodeY=nowNode;
                }
                nowNode++;
            }
            else if(now==0){
                parent[nowNode]=stack.peek();
                stack.add(nowNode);
                arr[nowNode][0]=i;
                if(i==X){
                    nodeX=nowNode;
                }
                if(i==Y){
                    nodeY=nowNode;
                }
                nowNode++;

            }
            else{
                int node=stack.pop();
                arr[node][1]=i;
                if(i==X){
                    nodeX=node;
                }
                if(i==Y){
                    nodeY=node;
                }
            }
        }
        if(nodeX==nodeY){
            System.out.println(arr[nodeX][0] + " " + arr[nodeX][1]);
        }
        else {
            while (nodeX != 0) {
                ch1[nodeX] = 1;
                nodeX = parent[nodeX];
            }
            int node = 0;
            while (nodeY != 0) {
                if (ch1[nodeY] == 1) {
                    node = nodeY;
                    break;
                }
                ch2[nodeY] = 1;
                nodeY = parent[nodeY];
            }
            System.out.println(arr[node][0] + " " + arr[node][1]);
        }

    }
}
/*
5
0001011011
1 10
* */