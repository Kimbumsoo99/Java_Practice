import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String str1 = "Hello";
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list.isEmpty());
        System.out.println(str1.startsWith("h"));
        System.out.println(Long.BYTES+ " --> " + Long.SIZE + " --> " + Long.MAX_VALUE); //바이트 크기, 비트 크기, 최대 값(최소값은 MIN)
        String answer = "";
        for(int i = 65;i<91;i++) answer += String.valueOf((char)i);
        System.out.println(answer.toLowerCase());
        System.out.println(answer);

    }
}