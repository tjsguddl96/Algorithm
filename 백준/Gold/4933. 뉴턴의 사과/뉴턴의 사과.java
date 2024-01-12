import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();

        int T=Integer.parseInt(bf.readLine());

        for(int t=0;t<T;t++) {
            String tree1 = bf.readLine();
            String tree2 = bf.readLine();
            HashMap<String, String> ans1 = makeRoot(tree1);

            HashMap<String, String> ans2 = makeRoot(tree2);
            String ans = "true";
            for (String key : ans1.keySet()) {
                String val1 = ans1.get(key);
                if(ans2.get(key)==null){
                    ans="false";
                    break;
                }
                String val2 = ans2.get(key);
                if (!val1.equals(val2)) {
                    ans = "false";
                    break;
                }
//                System.out.println(key+" "+val1);
            }
            for (String key : ans2.keySet()) {
                String val1 = ans2.get(key);
                if(ans1.get(key)==null){
                    ans="false";
                    break;
                }
                String val2 = ans1.get(key);
                if (!val1.equals(val2)) {
                    ans = "false";
                    break;
                }
//                System.out.println(key+" "+val1);
            }
            answer.append(ans+'\n');
        }
        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
    public static HashMap<String,String> makeRoot(String tree){
        StringTokenizer st=new StringTokenizer(tree);
        HashMap<String,String> ans=new HashMap<>();

        ArrayList<Integer> treeList=new ArrayList<>(); //-1이면 nil임
        HashMap<Integer,String> map=new HashMap<>();
        int idx=0;
        while(st.hasMoreTokens()){
            String now=st.nextToken();
            if(now.equals("end")){
                break;
            }
            else if(!now.equals("nil")){
                idx++;
                treeList.add(idx);
                map.put(idx,now);
            }
            else{
                treeList.add(-1);
            }
        }
        arr=new int[idx+1][3]; //0:parent, 1 :왼쪽 자식, 2 : 오른쪽 자식 // 0이면 비어 있는 거임
//        arr[해당노드][0]=-1 이면 해당 노드는 root임
        arr[idx][0]=-1;
        int parent=0;
        for(int i=treeList.size()-1;i>=0;i--){
            int nowNode=treeList.get(i);
            if(nowNode==-1){//nil인 경우
                //내 parent의 오른쪽이 비었으면 오른쪽으로
                if(arr[parent][2]==0){
                    arr[parent][2]=nowNode;
                }
                //내 parent의 오른쪽이 찼으면 왼쪽으로
                else if(arr[parent][1]==0){
                    arr[parent][1]=nowNode;
                }
                //내 parent의 오른쪽, 왼쪽이 모두 찼으면 내 parent의 parent로.
                else{
                    while(arr[parent][2]!=0 && arr[parent][1]!=0){
                        parent=arr[parent][0];
                    }
                    arr[parent][1]=nowNode;
                }
            }
            else{
                if(arr[nowNode][0]==-1){//루트인경우
                    parent=nowNode;
                }
                else{
                    //내 parent의 오른쪽이 비었으면 오른쪽으로
                    if(arr[parent][2]==0){
                        arr[nowNode][0]=parent;
                        arr[parent][2]=nowNode;
                        parent=nowNode;
                    }
                    //내 parent의 오른쪽이 찼으면 왼쪽으로
                    else if(arr[parent][1]==0){
                        arr[nowNode][0]=parent;
                        arr[parent][1]=nowNode;
                        parent=nowNode;
                    }
                    //내 parent의 오른쪽, 왼쪽이 모두 찼으면 내 parent의 parent로.
                    else{
                        while(arr[parent][2]!=0 && arr[parent][1]!=0){
                            parent=arr[parent][0];
                        }
                        arr[nowNode][0]=parent;
                        arr[parent][1]=nowNode;
                        parent=nowNode;
                    }
                }
            }
        }
        for(int i=1;i<idx+1;i++){
            String alpha=map.get(i);
            String parentAlpha="";
            if(arr[i][0]==-1){
                parentAlpha="end";
            }
            else{
                parentAlpha=map.get(arr[i][0]);
            }
            ans.put(alpha,parentAlpha);
        }

        return ans;
    }
}
/*
1
nil nil B nil A
nil nil B nil A

1
nil nil C nil B nil A
nil nil C nil B nil A

1
nil nil nil nil C B A
nil nil nil nil C B A

1
nil nil nil F nil E nil D nil nil C B A
nil nil nil F nil E nil D nil nil C B A

1
nil nil nil F nil E nil nil nil nil J nil nil K I H G D nil nil C B A end
nil nil nil F nil E nil nil nil nil J nil nil K I H G D nil nil C B A end
* */