package algo.interview.zz_concept.graph;

import java.util.*;
import java.util.stream.*;
public class Permutations {

    public static void main(String[] args) {

        int[] nums = {1, 2, 4};
        System.out.println(permute(nums));
        /**
         * [[1, 2, 4],
         * [1, 4, 2],
         * [2, 1, 4],
         * [2, 4, 1],
         * [4, 1, 2],
         * [4, 2, 1]]
         */

    }

    public static List<List<Integer>> permute(int[] nums) {

        // 결과 저장 리스트
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> lst = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // DFS
        dfs(results, new ArrayList<>(), lst);
        return results;
    }

    public static void dfs(List<List<Integer>> results, List<Integer> prevElements, List<Integer> elements) {
        // 리프노드에 도달하면 결과에 추가
        if (elements.isEmpty()) {
            // prevElements의 내용을 결과에 삽입
            results.add(prevElements.stream().collect(Collectors.toList()));
        }

        // 전달받은 엘리먼트 모두 탐색
        for (Integer e : elements) {
            // 전달받은 엘리먼틍서 현재 엘리먼트(e)를 제외하고 nextElements 새롭게 구성
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);
            // prevElements는 기존 값에 현재 엘리먼트(e) 추가
            prevElements.add(e);
            // DFS
            dfs(results, prevElements, nextElements);
            // [BackTracking] 돌아온 이후엔 prevElements에서 현재 엘리먼트(e) 삭제
            prevElements.remove(e);
        }
    }


}

/**
 * 순열(Permutations) : 서로 다른 n개중에 r개를 선택하는 경우의 수 (순서 상관 있음)
 * nPr = n! / (n-r)!
 * => '순열'이란 결국 모든 가능한 경우를 '그래프 형태'로 나열한 결과라고 할 수 있다.
 * => '리프노드'가 순열의 최종 결과임 (자식 노드의 개수가 점점 줄어들기 때문)
 *
 * 팩토리얼(Factorial,!) : 서로 다른 n개를 나열하는 경우의 수
 * n! = n * (n-1) * (n-2) * ... * 1
 *
 */