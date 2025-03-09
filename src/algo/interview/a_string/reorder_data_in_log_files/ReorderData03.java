package algo.interview.a_string.reorder_data_in_log_files;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReorderData03 {

    public static void main(String[] args) {

        List<String> logs = List.of("id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero");

        String[] reorderLogs = reorderLogFiles(logs);
        for (String log : reorderLogs) {
            System.out.println(log);
        }
    }

    private static String[] reorderLogFiles(List<String> logs) {
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

        // * Collections를 지정하지 않고, letterList의 메서드를 직접 호출하는 형태 *
        letterList.sort((s1, s2) -> {
            // 1. '식별자', '그 외 부분' 두 부분으로 split
            String[] s1x = s1.split(" ", 2);
            String[] s2x = s2.split(" ", 2);

            // [1] 두 값이 동일하다면 0
            // [2] 비교 대상의 순서가 앞으로 와야 하는 경우 1
            // [3] 비교 대상의 순서가 뒤에 머물러야 할 경우 -1

            // 2. 문자 로그 사전순 비교
            int compared = s1x[1].compareTo(s2x[1]);
            // 3. 문자가 동일한 경우, 식별자 비교
            if (compared == 0) {
                return s1x[0].compareTo(s2x[0]);
            } else {
                // 4. 비교 대상의 순서가 동일한 경우 0, 순서가 앞인 경우 1, 순서가 뒤인 경우 -1 리턴
                return compared;
            }
        });

        // 문자 리스트 뒤에 숫자 리스트 이어 붙이기
        letterList.addAll(digitList);

        // 리스트를 스트링 배열로 변환
        return letterList.toArray(new String[0]);
    }
}

/**
 * letterList.toArray(new String[0]);
 * - 리스트를 문자열 배열(String[])로 변환
 * - toArray(T[] a) : 리스트의 요소를 배열로 복사하는 메서드 **
 * - toArray[new String[0]) : 리스트 크기에 맞는 새 배열을 생성하고 요소를 복사 ***
 *      - new String[0] : 단지 타입을 맞추기 위한 더미 배열
 *      - toArray() : 알아서 적절한 크기의 배열을 생성해서 반환
 *      - 내부 동작 과정 ***
 *          1. toArray()는 '리스트 크기(letterList.size())'와 'new String[0]'의 크기를 비교함
 *          2. letterList.size()가 0보다 크므로, '리스트 크기'에 맞는 새 배열 생성
 *          3. 리스트 내용을 새 배열에 복사
 *          4. 배열을 반환
 * - 'new String[letterList.size()]' 대신 'new String[0]'을 쓰는 이유 ***
 *      - new String[0] :
 *          - 좀 더 효율적이고 모던한 자바 스타일
 *          - 내부적으로 size()를 확인 후, 적절한 크기의 배열 생성
 *          - 최신 JVM(자바7 이후)에서 최적화된 방식 ***
 *      - new String[letterList.size()] :
 *         - 배열 크기를 미리 지정해서 전달
 *         - 성능상 큰 차이는 없지만, 불필요한 배열 객체 생성
 */

