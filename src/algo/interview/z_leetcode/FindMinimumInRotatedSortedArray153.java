package algo.interview.z_leetcode;

public class FindMinimumInRotatedSortedArray153 {

    public static void main(String[] args) {

        int[] nums = {3 ,1, 2};
        System.out.println(findMin(nums));

    }

    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 오름차순인 경우
        if (nums[left] < nums[right]) return nums[left];
        // 오름차순이 아닌 경우 이진탐색
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                //right = mid - 1; // 이 경우, mid도 정답에 포함되어야 함
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
