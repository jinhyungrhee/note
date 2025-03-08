package algo.interview.a_string.valid_palindrome;

public class ValidPalindrome01 {

    public static void main(String[] args) {

//        String s = "Do geese see God?";
        String s = "다들 잠들다";

        Boolean result = isPalindrome(s);
        System.out.println(result);

    }

    private static Boolean isPalindrome(String s) {

        // two pointers
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {

            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
            }

            // move pointers one step forward and backward
            start++;
            end--;

        }

        return true;
    }

}
