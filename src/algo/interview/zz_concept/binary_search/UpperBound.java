package algo.interview.zz_concept.binary_search;

public class UpperBound {
    static int arr[] = {1, 2, 2, 3, 3, 3, 5, 6, 8};

    public static void main(String[] args) {
        System.out.println(upperBound(3));
        System.out.println(upperBound2(3));
    }

    /**
     * Upper Bound
     * arr[i] > x 를 만족하는 가장 작은 i (-> 초과)
     *  즉, 특정 값 k보다 '처음으로 큰 값의 위치'를 찾는 알고리즘
     */
    public static int upperBound(int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 초과'의 의미를 더 잘 나타내기 위한 리팩토링
     */
    public static int upperBound2(int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) { // 중간값이 찾는값 보다 크면 왼쪽 탐색
                right = mid;
            } else { // (arr[mid] <= target) 중간값이 찾는값 보다 작거나 같으면 오른쪽 탐색
                left = mid + 1;
            }
        }
        return left;
    }
}
