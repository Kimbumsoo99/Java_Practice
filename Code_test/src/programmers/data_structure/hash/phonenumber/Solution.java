package programmers.data_structure.hash.phonenumber;
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        String tmp = "";
        Arrays.sort(phone_book);
        for(int i = 0;i < phone_book.length - 1;i++){
            for(int j = 0; j<phone_book[i].length(); j++){
                tmp += phone_book[i].charAt(j);
            }
            if(tmp.length() < phone_book[i+1].length())
                if(phone_book[i+1].substring(0, tmp.length()).equals(tmp))
                    answer = false;
            tmp = "";
        }
        return answer;
    }
}