import unittest

from typing import List

"""
    https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

    Cho mảng số nguyên không âm. Trả về x nếu tồn tại ĐÚNG x phần tử có giá trị >= x,
    ngược lại thì trả về -1.

    Ví dụ 1: arr = [3, 5] => 2 (vì có đúng hai số 3, 5 đều lớn hơn 2).

    Ví dụ 2: arr = [0, 0] => -1, bởi vì:
        + Nếu x = 0 thì phải tồn tại 0 số >= x, nhưng tồn tại 2 số.
        + Nếu x = 1 thì phải tồn tại 1 số >= x, nhưng không tồn tại.
        + Nếu x = 2 thì phải tồn tại 2 số >= x, nhưng không tồn tại.
"""


class Solution(unittest.TestCase):

    @staticmethod
    def count_greater(arr: List[int], val: int) -> int:
        # return sum(1 for num in nums if num >= val)
        return sum(map(lambda x: x >= val, arr))

    def specialArray(self, nums: List[int]) -> int:
        for i in range(len(nums) + 1):
            if self.count_greater(nums, i) == i:
                return i

        return -1

    def test(self):
        self.assertEqual(2, self.specialArray([3, 5]))
        self.assertEqual(-1, self.specialArray([0, 0]))


if __name__ == '__main__':
    unittest.main()
