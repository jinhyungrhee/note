package algo.interview.a_string.reorder_data_in_log_files

import java.util.*;
class ReorderData04 {

    companion object {
        @JvmStatic
        fun main(args:Array<String>) {

            var logs:List<String> = listOf("id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero");

            var reorderLogs:Array<String> = reorderLogFiles(logs);
            for (log in reorderLogs) {
                println(log)
            }
        }

        fun reorderLogFiles(logs:List<String>) :Array<String> {
            val letterList = mutableListOf<String>()
            val digitList = mutableListOf<String>()

            for (log in logs) {
                if (Character.isDigit(log.split(" ")[1][0])) {
                    digitList.add(log)
                } else {
                    letterList.add(log)
                }
            }

            // 문자 리스트 정렬 (Comparator 구현)
            letterList.sortWith(Comparator {s1:String, s2:String ->
                // '식별자', '그 외 부분' 두 개로 나눔
                val s1x = s1.split(" ", limit = 2)
                val s2x = s2.split(" ", limit = 2)

                /**
                 * kotlin은 별도의 return이 필요 없나..?
                 */
                // 문자 로그 사전순 비교
                val compared = s1x[1].compareTo(s2x[1])
                // 문자가 동일한 경우, 식별자 비교하여 우선 리턴
                if (compared == 0) {
                    s1x[0].compareTo(s2x[0])
                }
                else {
                    // 비교 대상의 순서가 동일한 경우 -> 0
                    // 비교 대상의 순서가 앞인 경우  ->  1
                    // 비교 대상의 순서가 뒤인 경우  -> -1
                    compared
                }
            })

            // 문자 리스트 뒤로 숫자 리스트 이어 붙이기
            letterList.addAll(digitList)
            // 리스트를 String 배열로 변환
            return letterList.toTypedArray()
        }
    }
}