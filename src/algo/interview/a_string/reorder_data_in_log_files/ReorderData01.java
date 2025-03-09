package algo.interview.a_string.reorder_data_in_log_files;

import java.util.*;
public class ReorderData01 {

    public static void main(String[] args) {

        List<String> logs = List.of("id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero");

        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digitList.add(log);
            } else {
                letterList.add(log);
            }
        }

        // 문자로그부터 정렬
        // 조건1 - 사전순
        // 조건2 - 문자가 동일할 경우, 식별자순
        Collections.sort(letterList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] s1x = s1.split(" ", 2);
                String[] s2x = s2.split(" ", 2);
                /**
                 * [1] 두 값이 동일하다면 0
                 * [2] 비교 대상의 순서가 앞으로 와야 하는 경우 1
                 * [3] 비교 대상의 순서가 뒤에 머물러야 할 경우 -1
                 */
                int compared = s1x[1].compareTo(s2x[1]);
                if (compared == 0) {
                    return s1x[0].compareTo(s2x[0]);
                } else {
                    return compared;
                }
            }
        });

        System.out.println(letterList);
    }
}


/**
 * String[] s1x = s1.split(" ", 2);
 * String[] s2x = s2.split(" ", 2);
 *
 * - 공백 " "을 기준으로 문자열을 나눈다.
 * - 2는 최대 분할 개수를 의미한다. 즉, 최대 두 개의 요소를 가진 배열을 반환한다.
 * - 첫 번째 공백을 기준으로 나누고, 그 이후의 문자열은 그대로 남는다.
 * - 예시 :
 *          String s1 = "abc def ghi";
 *          String s2 = "xyz uvw";
 *          String[] s1x = s1.split(" ", 2); // ["abc", "def ghi"]
 *          String[] s2x = s2.split(" ", 2); // ["xyz", "uvw"]
 */
