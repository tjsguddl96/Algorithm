import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Long>> num;
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(bf.readLine());
        ArrayList<Long> tmp=new ArrayList<>();
        for(long i=-1;i<10;i++){
            tmp.add(i);
        }
        num=new ArrayList<>();
        num.add(tmp);
        int idx=1;
        int n=num.get(0).size()-1;
        long answer=0L; // 답이 없을 경우 -1로 초기화
        if(N<=n){
            answer=num.get(0).get(N);
        }
        else {
            try {
                while (n <= N) {
                    tmp = new ArrayList<>();
                    for (int i = 1; i < 10; i++) {
                        for (int j = 0; j < num.get(idx - 1).size(); j++) {
                            if(idx==1 && j==0){
                                continue;
                            }
                            long t = num.get(idx - 1).get(j);
                            String m = Long.toString(t);
                            char c = m.charAt(0);
                            t = c - '0';
                            if (i > t) {
                                String a = i + m;
                                try {
                                    answer = Long.parseLong(a);
                                } catch (NumberFormatException e) {
                                    answer = -1; // 혹은 다른 적절한 처리
                                    break;
                                }
                                if(answer>9876543210L){
                                    answer=-1;
                                    break;
                                }
                                tmp.add(Long.parseLong(a));
                                n++;
                                if (n == N || answer==-1L) {
                                    break;
                                }
                            }
                        }
                        if (n == N || answer==-1L) {
                            break;
                        }
                    }
                    num.add(tmp);
                    if (n == N || answer==-1L) {
                        break;
                    }
                    if (tmp.isEmpty()) {
                        answer = -1; // 메모리 초과
                        break;
                    }
                    idx++;
                }
            } catch(Exception e){
                answer=-1;
            }
        }
        System.out.println(answer);
    }
}