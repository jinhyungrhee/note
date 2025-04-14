import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s = "Do geese see God?";

//        char c = s.charAt(13); // G
//        System.out.println(Character.toLowerCase(c));
//        System.out.println(Character.isLetterOrDigit(c));

        // two pointer
        int start = 0;
        int end = s.length() - 1;

        boolean result = false;

        while(start < end) {

            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            else { // 둘다 숫자거나 문자면 소문자로 변경해서 비교
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    result = false;
                }

                // 앞 포인터 이동
                start++;
                // 뒤 포인터 이동
                end--;
            }
        }

        // 무사히 종료되면
        result = true;


        System.out.println(result);
    }
}