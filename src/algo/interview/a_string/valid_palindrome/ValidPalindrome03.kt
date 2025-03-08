package algo.interview.a_string.valid_palindrome

class ValidPalindrome03 {

    companion object {

        @JvmStatic
        fun main(args:Array<String>) {

//            var s:String =  "Do geese see God?";
            var s:String =  "토마토";
            var result:Boolean = isPalindrome03(s);
            println(result);

        }

        fun isPalindrome03(s:String): Boolean{

            var start = 0;
            var end = s.length - 1;

            while (start < end) {

                when {
                    !Character.isLetterOrDigit(s[start]) -> start++
                    !Character.isLetterOrDigit(s[end]) -> end--
                    else -> {
                        if (Character.toLowerCase(s[start]) != Character.toLowerCase(s[end])) {
                            return false
                        }
                        // 예외케이스 어디에도 해당하지 않으면 한칸씩 이동
                        start++
                        end--
                    }
                }
            }
            return true;
        }

    }
}