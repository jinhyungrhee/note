package algo.interview.z_leetcode;

import java.util.*;
import java.util.stream.*;

public class TopKFrequentElements347 {

    public static void main(String[] args) {

        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        int[] result = topKFrequent(nums, k);
        for (int r : result) {
            System.out.println(r);
        }

    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        System.out.println(map); // {-1=2, 1=1, 2=2, 3=1, 4=1}

        Map<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldVal, newVal) -> oldVal,
                        LinkedHashMap::new
                ));

        List<Integer> list = sortedMap.keySet().stream().limit(k).toList();
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
