import java.util.*;
class Solution {
    static HashSet<Integer>[] winFrom;
    static HashSet<Integer>[] loseFrom;
    public int solution(int n, int[][] results) {
        int answer = 0;
        winFrom=new HashSet[n+1];
        loseFrom=new HashSet[n+1];
        for(int i=1;i<n+1;i++){
            winFrom[i]=new HashSet<>();
            loseFrom[i]=new HashSet<>();
        }
        for(int i=0;i<results.length;i++){
            int n1=results[i][0];
            int n2=results[i][1];
            winFrom[n1].add(n2);
            loseFrom[n2].add(n1);
        }
        for(int i=1;i<n+1;i++){
            HashSet<Integer> tmp=new HashSet<>();
            for(int val:winFrom[i]){
                tmp.add(val);
            }
            for(int val:winFrom[i]){ //val은 i에게 진 애들
                for(int val2:winFrom[val]){ //val2는 val에게 진 애들 => val2도 i에게 짐
                    
                    tmp.add(val2);
                }
            }
            HashSet<Integer> tmp2=new HashSet<>();
            for(int val:loseFrom[i]){
                tmp2.add(val);
            }
            for(int val:loseFrom[i]){ //val은 i를 이긴 애들
                // System.out.println(val+"@@");
                for(int val2:loseFrom[val]){ //val2는 val을 이긴 애들 -> val2는 i를 이김
                    // System.out.println(val2+"!");
                    tmp2.add(val2);
                }
            }
            winFrom[i]=tmp; //i는 tmp에 있는 애들을 다 이겼어
            loseFrom[i]=tmp2; //i는 tmp2에 있는 애들에게 다 졌어 
            for(int val:winFrom[i]){ //val은 i에게 졌어
                loseFrom[val].add(i);
            }
            for(int val:loseFrom[i]){
                winFrom[val].add(i);
            }
            
            // for(int val:winFrom[i]){
            //     System.out.print(val+" ");    
            // }
            // System.out.println();
            // for(int val:loseFrom[i]){
            //     System.out.print(val+" ");    
            // }
            // System.out.println("\n-----");
        }
        
        for(int i=1;i<n+1;i++){
            if(winFrom[i].size()+loseFrom[i].size()==n-1){
                answer++;
            }
        }
        return answer;
    }
}