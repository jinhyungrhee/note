package algo.interview.zz_concept.binary_search;

public class LowerBound {
    static int arr[] = {1, 3, 5, 7, 8, 10, 20, 35, 35, 35, 99, 100};

    public static void main(String[] args) {
        System.out.println(lowerBound(35));
    }

    /**
     * Lower Bound
     * arr[i] ≥ x를 만족하는 가장 작은 i
     */
    public static int lowerBound(int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // 가장 첫번째 위치이므로 left 리턴
    }
}
