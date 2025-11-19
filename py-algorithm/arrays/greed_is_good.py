import unittest
from typing import List
from collections import Counter

"""
    https://www.codewars.com/kata/5270d0d18625160ada0000e4/
    Quy tắc tính điểm xúc xắc:
             3 mặt 1 => 1000 points
             3 mặt 6 =>  600 points
        (1)  3 mặt 5 =>  500 points
             3 mặt 4 =>  400 points
             3 mặt 3 =>  300 points
             3 mặt 2 =>  200 points
            ----------------------
        (2)  1 mặt 1 =>  100 points
             1 mặt 5 =>   50 point
    Cho mảng số nguyên đại diện cho số mặt mỗi lần ném, tính tổng điểm (số mặt chỉ được tính 1 lần)
"""
class Solution(unittest.TestCase):

    def score(self, dice: List[int]) -> int:
        points = {1: 1000, 6: 600, 5: 500, 4: 400, 3: 300, 2: 200}
        counter = Counter(dice)
        total = 0
        for k, v in counter.items():
            # Nếu số lần >= 3 thì tính điểm theo theo quy tắc (1)
            if v >= 3:
                total += points[k] * (v // 3)

            # Phần còn dư lại thì tính theo quy tắc (2)
            if k == 1:
                total += 100 * (v % 3)
            elif k == 5:
                total += 50 * (v % 3)

        return total

    def test(self):
        self.assertEqual(250, self.score([5, 1, 3, 4, 1]))
        self.assertEqual(0, self.score([2, 3, 4, 6, 2]))
        self.assertEqual(1100, self.score([1, 1, 1, 3, 1]))
        self.assertEqual(450, self.score([2, 4, 4, 5, 4]))


if __name__ == '__main__':
    unittest.main()
