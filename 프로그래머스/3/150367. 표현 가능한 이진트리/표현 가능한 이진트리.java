import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<Integer>[] tree;
    static char[] travle;
    static int idx;
    public int[] solution(long[] numbers) {
        int[] answer = {};
        int a=(int)(Math.log(1)/Math.log(2));
        System.out.println(a);
        answer=new int[numbers.length];
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0){
                answer[i]=0;
                continue;
            }
            String binary=Long.toBinaryString(numbers[i]);
        
            int flag=1;
            int len=binary.length();
            int tmp=(int)(Math.log(len)/Math.log(2));
            int h=0;
            idx=0;
            if(len>=Math.pow(2,tmp)){
                h=tmp+1;
            }
            else{
                h=tmp;
            }
            
            int n=(int)(Math.pow(2,h))-1;
            int tmpN=n-len;
            String tmpStr="";
            for(int j=0;j<tmpN;j++){
                tmpStr+="0";
            }
            binary=tmpStr+binary;
            tree=new ArrayList[n];
            
            for(int j=0;j<n;j++){
                tree[j]=new ArrayList<>();
            }
            for(int j=0;j<=(n/2)-1;j++){
                tree[j].add(2*j+1);
                tree[j].add(2*j+2);
            }
            travle=new char[n];
            dfs(1,0,h,binary);
            for(int j=0;j<=(n/2)-1;j++){
                char parent=travle[j];
                char left=travle[2*j+1];
                char right=travle[2*j+2];
                if(parent=='0' && (left=='1' || right=='1')){
                    flag=0;
                    break;
                }
            }
            answer[i]=flag;
        }
        return answer;
    }
    public static void dfs(int depth,int nowNode,int h,String binary){
        if(idx>=binary.length()){
            return ;
        }
        if(depth==h){
            travle[nowNode]=binary.charAt(idx);
            idx++;
            return ;
        }
        if(tree[nowNode].size()!=0){
            dfs(depth+1,tree[nowNode].get(0),h,binary);
        }
        travle[nowNode]=binary.charAt(idx);
        idx++;
        if(tree[nowNode].size()!=0){
            dfs(depth+1,tree[nowNode].get(1),h,binary);
        }
    }
}
/*
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 128, 129, 16512, 2147516555]
[0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1]
*/
