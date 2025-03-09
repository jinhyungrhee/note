package algo.interview.a_string.most_common_word;

import java.util.*;
public class MostCommonWord01 {

    public static void main(String[] args) {

        String p = "Ross hit a ball, the hit BALL flew far away after it was hit."; // 단일 maxVal
//        String p = "Ross hit the ball, the hit BALL flew far away after it was hit."; // 중복 maxVal
        String[] banned = {"hit"};

        String result = mostCommonWord(p, banned);
        System.out.println(result);

    }

    private static String mostCommonWord(String p, String[] banned) {
        // 1. 정규식으로 분리
        String[] words = p.replaceAll("\\W+", " ").toLowerCase().split(" ");

        // 2. banned 단어 제외하고 개수 count
        // 'Set 자료구조'도 비교 메서드(contains()) 제공
        // -> Set<String> ban = new HashSet<>(Arrays.asList(banned));

        HashMap<String, Integer> counts = new HashMap<>();
        List<String> ban = Arrays.asList(banned);
        for(String w : words) {
            if (!ban.contains(w)) {
                counts.put(w, counts.getOrDefault(w, 0) + 1);
            }
        }

        System.out.println(counts.entrySet());

        // 3. mostCommonWord 찾기
        String mostCommonWord = Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();

        /**
        // cf) 만약 maxValue 가 두 개일 경우 둘다 출력하는 방법은?
        // 1) maxValue 찾기
        // 2) 선형 탐색하면서 maxValue와 동일한 key값 찾기

        int maxValue = Collections.max(counts.values());
        List<String> mostCommonWords = counts.entrySet().stream()
                                        .filter(entry -> entry.getValue() == maxValue)
                                        .map(Map.Entry::getKey)
                                        .toList();
        System.out.println(mostCommonWords);
         *
         */

        return mostCommonWord;
    }

}
