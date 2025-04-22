package algo.interview.zz_concept.binary_search;

public class recursiveBinarySearch {

    static int arr[] = {1, 3, 5, 7, 8, 10, 20, 35, 99, 100};

    public static void main(String[] args) {
        System.out.println(recursiveBinarySearch(5, 0, arr.length - 1));
    }

    public static int recursiveBinarySearch(int key, int low, int high) {

        int mid;
        if (low <= high) {

            mid = (low + high) / 2;
            if (key == arr[mid]) { // 탐색 성공
                return mid;
            }
            else if (key < arr[mid]) { // 왼쪽부분 탐색
                return recursiveBinarySearch(key, low, mid - 1);
            }
            else { // 오른쪽부분 탐색
                return recursiveBinarySearch(key, mid + 1 , high);
            }

        }
        return -1; // 탐색 실패
    }
}
