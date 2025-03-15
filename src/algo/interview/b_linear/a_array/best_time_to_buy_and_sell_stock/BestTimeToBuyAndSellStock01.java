package algo.interview.b_linear.a_array.best_time_to_buy_and_sell_stock;

public class BestTimeToBuyAndSellStock01 {

    // 1-Brute Force => O(N^2)
    public static void main(String[] args) {
        int[] nums = {8, 1, 5, 3, 6, 4};

        int maxProfit = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if ((nums[j] - nums[i]) > maxProfit) {
                    maxProfit = (nums[j] - nums[i]);
                }
            }
        }
        System.out.println(maxProfit);
    }
}
