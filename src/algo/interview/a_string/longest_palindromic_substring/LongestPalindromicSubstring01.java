package algo.interview.a_string.longest_palindromic_substring;

public class LongestPalindromicSubstring01 {

    public static int LEFT, MAX_LEN;

    public static void main(String[] args) {

        String target = "adcbabcdd";
        String result = findLongestPalindromicSubstring(target);
        System.out.println(result);

    }

    private static String findLongestPalindromicSubstring(String s) {

        // 길이가 1인 경우 예외 처리
        int len = s.length();
        if (len < 2) return s;

        // * 우측으로 한 칸씩 이동하며 짝수(2칸), 홀수(3칸) 2개의 투포인터로 조사 *
        for(int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i + 1); // 2칸짜리 투포인터 (짝수)
            extendPalindrome(s, i, i + 2); // 3칸짜리 투포인터 (홀수)
        }

        return s.substring(LEFT, LEFT + MAX_LEN);
    }

    private static void extendPalindrome(String s, int start, int end) {
        // 1 - (1)투 포인터가 유효한 범위 내에 있고, (2)양쪽 끝 문자가 일치하는 팰린드롬인 경우 -> '범위 확장'
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        // 2- 기존 최대 길이보다 큰 경우, 값 교체
        if (MAX_LEN < end - start - 1) {
            LEFT = start + 1; // while 탈출조건(s.charAt(start) == s.charAt(end)):직전까지 다녀온 start를 다시 원상 복구시켜야 함!
            MAX_LEN = end - start - 1;
        }

    }

}
