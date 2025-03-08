package algo.interview.a_string.reverse_string;

public class ReverseString01 {

    public static void main(String[] args) {

        char[] arr = {'a', 'b', 'c'};
        reverseString(arr);

    }

    private static void reverseString(char[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        System.out.println(arr);
    }


}
