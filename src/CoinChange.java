import java.util.Arrays;

public class CoinChange {
    
    public int noOfWays(int coins[], int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // There's one way to make change for 0.

        // Iterate through each coin denomination.
        for (int coin : coins) {
            // Iterate through each amount from 'coin' to 'amount'.
            for (int i = coin; i <= amount; i++) {
                // Add the ways to make change for the current amount.
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
    
    public int minimumCoins(int coins[], int amount) {
        // Create an array to store minimum coin counts for each amount from 0 to 'amount'.
        int[] dp = new int[amount + 1];
        // Initialize all values to an arbitrary large number (amount + 1).
        Arrays.fill(dp, amount + 1);
        // The minimum number of coins needed to make change for 0 is 0.
        dp[0] = 0;
        
        // Iterate through each coin denomination.
        for (int coin : coins) {
            // Iterate through each amount from 'coin' to 'amount'.
            for (int i = coin; i <= amount; i++) {
                // Calculate the minimum number of coins needed for the current amount.
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        // If dp[amount] is still greater than 'amount', no valid coin combination exists.
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int maximumCoins(int coins[], int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0; // No coins needed to make change for 0.

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.max(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == Integer.MIN_VALUE ? -1 : dp[amount];
    }

    public static void main(String args[]) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        CoinChange ch = new CoinChange();
        System.out.println(ch.noOfWays(coins, amount));
        System.out.println(ch.minimumCoins(coins, amount));
        System.out.println(ch.maximumCoins(coins, amount));
    }
}