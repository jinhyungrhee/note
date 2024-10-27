package algo.prgmrs.highscore.hash;

/**
 * 프로그래머스 > 고득점 kit > 해시 > 포켓몬
 * 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */

import java.util.*;
import java.util.stream.Collectors;

public class Pokemon {
    public static void main(String[] args) {
        /**
         * input
         */
//        int[] nums = { 3,1,2,3 };
//        int[] nums = { 3,3,3,2,2,4 };
        int[] nums = { 3,3,3,2,2,2 };

        System.out.println("MY_SOLUTION : " + mySolution(nums));
        System.out.println("REFACTORING : " + refactoredSolution(nums));

    }

    public static int mySolution(int[] nums) {

        Set<Integer> numSet = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        int targetSize = nums.length / 2;
        int setSize = numSet.size();

        if (targetSize < setSize) {
            return targetSize;
        }
        return setSize;

    }

    public static int refactoredSolution(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen(
                        Collectors.toSet(),
                        pokemons -> Integer.min(pokemons.size(), nums.length / 2))
                );
    }

    // boxed() : int stream을 래퍼 클래스 Integer stream으로 변환 (-> 컬렉션 연산(= Collectors.toSet()을 쉽게 하기 위함)
    // collect() : stream의 요소들을 수집하여 특정 컬렉션이나 결과로 변환
    // Collectors.toSet() : stream의 요소들을 Set 자료형으로 수집
    // Collectors.collectingAndThen(...) : 첫 번째 인수로 주어진 수집기의 결과를 가져와, 두 번째 인수로 주어진 함수를 적용하여 최종 결과를 생성
    // pokemons -> Integer.min(pokemons.size(), nums.length / 2)
    // * 'pokemons'는 앞에서 Collectors.toSet() 로 수집된 고유한 pokemon들의 Set임!
    // * Integer.min(...) : '고유한 포켓몬 종류의 수'와 '선택가능한 최대의 수'를 비교하여 더 작은 수를 반환!



}
