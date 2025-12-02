import unittest

from typing import List

"""
    https://leetcode.com/problems/transform-array-by-parity/
    
    Cho một mảng số nguyên nums. Hãy biến đổi nums bằng cách thực hiện
    đúng theo thứ tự các thao tác sau:

        - Thay mỗi số chẵn bằng 0.
        - Thay mỗi số lẻ bằng 1.
        - Sắp xếp mảng đã được thay đổi theo thứ tự không giảm (tăng dần).

    Hãy trả về mảng thu được sau khi thực hiện các thao tác trên.
"""


class Solution(unittest.TestCase):

    def transformArray_OK(self, nums: List[int]) -> List[int]:
        result = [0] * len(nums)
        l, r = 0, len(nums) - 1
        for x in nums:
            if x % 2 == 0:
                result[l] = 0
                l += 1
            else:
                result[r] = 1
                r -= 1
        return result

    def transformArray_OK_1(self, nums: List[int]) -> List[int]:
        result = [0] * len(nums)  # Khởi tạo sẵn mảng [0, 0, 0, 0, ...]
        r = len(nums) - 1
        for x in nums:
            if x % 2 != 0:
                result[r] = 1
                r -= 1

        return result

    def transformArray(self, nums: List[int]) -> List[int]:
        return sorted(x % 2 for x in nums)

    def test_1(self):
        self.assertEqual([0, 0, 1, 1], self.transformArray([1, 2, 3, 4]))


if __name__ == '__main__':
    unittest.main()
