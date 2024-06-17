import itertools
import unittest

"""
    https://leetcode.com/problems/maximum-swap/

    Cho số nguyên dương n. Có thể hoán đổi 0 hoặc 2 chữ số  trong n. Tìm số lớn nhất.

    - Sinh tất cả hoán vị của n.
    - Tìm các hoán vị mà chỉ khác với n 2 vị trí.
    - Tìm số lớn nhất trong số đó.
"""


class Solution(unittest.TestCase):

    @staticmethod
    def has_exactly_two_differences(L1, L2):
        diff_count = sum(1 for a, b in zip(L1, L2) if a != b)
        return diff_count == 0 or diff_count == 2

    def maximumSwap(self, n: int) -> int:
        result = 0
        num_str = str(n)
        for p in itertools.permutations(num_str):
            # print(p)
            if self.has_exactly_two_differences(p, num_str):
                num = int(''.join(p))
                result = max(result, num)

        return result

    def test(self):
        # self.assertEqual(321, self.maximumSwap(123))
        self.assertEqual(9973, self.maximumSwap(9973))


if __name__ == '__main__':
    unittest.main()
