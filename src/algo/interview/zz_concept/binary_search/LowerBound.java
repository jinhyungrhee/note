package algo.interview.zz_concept.binary_search;

public class LowerBound {
    static int arr[] = {1, 2, 2, 3, 3, 3, 5, 6, 8};

    public static void main(String[] args) {
        System.out.println(lowerBound(3));
        System.out.println(lowerBound2(3));
    }

    /**
     * Lower Bound
     * arr[i] ≥ x를 만족하는 가장 작은 i (-> 이상)
     * 즉, 특정 값의 '시작위치'를 찾는 알고리즘
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

    /**
     *  '이상'의 의미를 더 잘 나타내기 위한 리팩토링
     */
    public static int lowerBound2(int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= target) { // 중간값이 찾는값 보다 크거나 같으면 왼쪽 탐색
                right = mid;
            } else { // (arr[mid] < target) 중간값이 찾는값 보다 작으면 오른쪽 탐색
                left = mid + 1;
            }
        }
        return left;
    }
}
