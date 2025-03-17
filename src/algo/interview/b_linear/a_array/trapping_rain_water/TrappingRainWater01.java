package algo.interview.b_linear.a_array.trapping_rain_water;

public class TrappingRainWater01 {
    public static void main(String[] args) {
        int[] height = {1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int totalVolume = trap(height);
        System.out.println(totalVolume);
    }

    public static int trap(int[] height) {

        int volume = 0;

        // two pointer
        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        // 투포인터가 서로 만날 때까지 반복 => O(N)
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            // **더 높은 쪽을 향해 투포인터 이동**
            if (leftMax <= rightMax) {
                // 왼쪽 막대 최대 높이와의 차이를 더하고 왼쪽 포인터 이동
                volume += leftMax - height[left];
                left += 1;
            } else {
                // 오른쪽 막대 최대 높이와의 차이를 더하고 오른족 포인터 이동
                volume += rightMax - height[right];
                right -= 1;
            }
        }
        return volume;
    }
}
