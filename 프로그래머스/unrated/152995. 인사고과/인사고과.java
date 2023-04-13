import java.util.*;
import java.io.*;
class score implements Comparable<score>{
    int a;
    int b;
    int sum;
    public score(int a,int b){
        this.a=a;
        this.b=b;
        this.sum=a+b;
    }
    @Override
    public int compareTo(score o){
        return o.sum-this.sum;
    }
    @Override
    public String toString(){
        return a+" "+b+" "+sum;
    }
}
class Solution {
    
    static ArrayList<score> list;
    public int solution(int[][] scores) {
        int answer = 1;
        score wonho=new score(scores[0][0],scores[0][1]);
        list=new ArrayList<>();
        
        for(int i=1;i<scores.length;i++){
            list.add(new score(scores[i][0],scores[i][1]));
        }
        int tmp=0;
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            score nowScore=list.get(i);
            if(nowScore.a>wonho.a && nowScore.b>wonho.b){
                answer=-1;
                break;
            }
            if(nowScore.sum<wonho.sum){
                break;
            }
            int flag=0;
            for(int j=0;j<i;j++){
                score comp=list.get(j);
                if(comp.a>nowScore.a && comp.b>nowScore.b){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                if(nowScore.sum==wonho.sum){
                    break;
                }
                answer++;
            }
        }
        return answer;
    }
}