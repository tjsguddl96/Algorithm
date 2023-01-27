class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int gap=0;
        for(int i=0;i<common.length-1;i++){
            if (i==0){
                gap=common[i+1]-common[i];
            }
            else{
                if(gap==(common[i+1]-common[i])){ //등차
                    return common[common.length-1]+gap;
                }
                else{
                    gap=common[i+1]/common[i];
                    return common[common.length-1]*gap;
                }
            }
        }
        return answer;
    }
}