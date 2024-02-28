import math
import unittest

"""
    https://leetcode.com/problems/permutation-sequence/description/
    
    The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

    By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
        "123"
        "132"
        "213"
        "231"
        "312"
        "321"
    Given n and k, return the k-th permutation sequence.
"""
class Solution(unittest.TestCase):

    def getPermutation(self, n: int, k: int) -> str:
        ans = ""
        nums = [i for i in range(1, n + 1)]
        for i in range(1, n + 1):
            index = 0
            c = math.factorial(n - i)

            while c < k:
                index += 1
                k -= c

            ans += str(nums[index])
            del nums[index]

        return ans

    def test(self):
        self.assertEqual("213", self.getPermutation(3, 3))


if __name__ == '__main__':
    unittest.main()
