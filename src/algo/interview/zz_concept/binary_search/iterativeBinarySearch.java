package algo.interview.zz_concept.binary_search;

public class iterativeBinarySearch {
    static int arr[] = {1, 3, 5, 7, 8, 10, 20, 35, 99, 100};

    public static void main(String[] args) {
        System.out.println(iterativeBinarySearch(35, 0, arr.length - 1));
    }

    public static int iterativeBinarySearch(int key, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == arr[mid]) { // 탐색 성공ㄴ
                return mid;
            }
            else if (key < arr[mid]) { // 왼쪽 탐색
                high = mid - 1;
            }
            else { // 오른쪽 탐색
                low = mid + 1;
            }
        }
        return -1; // 탐색 실패
    }
}
