import java.util.*;
class Solution {
    static ArrayDeque<Integer> q=new ArrayDeque<>();
    static ArrayList<Integer> a=new ArrayList<>();
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(B);
        
        for(int i=0;i<B.length;i++){
            q.add(B[i]);
            a.add(A[i]);
        }
        
        Collections.sort(a,Collections.reverseOrder());
        
        for(int i=0;i<a.size();i++){
            if(a.get(i)>=q.peekLast()){
                q.poll();
            }
            else{
                q.pollLast();
                answer++;
            }
        }
        
        
        
        return answer;
    }
}