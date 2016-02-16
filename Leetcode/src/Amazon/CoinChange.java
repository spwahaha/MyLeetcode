package Amazon;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(coins == null || amount < 0 || coins.length == 0){
            return -1;
        }
        if(amount == 0) return 0;
        int[] times = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            times[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i && times[i - coins[j]] != Integer.MAX_VALUE){
                    times[i] = Math.min(times[i], 1 + times[i - coins[j]]);
                }   
            }
        }
        int res = times[amount] == Integer.MAX_VALUE ? -1 : times[amount];
        return res;
    }
}
