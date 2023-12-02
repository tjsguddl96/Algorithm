import java.util.*;


class Solution {
    
    public long solution(int[] sequence) {
        long answer = 0;
        int size=sequence.length;    
        long [][] arr=new long[2][size+1]; //[0]은 1,-1,1,-1,.. 용
                                  //[1]은 -1,1,-1,1,.. 용
        if(size==1){
            answer=Math.max(sequence[0],sequence[0]*(-1));
            return answer;
        }
        arr[0][0]=0;
        arr[1][0]=0;
        arr[0][1]=sequence[0];
        arr[1][1]=(-1)*sequence[0];
        
        for(int i=0;i<2;i++){
            for(int j=2;j<size+1;j++){
                if(i==0){
                    if(j%2==1){
                        arr[i][j]=arr[i][j-1]+sequence[j-1];
                    }else{
                        arr[i][j]=arr[i][j-1]+((-1)*sequence[j-1]);
                    }
                }else{
                    if(j%2==1){
                        arr[i][j]=arr[i][j-1]+((-1)*sequence[j-1]);
                    }else{
                        arr[i][j]=arr[i][j-1]+sequence[j-1];
                    }
                }
            }
        }

        Arrays.sort(arr[0]);
        Arrays.sort(arr[1]);
        long max1=arr[0][size];
        long min1=arr[0][0];
        long max2=arr[1][size];
        long min2=arr[1][0];
        answer=Math.max((max1-min1),(max2-min2));
        
        
        
        return answer;
    }
}