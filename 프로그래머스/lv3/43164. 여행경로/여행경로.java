import java.util.*;
class ticket implements Comparable<ticket>{
    String st;
    String end;
    public ticket(String st, String end){
        this.st=st;
        this.end=end;
    }
    
    @Override
    public int compareTo(ticket o){
        int x=(this.st).compareTo(o.st);
        if(x==0){
            x=(this.end).compareTo(o.end);
        }
        return x;
    }
    @Override
    public String toString(){
        return this.st+" "+this.end;
    }
}

class Solution {
    ArrayList<ticket> t=new ArrayList<>();
    String[] answer;
    int n=0;
    int[] ch;
    boolean flag=false;
    public String[] solution(String[][] tickets) {
        n=tickets.length;
        answer=new String[n+1];
        ch=new int[n];
        for(int i=0;i<tickets.length;i++){
            ticket tmp=new ticket(tickets[i][0],tickets[i][1]);
            t.add(tmp);
        }
        Collections.sort(t);
        for(int i=0;i<n;i++){
            System.out.println(t.get(i).toString());
        }
        int idx=0;
        for(int i=0;i<n;i++){
            ticket tmp=t.get(i);
            if((tmp.st).equals("ICN")){
                ch[i]=1;
                answer[0]=tmp.st;
                DFS(i,0);
                if(flag==true){
                    break;
                }
                ch[i]=0;
            }
        }
        return answer;
    }
    public void DFS(int nowIdx,int cnt){
        ticket now=t.get(nowIdx);
        String nowSt=now.st;
        String nowEnd=now.end;
        if(cnt==n-1){
            answer[cnt+1]=nowEnd;
            flag=true;
            return ;
        }
        
        for(int i=0;i<n;i++){
            ticket next=t.get(i);
            String nextSt=next.st;
            String nextEnd=next.end;
            
            if(ch[i]==0 && nowEnd.equals(nextSt)){
                answer[cnt+1]=nextSt;
                ch[i]=1;
                cnt+=1;
                DFS(i,cnt);
                if(flag){
                    return ;
                }
                cnt-=1;
                ch[i]=0;
            }
        }
        
    }
}