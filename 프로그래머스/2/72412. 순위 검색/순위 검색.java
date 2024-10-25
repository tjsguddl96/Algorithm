import java.util.*;
class Solution {
    static HashMap<String,Integer> lang=new HashMap<>();
    static HashMap<String,Integer> work=new HashMap<>();
    static HashMap<String,Integer> day=new HashMap<>();
    static HashMap<String,Integer> food=new HashMap<>();
    static int[][][][][] mem=new int[4][3][3][3][100002];
    static int[][][][][] sum=new int[4][3][3][3][100002];
    static int[] res=new int[4];
    static int[] points;
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        init();
        for(int i=0;i<info.length;i++){
            String[] tmp=info[i].split(" ");
            int lan=lang.get(tmp[0]);
            int wor=work.get(tmp[1]);
            int da=day.get(tmp[2]);
            int foo=food.get(tmp[3]);
            int poin=Integer.parseInt(tmp[4]);
            // System.out.println(lan+" "+wor+" "+da+" "+foo+" "+poin+" "+mem[lan][wor][da][foo][poin+1]);
            mem[lan][wor][da][foo][poin+1]-=1;
            // System.out.println(lan+" "+wor+" "+da+" "+foo+" "+poin+" "+mem[lan][wor][da][foo][poin+1]);
            sum[lan][wor][da][foo][0]++;
            for(int j=1;j<5;j++){
                combination(0,j,0,lan,wor,da,foo,poin);
            }
            
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                for(int x=0;x<3;x++){
                    for(int y=0;y<3;y++){
                        for(int k=1;k<100002;k++){
                            sum[i][j][x][y][k]=sum[i][j][x][y][k-1]+mem[i][j][x][y][k];
                        }
                    }
                }
            }
        }
        
        for(int i=0;i<query.length;i++){
            String[] tmp=query[i].split(" ");
            int lan=lang.get(tmp[0]);
            int wor=work.get(tmp[2]);
            int da=day.get(tmp[4]);
            int foo=food.get(tmp[6]);
            int point=Integer.parseInt(tmp[7]);
            answer[i]=sum[lan][wor][da][foo][point];
        }
        
        
        
        return answer;
    }
    public static void combination(int cnt,int n,int start,int lan,int wor,int da,int foo,int poin){
        if(cnt==n){
            for(int i=0;i<cnt;i++){
                // System.out.print(res[i]+" ");
                if(res[i]==0){
                    lan=3;
                }
                else if(res[i]==1){
                    wor=2;
                }
                else if(res[i]==2){
                    da=2;
                }
                else{
                    foo=2;
                }
            }
            // System.out.println();
            // System.out.println(lan+" "+wor+" "+da+" "+foo);
            mem[lan][wor][da][foo][poin+1]-=1;
            sum[lan][wor][da][foo][0]++;
            
            return ;
        }
        for(int i=start;i<4;i++){
            res[cnt]=i;
            combination(cnt+1,n,i+1,lan,wor,da,foo,poin);
        }
        
    }
    public static void init(){
        String[] langes={"java","cpp","python","-"};
        String[] works={"backend","frontend","-"};
        String[] days={"junior","senior","-"};
        String[] foods={"chicken","pizza","-"};
        for(int i=0;i<4;i++){
            lang.put(langes[i],i);
            if(i==3){
                continue;
            }
            work.put(works[i],i);
            day.put(days[i],i);
            food.put(foods[i],i);
        }
        
    }
}