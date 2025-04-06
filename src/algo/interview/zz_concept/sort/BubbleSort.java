package algo.interview.zz_concept.sort;

public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int[] result = bubbleSort(arr);
        for(int num : arr) {
            System.out.println(num);
        }
    }

    // Time Complexity : O(N^2)
    public static int[] bubbleSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for(int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }
}
