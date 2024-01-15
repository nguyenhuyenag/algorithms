package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.*;


/**
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 *
 * Cho mảng kết quả các trận đấu: matches = [[1, 2], [4, 2],...]
 *
 *      [1, 2] -> Người chơi 1 thắng người chơi 2
 *      [4, 2] -> Người chơi 4 thắng người chơi 2
 *
 * Tìm những người chơi chưa thua trận nào và những người chơi chỉ thắng được 1 trận
 */
public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winCount = new HashMap<>();
        Map<Integer, Integer> loseCount = new HashMap<>();
        List<Integer> winAll = new ArrayList<>();
        List<Integer> lostOnce = new ArrayList<>();
        for (int[] match : matches) {
            winCount.put(match[0], winCount.getOrDefault(match[0], 0) + 1);
            loseCount.put(match[1], loseCount.getOrDefault(match[1], 0) + 1);
        }
        // Không thua trận nào = Có win >= 1 và không nằm trong loseCount
        winCount.forEach((player, wins) -> {
            if (!loseCount.containsKey(player)) {
                winAll.add(player);
            }
        });
        // Thua đúng 1 trận
        loseCount.forEach((player, losses) -> {
            if (losses == 1) {
                lostOnce.add(player);
            }
        });
        Collections.sort(winAll);
        Collections.sort(lostOnce);
        return List.of(winAll, lostOnce);
    }

    @Test
    public void test() {
        // Kết quả: [[1,2,5,6], []]
        // int[][] matches = {{2, 3}, {1, 3}, {5, 4}, {6, 4}};

        // Kết quả: [[1,2,10], [4,5,7,8]]
        // int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};

        // Kết quả: [[1], [100000]]
        int[][] matches = {{1, 100000}};

        findWinners(matches);
    }

}
