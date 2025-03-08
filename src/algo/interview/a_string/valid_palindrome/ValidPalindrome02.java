package algo.interview.a_string.valid_palindrome;

public class ValidPalindrome02 {

    public static void main(String[] args) {

//        String s = "Do geese see God?";
        String s = "다들 잠들다";

        Boolean result = isPalindrome02(s);
        System.out.println(result);

    }

    private static Boolean isPalindrome02(String s) {
        // 영문 + 숫자
        // String lowerCaseString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // 영문 + 숫자 + 한글
        String lowerCaseString = s.replaceAll("[^A-Za-z0-9\\uAC00-\\uD7A3]", "").toLowerCase();
        System.out.println(lowerCaseString);
        String reversedString = new StringBuilder(lowerCaseString).reverse().toString();
        System.out.println(reversedString);
        return reversedString.equals(lowerCaseString);
    }
}
