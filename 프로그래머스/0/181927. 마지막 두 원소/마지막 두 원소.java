class Solution {
    public int[] solution(int[] num_list) {
        int size=num_list.length;
        int[] answer = new int[size+1];
        for(int i=0;i<size;i++){
            answer[i]=num_list[i];
        }
        
        int a=num_list[size-1];
        int b=num_list[size-2];
        if(a>b){
            answer[size]=a-b;
        }
        else{
            answer[size]=2*a;
        }
        return answer;
    }
}