package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
    https://www.codewars.com/kata/5a43126f8f27f2d77500006d/

    Given coins value n, we want to make change for n cents, and we have different
    types of coin type, how many ways can we make change from n coins to type?

    Example: Given n = 5 and type = [1,2,3] should return 5
    Explain : 5 coin can be exchange in 5 difference way from type, they are.

        5 = 1 + 1 + 1 + 1 + 1
        5 = 1 + 2 + 2
        5 = 1 + 1 + 3
        5 = 2 + 3
        5 = 1 + 1 + 1 + 2
 */
public class CoinsExchange {

    public static void main(String[] args) {
        // int n = 5;
        // int[] coins = {1, 2, 3};

        int n = 11;
        int[] coins = {1, 5, 10, 50, 100};

        List<List<Integer>> ways = countWaysToMakeChange(n, coins);

        System.out.println("Số cách đổi tiền: " + ways.size());
        for (List<Integer> way : ways) {
            System.out.println(way);
        }
    }

    public static List<List<Integer>> countWaysToMakeChange(int n, int[] coins) {
        List<List<List<Integer>>> dp = new ArrayList<>();

        // Khởi tạo dp cho các giá trị từ 0 đến n
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }

        // Có một cách để đổi tiền cho số lượng 0
        dp.get(0).add(new ArrayList<>());

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                for (List<Integer> way : dp.get(i - coin)) {
                    List<Integer> newWay = new ArrayList<>(way);
                    newWay.add(coin);
                    dp.get(i).add(newWay);
                }
            }
        }

        return dp.get(n);
    }

}
