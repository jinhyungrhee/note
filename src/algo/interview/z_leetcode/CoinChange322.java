package algo.interview.z_leetcode;

import java.util.*;
public class CoinChange322 {
    public static int INF = 987654321;

    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 1;
        System.out.println(coinChange03(coins, amount));
    }

    // 최적화2
    public static int coinChange03(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // 최대 개수는 (amount + 1)개를 넘지 않음

        dp[0] = 0;
        for (int coin : coins) {
            if (coin <= amount) dp[coin] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if ((i - coin) > 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return (dp[amount] == (amount + 1)) ? -1 : dp[amount];
    }

    // 최적화1
    public static int coinChange02(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;
        for (int coin : coins) {
            if (coin <= amount) dp[coin] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if ((i - coin) > 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return (dp[amount] == INF) ? -1 : dp[amount];
    }

    public static int coinChange01(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);

        dp[0] = 0;
        for (int coin : coins) {
            if (coin <= amount) dp[coin] = 1;
        }

        for (int i = 1; i <= amount; i++) {
            int minVal = INF;
            for (int coin : coins) {
                if ((i - coin) > 0) {
                    if (minVal > dp[i - coin]) minVal = dp[i - coin];
                }
            }
            dp[i] = Math.min(dp[i], minVal + 1);
        }
        return (dp[amount] == INF) ? -1 : dp[amount];
    }
}
