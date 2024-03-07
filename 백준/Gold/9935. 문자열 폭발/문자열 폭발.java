import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(bf.readLine()); // 입력 문자열을 StringBuilder로 읽기

        String bomb = bf.readLine();
        StringBuilder result = new StringBuilder(); // 결과를 저장할 StringBuilder

        int bombLength = bomb.length();
        int inputLength = input.length();

        // 문자열을 순회하면서 폭발 문자열을 찾고, 폭발 문자열을 제거
        for (int i = 0; i < inputLength; i++) {
            result.append(input.charAt(i)); // 현재 문자를 결과에 추가

            int resultLength = result.length();
            // 폭발 문자열이 발견되면 제거
            if (resultLength >= bombLength && isBomb(result, bomb, resultLength, bombLength)) {
                result.setLength(resultLength - bombLength); // 폭발 문자열 제거
            }
        }

        if (result.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(result.toString());
        }
    }

    // 폭발 문자열이 있는지 확인하는 함수
    private static boolean isBomb(StringBuilder result, String bomb, int resultLength, int bombLength) {
        // 마지막 문자열에서 폭발 문자열이 있는지 확인
        for (int i = 0; i < bombLength; i++) {
            if (result.charAt(resultLength - bombLength + i) != bomb.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}