package algo.interview.a_string.reverse_string

class ReverseString02 {

    companion object {

        @JvmStatic
        fun main(args:Array<String>) {

            var arr:Array<Char> = arrayOf('a', 'b', 'c')
            reverseString(arr)


        }

        fun reverseString(arr:Array<Char>) {

            var start = 0
            var end = arr.size - 1

            while (start < end) {
                arr[start] = arr[end].also { arr[end] = arr[start] }
                start++
                end--
            }

            arr.forEach{ print(it) }
        }

    }
}

// * also *
// - 객체를 그대로 반환하면서 추가 작업을 수행할 수 있는 스코프 함수
// - arr[end]의 원래 값을 유지하면서 동시에 다른 작업을 수행할 수 있기 때문에 사용
// - 이 방식은 temp 변수를 사용하지 않고도 값을 교환할 수 있게 해줌