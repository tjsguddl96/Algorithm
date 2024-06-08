import java.util.*;
class Solution {
    static int[] res;
    static int maxMoney;
    static int maxCnt;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        int n=users.length;
        int e=emoticons.length;
        res=new int[e];
        permutation(0,emoticons,users);
        answer=new int[2];
        answer[0]=maxCnt;
        answer[1]=maxMoney;
        return answer;
    }
    public static void permutation(int cnt,int[] emoticons,int[][] users){
        if(cnt==emoticons.length){
            int people=0;
            int allMoney=0;
            for(int i=0;i<users.length;i++){
                int sale=users[i][0];
                int money=users[i][1];
                int moneyCount1=0; //사는 비용
                for(int j=0;j<emoticons.length;j++){
                    int tmp=res[j]*10;
                    if(tmp>=sale){
                        moneyCount1+=(emoticons[j]*(100-tmp)*0.01);
                    }
                }
                if(moneyCount1>=money){
                    people++;
                    moneyCount1=0;
                }
                allMoney+=moneyCount1;
            }
            if(people>maxCnt){
                maxCnt=people;
                maxMoney=allMoney;
            }
            else if(people==maxCnt){
                if(allMoney>maxMoney){
                    maxMoney=allMoney;
                }
            }
            return ;
        }
        for(int i=1;i<=4;i++){
            res[cnt]=i;
            permutation(cnt+1,emoticons,users);
        }
    }
}