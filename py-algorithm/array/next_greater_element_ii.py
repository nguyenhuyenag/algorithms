import unittest

from typing import List

"""
    https://leetcode.com/problems/next-greater-element-ii/

    Cho mảng số nguyên nums dạng vòng (phần tử tiếp theo của nums[nums.length - 1] là nums[0]),
    trả về số lớn hơn tiếp theo cho mỗi phần tử trong nums.

    Số lớn hơn tiếp theo của một số x là số lớn đầu tiên theo thứ tự duyệt tiếp theo của nó
    trong mảng, có nghĩa là bạn có thể tìm kiếm vòng tròn để tìm số lớn hơn tiếp theo của nó.
    Nếu không tồn tại, trả về -1 cho số này.

    Example: nums = [1,2,1] -> [2,-1,2]
"""


class Solution(unittest.TestCase):

    # Tìm số >= nums[index]
    def find_next(self, nums: List[int], index: int):
        for i in range(index, len(nums)):
            if nums[i] > nums[index]:
                return nums[i]

        for i in range(0, index):
            if nums[i] > nums[index]:
                return nums[i]

        return -1

    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        ans = []
        for i, v in enumerate(nums):
            ans.append(self.find_next(nums, i))

        return ans

    def test(self):
        self.assertEqual([2, -1, 2], self.nextGreaterElements([1, 2, 1]))


if __name__ == '__main__':
    unittest.main()
