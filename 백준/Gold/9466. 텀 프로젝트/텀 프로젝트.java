import java.io.*;
import java.util.*;
public class Main {
    static int T,s;
    static int[] pick;
    static int[] incoming;
    static ArrayList<Integer>[] arr;
    static ArrayDeque<Integer> q;
    static int ans;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer=new StringBuilder();
        StringTokenizer st;
        T=Integer.parseInt(bf.readLine());
        for(int t=0;t<T;t++) {
            s = Integer.parseInt(bf.readLine());
            ans = 0;
            pick = new int[s + 1];
            incoming = new int[s + 1];
            arr = new ArrayList[s + 1];
            q = new ArrayDeque<>();
            for (int i = 1; i < s + 1; i++) {
                arr[i] = new ArrayList<>();
            }
            st = new StringTokenizer(bf.readLine());
            for (int i = 1; i < s + 1; i++) {
                //i->pick[i]
                pick[i] = Integer.parseInt(st.nextToken());
                arr[i].add(pick[i]);
                incoming[pick[i]]++;
            }
            for (int i = 1; i < s + 1; i++) {
                if (incoming[i] == 0) {
                    q.add(i);
                }
            }
            while (!q.isEmpty()) {
                int now = q.poll();
                for (int i = 0; i < arr[now].size(); i++) {
                    int next = arr[now].get(i);
                    incoming[next]--;
                    if (incoming[next] == 0) {
                        q.add(next);
                    }
                }
            }
            for (int i = 1; i < s + 1; i++) {
                if (incoming[i] != 0) {
                    ans++;
                }
            }
            answer.append((s-ans) + "\n");
        }
        bw.flush();
        bw.write(answer.toString());
        bw.close();
    }
}