    package baekjoon.implementations.bronze.mario;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = 0;
            for (int i = 0; i < 10; i++) {
                int tmp = Integer.parseInt(br.readLine());
                if (Math.abs(num + tmp - 100) <= 100 - num) {
                    num += tmp;
                }else{
                    break;
                }
            }
            System.out.println(num);
        }
    }
