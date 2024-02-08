package swea.d4.n1233;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 1;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                if (st.countTokens() == 2) {
                    st.nextToken();
                    char op = st.nextToken().charAt(0);
                    if (!(isNum(op))) {
                        answer = 0;
                    }
                }
            }
            System.out.println("#" + (i + 1) + " " + answer);
        }
    }

    static boolean isNum(char op) {
        if (op >= '0' && op <= '9') {
            return true;
        }
        return false;
    }
}
