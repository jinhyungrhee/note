package algo.interview.b_linear.a_array.best_time_to_buy_and_sell_stock;

public class BestTimeToBuyAndSellStock02 {

    // 2 - 저점과 현재 값과의 차이 계산
    public static void main(String[] args) {
        int[] prices = {8, 1, 5, 3, 6, 4};

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(maxProfit, (price - minPrice));
        }

        System.out.println(maxProfit);
    }
}
