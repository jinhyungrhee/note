package algo.interview.a_string.group_anagrams;

import java.util.*;
public class GroupAnagrams01 {
    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "ant", "cat"};
        List<List<String>> result = groupAnagrams(words);
        System.out.println(result);

    }

    private static List<List<String>> groupAnagrams(String[] words) {


        Map<String, List<String>> result = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();

            // 1.문자열 정렬
            Arrays.sort(chars);
            //System.out.println(chars);

            // 2.정렬된 문자를 맵의 key로 사용
            String key = String.valueOf(chars);
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(word);
        }
        //System.out.println(result);

        List<List<String>> answer = new ArrayList<>(result.values());
        //System.out.println(answer);
        return answer;
    }
}
