package algo.interview.a_string.most_common_word

class MostCommonWord02 {

    companion object {
        @JvmStatic
        fun main(args:Array<String>) {

            val p: String = "Ross hit a ball, the hit BALL flew far away after it was hit."
            val banned: Array<String> = arrayOf("hit")
            val result = mostCommonWord(p, banned)

            println(result)

        }

        fun mostCommonWord(p: String, banned: Array<String>): String {
            // 1. 각 단어별 개수가 저장될 키-값 맵
            val counts: MutableMap<String, Int> = mutableMapOf()

            // 2. 전처리 작업 후 단어 목록을 배열로 저장
            val words = p.replace("\\W+".toRegex(), " ").toLowerCase().trim().split(" ")

            // 3. ban 단어 제외하고 개수 count
            for (w in words) {
                // 3-1. 금지된 단어가 아니면 경우 개수 처리
                if (!banned.contains(w)) {
                    // 3-2. 존재하지 않는 단어면 기본값 0으로 지정
                    //      존재하는 단어면 추출한 값에 +1 하여 저장
                    counts[w] = counts.getOrDefault(w, 0) + 1
                }
            }

            // 4. 가장 흔하게 등장하는 단어 추출
            return counts.maxBy { it.value }!!.key
        }
    }
}