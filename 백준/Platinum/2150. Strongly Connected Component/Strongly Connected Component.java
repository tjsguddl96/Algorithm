import java.util.*;
import java.io.*;
public class Main {
    static int V,E;
    static ArrayList<Integer>[] arr;
    static int id=1;
    static int[] ids; //각 노드의 고유 번호 -> idx[i]==0이면 아직 방문하지 않았다.
    static int[] ch; //DFS를 처리했는지
    static Stack<Integer> stack=new Stack<>();
    static int cnt;
    static ArrayList<ArrayList<Integer>> scc=new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st=new StringTokenizer(bf.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        arr=new ArrayList[V+1];
        ids=new int[V+1];
        ch=new int[V+1];
        for(int i=1;i<V+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<E;i++){
            st=new StringTokenizer(bf.readLine());
            int n1=Integer.parseInt(st.nextToken());
            int n2=Integer.parseInt(st.nextToken());
            arr[n1].add(n2);
        }
        for(int i=1;i<V+1;i++){
            if(ids[i]==0){
                scc(i);
            }
        }
        ArrayList<Integer>[] ans=new ArrayList[V+1];
        for(int i=1;i<V+1;i++){
            ans[i]=new ArrayList<>();
        }
        for(int i=0;i<scc.size();i++){
            int min=scc.get(i).get(0);
            ans[min]=scc.get(i);
        }
        for(int i=1;i<V+1;i++){
            if(ans[i].size()==0){
                continue;
            }
            for(int j=0;j<ans[i].size();j++){
                answer.append(ans[i].get(j)+" ");
            }
            answer.append("-1\n");
        }
        System.out.println(cnt);
        bw.flush();
        bw.write(answer.toString());
        bw.close();


    }
    public static int scc(int nowNode){
        ids[nowNode]=id;
        id++;
        stack.add(nowNode);
        int nowParent=ids[nowNode];

        for(int i=0;i<arr[nowNode].size();i++){
            int nextNode=arr[nowNode].get(i);
            if(ids[nextNode]==0){ //해당 노드를 방문한 적이 없는 경우
                nowParent=Math.min(nowParent,scc(nextNode)); //더 작은 값으로 부모값을 갖게.
            }
            else if(ch[nextNode]==0){ //방문은 된 상태이지만, 처리 중인 노드 (현재 DFS를 수행하고 있는 노드) 즉 어떠한 SCC에도 들어가 있지 않는 경우
                nowParent=Math.min(nowParent,ids[nextNode]); //처리되고 있는 값과 비교
            }
        }

        //부모 노드가 자기 자식인 경우 -> SCC 만들기
        if(nowParent==ids[nowNode]){
            ArrayList<Integer> tmp=new ArrayList<>();
            while(true){
                int t=stack.peek();
                tmp.add(stack.pop());
                ch[t]=1; //처리가 완료 되었다
                if(t==nowNode){
                    break;
                }
            }
            Collections.sort(tmp);
            scc.add(tmp);
            cnt++;
        }

        return nowParent; //자신의 부모 값을 반환
    }
}

/*
8 12
2 8
8 5
4 8
1 4
4 5
5 1
1 6
6 7
2 7
7 3
3 7
7 2


3 3
1 1
2 2
3 3
->
3
1 -1
2 -1
3 -1



13 17
1 2
2 3
3 1
9 6
6 8
8 5
5 7
7 6
10 5
1 5
5 13
13 4
4 3
11 13
13 12
12 11
10 11
->
3
1 2 3 4 5 6 7 8 11 12 13 -1
9 -1
10 -1


11 16
1 4
4 5
5 6
6 7
7 5
4 6
1 3
3 2
2 8
8 10
10 11
11 8
8 9
9 5
2 1
9 10

* */